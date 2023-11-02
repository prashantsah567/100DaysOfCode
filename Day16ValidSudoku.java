import java.util.HashSet;
import java.util.Set;

public class Day16ValidSudoku {
    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        System.out.print(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        //declaring a hashset to store the unique values from board
        Set<String> seen = new HashSet<>();

        for(int i=0; i<9; i++){ //outer loop goes from first to last row
            for(int j=0; j<9; j++){ //inner loop goes from first to last column
                char num = board[i][j]; 

                if(num != '.'){ //if the current character is '.' we ignore it
                //we add num at current row (i), current column (j) and current box of 3X3 grid
                //which we do by diving both row and column by 3
                //if any of these fails to add to the hashset we return false
                    if(!seen.add(num +"at row" + i)||
                       !seen.add(num +"at col" + j) ||
                       !seen.add(num+"at box" + i/3 + "-" + j/3)){
                           return false;
                       }
                }
            }
        }
        return true; //if all the elements are unique and on row, column and box (3X3)
    }
}
