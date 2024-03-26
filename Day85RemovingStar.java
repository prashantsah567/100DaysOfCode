public class Day85RemovingStar {

    public static void main(String[] args) {
        String str = "adfsd**sdfs*dfds***dfs*";

        System.out.println(removeStars(str));
    }

    public static String removeStars(String s) {
        StringBuilder str = new StringBuilder();
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch != '*') {
                if (count == 0) {
                    str.append(ch);
                } else {
                    count--;
                }
            } else {
                count++;
            }
        }

        return str.reverse().toString();
    }
}
