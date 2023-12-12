import java.util.Arrays;
import java.util.Comparator;

public class Day36MinNumberOfArrows {
    public static void main(String[] args){
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};

        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
        //check base case
        if (points == null || points.length == 0) {
            return 0;
        }
        //sort the array based on end value of each interval
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int res = 1;//initialize result with 1
        int arrowLimit = points[0][1];//set limit as end value of first interval

        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];

            // Check for overlap - (only incrementing res when there is no overlap)
            if (start > arrowLimit) {
                res++;
                arrowLimit = end;//update the arrowlimit as the current end value
            }
        }
        return res;
    }
}
