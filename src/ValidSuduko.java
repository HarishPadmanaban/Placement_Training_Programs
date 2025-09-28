import java.util.ArrayList;
import java.util.List;

public class ValidSuduko {
    public static void main(String[] args) {
        char [][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean row = checkRow(board);
        boolean col = checkCol(board);
        System.out.println(row);
        if(!row){
            System.out.println("Row has duplicate");
            return;
        }
        if(!col){
            System.out.println("Col has duplicate");
            return;
        }
        System.out.println(col);
        for (int i = 0; i <9 ; i+=3) {
            boolean grid = checkGrid(board,i,i+2);
            if(!grid){
                System.out.println("Grid has duplicate");
                return;
            }
            System.out.println(grid);
        }
        System.out.println("Valid");
    }

    private static boolean checkGrid(char[][] board,int s,int e) {
        System.out.println(s+" "+e);
        List<Character> li = new ArrayList<>();
        for (int i = s; i <=e ; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j]=='.') continue;
                if(li.contains(board[i][j])){
                    return false;
                }
                else{
                    li.add(board[i][j]);
                }
            }
        }
        li.clear();
        for (int i = s; i <=e ; i++) {
            for (int j = 3; j <6 ; j++) {
                if(board[i][j]=='.') continue;
                if(li.contains(board[i][j])){
                    return false;
                }
                else{
                    li.add(board[i][j]);
                }
            }
        }
        li.clear();
        for (int i = s; i <=e ; i++) {
            for (int j = 6; j <9 ; j++) {
                if(board[i][j]=='.') continue;
                if(li.contains(board[i][j])){
                    return false;
                }
                else{
                    li.add(board[i][j]);
                }
            }

        }
        return true;
    }

    private static boolean checkCol(char[][] board) {
        for (int i = 0; i < 9; i++) {
            List<Character> li = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if(board[j][i]=='.') continue;
                if(li.contains(board[j][i])){
                    return false;
                }
                else{
                    li.add(board[j][i]);
                }
            }
        }
        return true;
    }

    private static boolean checkRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            List<Character> li = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.') continue;
                if(li.contains(board[i][j])){
                    return false;
                }
                else{
                    li.add(board[i][j]);
                }
            }
        }
        return true;
    }
}
