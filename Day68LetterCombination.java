import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day68LetterCombination {
    // to store the final result
    static List<String> res = new ArrayList<>();
    // mapping digits to its corresponding values
    static Map<String, String> hm = new HashMap<>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    static List<String> letterCombinations(String digits) {

        // base condition when digit size is 0
        if (digits.length() == 0) {
            return res;
        }

        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    static void backtrack(String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            res.add(current.toString());
            return;
        }
        String letters = hm.get(String.valueOf(digits.charAt(index)));
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2345"));
    }
}
