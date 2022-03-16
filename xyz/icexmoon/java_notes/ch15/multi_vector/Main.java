package ch15.multi_vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[3][2];
        for (int i = 0; i < matrix.length; i++) {
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j] = (i+1)*(j+1);
            }
        }
        System.out.println(Arrays.toString(matrix));
    }
}
// [[I@5ca881b5, [I@24d46ca6, [I@4517d9a3]
