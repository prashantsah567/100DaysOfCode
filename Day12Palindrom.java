public class Day12Palindrom {
    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);
        if (result) System.out.print("is a palindrome");
        else System.out.print("not a palindrome");

    }
    public static boolean isPalindrome(String s) {
        int first = 0, last = s.length()-1; //two pointer approach
        while(first < last){
            //checking for non letter or digit which we are ignoring
            while(first < last && !Character.isLetterOrDigit(s.charAt(first)))
                first++;
            while(first < last && !Character.isLetterOrDigit(s.charAt(last)))
                last--;
            //now checking for the letters or digit if they are equal or not
            if(Character.toLowerCase(s.charAt(first)) != Character.toLowerCase(s.charAt(last)))
                return false;
            first++;
            last--;
        }
        return true;
    }
}
