//String Comparator
public class Day24StringComparator {
    public static int compareStrings(String s1, String s2) {
        return processString(s1).equals(processString(s2)) ? 1 : 0;
    }

    private static String processString(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String s1 = "ab#c";
        String s2 = "ad#c";
        System.out.println(compareStrings(s1, s2)); // Output: 1 (true)
    }
}
