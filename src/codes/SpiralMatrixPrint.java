package codes;

import java.util.*;
import java.lang.*;
import java.io.*;
public class SpiralMatrixPrint {

    static void spiralPrint(int rowCount, int columnCount, int matrix[][]){
        //* complexity O(RC)

        int startRowIndex = 0;
        int endRowIndex = rowCount;
        int startColumnIndex = 0;
        int endColumnIndex = columnCount;

        while (startRowIndex < endRowIndex && startColumnIndex < endColumnIndex){

            //print first row from the remaining rows (going right)
            for (int i = startColumnIndex; i < endColumnIndex ; i++) {
                System.out.print(matrix[startRowIndex][i] + " ");
            }
            startRowIndex++;

            //print the last column from the remaining row(going down)
            for (int i = startRowIndex; i < endRowIndex; i++) {
                System.out.print(matrix[i][endColumnIndex-1] + " ");
            }
            endColumnIndex--;

            //print the last row from the remaining rows(going left)
            if(startRowIndex < endRowIndex){
                    for (int i = endColumnIndex - 1 ; i >= startColumnIndex; i--) {
                        System.out.print(matrix[endRowIndex-1][i] + " ");
                    }
                endRowIndex--;
            }

            //print the first column from the remaining columns (going up)
            if (startColumnIndex<endColumnIndex){
                for (int i = endRowIndex - 1; i >= startRowIndex ; i--) {
                    System.out.print(matrix[i][startColumnIndex] + " ");
                }
                startColumnIndex++;
            }

        }
    }

    static void rotateMatrix(int rowCount, int columCount, int matrix[][]){

        int startRowIndex = 0;
        int endRowIndex = rowCount;
        int startColumnIndex = 0;
        int endColumnIndex = columCount;
        int previous, current;

        while (startRowIndex < endRowIndex && startColumnIndex < endColumnIndex){

            if (startRowIndex + 1 == endRowIndex || startColumnIndex + 1 == endColumnIndex ) break;

            // Store the first element of next row, this element will replace first element of current row
            previous = matrix[startRowIndex + 1][startColumnIndex];

            /* Move elements of first row from the remaining rows (moving right) */
            for (int i = startColumnIndex; i < endColumnIndex; i++) {
                current = matrix[startRowIndex][i];
                matrix[startRowIndex][i] = previous;
                previous = current;
            }
            startRowIndex++;

            /* Move elements of last column from the remaining rows (moving down) */
            for (int i = startRowIndex; i < endRowIndex; i++) {
                current = matrix[i][endColumnIndex-1];
                matrix[i][endColumnIndex-1] = current;
                previous = current;
            }
            endColumnIndex--;

            /* Move elements of last row  from the remaining rows (moving left) */
            if (startRowIndex < endRowIndex){
                for (int i = endColumnIndex - 1; i >= startColumnIndex ; i--) {
                    current = matrix[endRowIndex - 1][i];
                    matrix[endRowIndex - 1 ][i] = previous;
                    previous = current;
                }
            }
            endRowIndex--;

            /* Move elements of first column from the remaining rows (moving up) */
            if (startColumnIndex < endColumnIndex){
                for (int i = endRowIndex - 1; i >= startRowIndex; i--) {
                    current = matrix[i][startColumnIndex];
                    matrix[i][startColumnIndex] = previous;
                    previous = current;
                }
            }
            startColumnIndex--;
        }

        // Print rotated matrix
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columCount; j++)
                System.out.print( matrix[i][j] + " ");
            System.out.print("\n");
        }


    }

    static boolean rotate(int[][] matrix){
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; //not a square
        int n = matrix.length;
        for (int layer = 0; layer < n / 2 ; layer ++){
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++ ){
                int offset = i - first;
                int top = matrix[first][i]; //save top
                matrix[first][i] = matrix[last - offset][first]; // left -> top
                matrix[last - offset][first] = matrix[last][last - offset]; //bottom -> left
                matrix[last][last - offset] = matrix[i][last]; //right -> bottom
                matrix[i][last] = top;  // right <- top
            }
        }
        return true;
    }

    public static void main (String[] args) {
        int R = 3;
        int C = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        spiralPrint(R,C,a);
        rotateMatrix(R,C,a);
    }
}
