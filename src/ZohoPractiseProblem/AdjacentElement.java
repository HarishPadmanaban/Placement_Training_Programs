package ZohoPractiseProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacentElement {
    public static void main(String[] args) {
        // Input matrix
        int arr[][] = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 1, 1}
        };

        int m = arr.length;
        int n = arr[0].length;

        // Create a new result matrix to store the final state
        int[][] result = new int[m][n];

        // Copy the original matrix into result matrix to retain original values for reference
        for (int i = 0; i < m; i++) {
            result[i] = Arrays.copyOf(arr[i], n);
        }

        // Now process the matrix and modify the result matrix based on the original
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    // Set adjacent cells to 0 in the result matrix
                    if (i - 1 >= 0) result[i - 1][j] = 0;  // Above
                    if (i + 1 < m) result[i + 1][j] = 0;   // Below
                    if (j - 1 >= 0) result[i][j - 1] = 0;   // Left
                    if (j + 1 < n) result[i][j + 1] = 0;   // Right
                }
            }
        }

        // Print the final result matrix
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
