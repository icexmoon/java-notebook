package ch15.multi_vector2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[3][2];
        for (int i = 0; i < matrix.length; i++) {
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j] = (i+1)*(j+1);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
// [[1, 2], [2, 4], [3, 6]]