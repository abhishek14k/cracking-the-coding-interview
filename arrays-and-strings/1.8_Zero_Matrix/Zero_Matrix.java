/*
Problem Statement:
Write an algorithm such that if an element in an M*N matrix is 0, its entire row and column set to 0.
*/

public class Zero_Matrix {

    public void zeroMatrix(int[][] matrix) {

        //check 1st row & 1st col has zero
        boolean row1_has_zero = false;
        boolean col1_has_zero = false;

    }

    public static void main(String[] args) {

        int[][] matrix = {
                {0,3,3},
                {3,3,3},
                {3,3,0},
        };
        Zero_Matrix zm = new Zero_Matrix();
        zm.zeroMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
