import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int [][] arr = {{1,2,3,4,5},{6,7,0,9,10},{11,12,13,14,15},{56,0,45,67,9},{23,4,6,89,5}};
        //matrix = [[0,2,3,4,5],
        //          [6,7,0,9,10],
        //          [11,12,13,14,15]
        //          [56,0,45,67,9]
        //          [23,4,6,89,5]
        //          ]
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
        setZero(arr);
    }

    private static void setZero(int[][] arr) {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        for (int c = 0; c < arr[0].length; c++) {
            if (arr[0][c] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int c = 0; c < arr.length; c++) {
            if (arr[c][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                if(arr[i][j]==0){
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        for(int i =1;i<arr.length;i++)
        {
            if(arr[i][0]==0){
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println();
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        for(int i =1;i<arr[0].length;i++)
        {
            if(arr[0][i]==0){
                for (int j = 0; j < arr.length; j++) {
                    arr[j][i] = 0;
                }
            }
        }
        System.out.println(firstRowHasZero+" "+firstColHasZero);

        if(firstRowHasZero){
            for(int i =0;i<arr[0].length;i++)
            {
                arr[0][i] = 0;
            }
        }

        if(firstColHasZero){
            for(int i =0;i<arr.length;i++)
            {
                arr[i][0] = 0;
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
