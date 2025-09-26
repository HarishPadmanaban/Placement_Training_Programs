package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n =8;
        boolean[][] board = new boolean[n][n];
        List<List<String>> al = new ArrayList<>();
        System.out.println(Queens(board,0,al));
        System.out.println(al);
    }
    static int Queens(boolean[][] board,int r,List<List<String>> al )
    {
        if(r==board.length)
        {
            al.add(new ArrayList<>(display(board)));
            System.out.println();
            return 1;
        }
        int count =0;
        for(int col=0;col<board.length;col++)
        {
            if(isSafe(board,r,col))
            {
                board[r][col] = true;
                count += Queens(board,r+1,al);
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
    static List<String> display(boolean board[][])
    {
        List<String> l = new ArrayList<>();
        for(boolean[] arr:board)
        {
            String s = "";
            for(boolean e : arr)
            {

                if(e)
                {
                    s += "Q";
                    //System.out.print("Q ");
                }
                else {
                    s += ".";
                    //System.out.print(". ");
                }
            }
            l.add(s);
            //System.out.println();
        }
        //System.out.println(l);
        return l;
    }
}
