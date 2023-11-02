public class Day15ZigZagConversion {
    public static void main(String[] args){
        String s = "abcdefijklmnopq";
        int numRows = 5;

        System.out.print(convert(s, numRows));
    }
    public static String convert(String s, int numRows) {
        //define StringBuilder
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++){
            sbs[i] = new StringBuilder();
        }
        //converting our string to character Array
        char[] arr = s.toCharArray();
        int n = arr.length, index = 0;
        
        //now traverse zig zag
        while(index < n){
            //go down
            for(int j=0; j<numRows && index < n; j++)
                sbs[j].append(arr[index++]);
            //now go up before start index
            //we starting j with numsRows-2 because we skipping for last and first row when going up
            for(int j=numRows-2; j > 0 && index < n; j--)
                sbs[j].append(arr[index++]);
        }
        //combining all stringbuilders into one
        StringBuilder res = sbs[0];
        for(int i=1; i<numRows; i++){
            res.append(sbs[i].toString());
        }
        return res.toString();
    }
}
