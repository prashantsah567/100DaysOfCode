import java.util.ArrayList;
import java.util.List;

public class Day21SpiralMatrix {

    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }
    
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        //using four pointers
        int left = 0, right = matrix[0].length-1, top = 0, bottom = matrix.length-1;

        while(left <= right && top <= bottom){
            //move right
            for(int i=left; i <= right; i++){
                result.add(matrix[top][i]);
            }
            top++;
            //move down
            for(int i=top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;
            //move left
            if(top <= bottom){
                for(int i=right; i >= left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //move up
            if(left <= right){
                for(int i=bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
