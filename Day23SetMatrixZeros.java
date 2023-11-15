public class Day23SetMatrixZeros {
    public static void main(String[] args){
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);  
        printMatrix(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;//row size
        int cols = matrix[0].length;//column size
        int col0 = 1; //first column marked 1-true, 0-false

        //first we mark the the edge row and column cell as zero
        for(int i=0; i<rows; i++){
            if(matrix[i][0] == 0) col0 = 0; //col0 marked as false
            for(int j=1; j<cols; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0; //setting topmost as 0
                    matrix[i][0] = 0; //setting leftmost as 0
                }
            }
        }
        //then we revisit those cell in reverse order 
        //and mark the whole row and column as zero
        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1; j>=1; j--){//we don't need to visit the first column as they are already marked 0
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if(col0 == 0) matrix[i][0] = 0; //if the col is 0 (false) we mark the cell as 0
        }
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
