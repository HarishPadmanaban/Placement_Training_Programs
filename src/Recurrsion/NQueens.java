package Recurrsion;

public class NQueens {
    public static void main(String[] args) {
        int n =8;
        boolean[][] board = new boolean[n][n];
        System.out.println(Queens(board,0));
    }
    static int Queens(boolean[][] board,int r)
    {
        if(r==board.length)
        {
            display(board);
            System.out.println();
            return 1;
        }
        int count =0;
        for(int col=0;col<board.length;col++)
        {
            if(isSafe(board,r,col))
            {
                board[r][col] = true;
                count += Queens(board,r+1);
                board[r][col]=false;


            }
        }
        return count;
    }
    static boolean isSafe(boolean[][] board,int r,int c)
    {
        for(int i=0;i<=r;i++)
        {
            if(board[i][c])
            {
                return false;
            }
        }
        int m = r;
        int n = c;
        while(m>=0&&n>=0)
        {
            if(board[m][n])
            {
                return false;
            }
            m--;
            n--;
        }

        m = r;
        n = c;
        while(m< board.length&&n< board.length&&m>=0)
        {
            if(board[m][n])
            {
                return false;
            }
            m--;
            n++;
        }
        return true;
    }
    static void display(boolean board[][])
    {
        for(boolean[] arr:board)
        {
            for(boolean e : arr)
            {
                if(e)
                {
                    System.out.print("Q ");
                }
                else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
