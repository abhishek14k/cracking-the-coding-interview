/*
Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
Can you do this in place?
*/

public class Rotate_Matrix {

    public void rotate90(int[][] matrix) {

        int len = matrix.length;
        int temp = 0;

        //Step 1>Transpose
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Step 2>Swap values in each row
        for (int i = 0; i < len; i++) {
            for (int j = 0, k = len-1; j < len/2; j++, k--) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }

    public static void main(String[] args) {
        //Original Input Matrix
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,1,2,3},
                {4,5,6,7}
        };

        Rotate_Matrix rm = new Rotate_Matrix();
        rm.rotate90(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
