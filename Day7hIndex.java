import java.util.Arrays;

public class Day7hIndex {
    public static void main(String[] args){
        int[] citations = {1, 0, 2, 5, 4, 3};
        System.out.print(hIndex(citations));
    }
    public static int hIndex(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);
        int i=0;
        //we are going from start to end, 
        //however we are checking the values from end to start and 
        //whenver our current index value becomes less than current index we exit the loop and return
        while(i<len && citations[len-1-i] > i){
            i++;
        }
        return i;
    }
}
