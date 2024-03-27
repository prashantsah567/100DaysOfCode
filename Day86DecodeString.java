import java.util.Stack;

public class Day86DecodeString {

    public static void main(String[] args) {
        String s = "2[ac]3[4[ad]]";

        System.out.println("The resulted decoded string is: " + decodeString(s));
    }

    public static String decodeString(String s) {

        Stack<Integer> numberStack = new Stack<>(); // to store the numbers
        Stack<String> stringStack = new Stack<>(); // to store other characters: alphabets and [ ]
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = (num * 10) + (ch - '0'); // Accumulate the number
                continue;
            }

            if (ch == '[') {
                numberStack.push(num); // push num into the number stack
                num = 0; // set num to 0 for next operation
                stringStack.push(String.valueOf(ch)); // and [ into stringStack
                continue;
            }

            if (ch != ']') { // keep pushing characters until we find ']'
                stringStack.push(String.valueOf(ch));
                continue;
            }

            // when we find ']', we take out the characters until we find '['
            // and repeat it for 'num' times from the numberStack

            StringBuilder tempString = new StringBuilder();

            while (!stringStack.peek().equals("[")) {
                tempString.insert(0, stringStack.pop());
            }

            stringStack.pop(); // to remove the '['

            StringBuilder newStr = new StringBuilder(); // get the new string
            int count = numberStack.pop(); // get the repeatition count

            for (int i = 0; i < count; i++) {
                newStr.append(tempString);
            }

            stringStack.push(newStr.toString()); // push back the newStr string into stack
        }

        // to get the final result, need to take out all the string from the stringStack
        StringBuilder result = new StringBuilder();

        while (!stringStack.empty()) {
            result.insert(0, stringStack.pop());
        }

        return result.toString();
    }
}
