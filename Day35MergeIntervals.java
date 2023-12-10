import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day35MergeIntervals {
    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] results = merge(intervals);

        for(int[] result: results){
            System.out.println(Arrays.toString(result));
        }
        
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1){//base case
            return intervals;
        }
        //sort the intervals based on start values
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();//to store result of integer type array

        for(int i=0; i<intervals.length; i++){
            int startVal = intervals[i][0];
            int endVal = intervals[i][1];
            //loop to check overlap that keeps updating endVal until the condition meets
            while(i < intervals.length-1 && endVal >= intervals[i+1][0]){
                endVal = Math.max(endVal, intervals[i+1][1]);
                i++;
            }
            //add the new interval to the result list
            result.add(new int[]{startVal, endVal});
        }
        //finally return the list as an array
        return result.toArray(new int[result.size()][]);
    }
}
