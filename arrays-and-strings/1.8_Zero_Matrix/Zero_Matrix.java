/*
Problem Statement:
Write an algorithm such that if an element in an M*N matrix is 0, its entire row and column set to 0.
*/

public class Zero_Matrix {

    //Method to nullify entire row
    public void nullifyRow(int[][] matrix, int row) {
        for (int col = 0; col < matrix[row].length; col++) {
            matrix[row][col]=0;
        }
    }

    //Method to nullify entire column
    public void nullifyCol(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col]=0;
        }
    }

    public void zeroMatrix(int[][] matrix) {

        boolean row1_has_zero = false;
        boolean col1_has_zero = false;

        //Step 1: Check if 1st Row has Zero
        for (int row = 0; row < matrix[row].length; row++) {
            if(matrix[row][0] == 0) {
                row1_has_zero = true;
            }
        }

        //Step 2: Check if 1st Column has Zero
        for (int col = 0; col < matrix[col].length; col++) {
            if(matrix[0][col] == 0) {
                col1_has_zero = true;
            }
        }

        //Step 3: Check if remaining cells have zero & set first col of that row + first row of that column to Zero
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        /* After Step 3:
        *   0 3 0
            3 3 3
            3 3 3
            0 3 0
        * */

        //Step 4: Read through 1st row & set entire row to Zero
        for (int row = 1; row < matrix.length; row++) {
            if(matrix[row][0] == 0) {
                nullifyRow(matrix, row);
            }
        }
        /* After Step 4:
        *   0 3 0
            3 3 3
            3 3 3
            0 0 0
        * */

        //Step 5: Read through 1st col & set entire col to Zero
        for (int col = 1; col < matrix[0].length; col++) {
            if(matrix[0][col] == 0) {
                nullifyCol(matrix, col);
            }
        }
        /* After Step 5:
        *   0 3 0
            3 3 0
            3 3 0
            0 0 0
        * */

        //Step 6: Nullify 1st row if it contains Zero
        if(row1_has_zero) {
            nullifyRow(matrix, 0);
        }
        /* After Step 6:
        *   0 0 0
            3 3 0
            3 3 0
            0 0 0
        * */

        //Step 7: Nullify 1st col if it contains Zero
        if(col1_has_zero) {
            nullifyCol(matrix, 0);
        }
        /* After Step 7:
        *   0 0 0
            0 3 0
            0 3 0
            0 0 0
        * */
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {0,3,3},
                {3,3,3},
                {3,3,3},
                {3,3,0}
        };
        Zero_Matrix zm = new Zero_Matrix();
        zm.zeroMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
