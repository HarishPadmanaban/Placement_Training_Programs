package Sample;

import java.util.Arrays;
import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int row = (int)Math.ceil((double) s.length() /col);
        char letterArray[][] = new char[row][col];
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(k==s.length()) break;
                char ch = s.charAt(k++);
                if(Character.isWhitespace(ch)){
                    letterArray[i][j] = '*';
                }
                else{
                    letterArray[i][j] = ch;
                }
            }
        }
        if(k<(row*col))
        {
            char temp[] = letterArray[row-1];
            for (int i = 0; i < col; i++) {
                if(!Character.isLetter(temp[i]))
                    temp[i] = '.';
            }
            letterArray[row-1] = temp;
        }
        for (int i = 0; i < letterArray.length; i++) {
            System.out.println(Arrays.toString(letterArray[i]));
        }
        StringBuilder str = new StringBuilder(col+"");
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                str.append(letterArray[j][i]);
            }
        }
        System.out.println(str);
    }
}
