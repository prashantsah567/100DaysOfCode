public class Day57EditDistance {
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        return calcMinDistance(word1, word2, len1, len2);
    }
    //method that calculate and return the minimum number of operations required to convert word1 to word2
    private static int calcMinDistance(String s1, String s2, int l1, int l2){
        //we are using dp - tabulation solution
        int[][] dptable = new int[l1+1][l2+1];
        //initialize the first column with i value, it's the case when word2 is empty
        for(int i=0; i<=l1; i++){
            dptable[i][0] = i;
        }
        //initialize the first row with j value, it's the case when word1 is empty
        for(int j=1; j<=l2; j++){
            dptable[0][j] = j;
        }
        //now the rest of the table needs to be populated
        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    //this means we are not making any change and simply copying the diagonal value
                    dptable[i][j] = dptable[i-1][j-1];
                }else{
                    //this is when we need to make a change (insert, update or delete) and we choose the min value 
                    //from them by comparing diagonal, top and left value
                    dptable[i][j] = 1 + Math.min(dptable[i-1][j-1], Math.min(dptable[i-1][j], dptable[i][j-1]));
                }
            }
        }
        return dptable[l1][l2];//the last entry is the final result
    }

    public static void main(String[] args){
        String s1 = "CAT";
        String s2 = "CUT";

        System.out.println(minDistance(s1, s2));
    }
}
