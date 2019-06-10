package bytebybyte.array;

public class ZeroMatrix {


    private static void setZeros(int[][] matrix){

        //two arrays to keep track of all the rows with zeros and all the columns with zeros
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        //store row and column index with value zero
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        //Nullify rows
        for (int i = 0; i < matrix.length; i++)
            if (row[i])
                nullifyRow(matrix,i);

        //Nullify columns
        for (int j = 0; j < matrix[0].length; j++)
            if (column[j])
                nullifyColumn(matrix,j);
    }

    private static void nullifyRow(int[][] matrix, int row){
        for (int j = 0; j < matrix[0].length; j++)
            matrix[row][j] = 0;
    }

    private static void nullifyColumn(int[][] matrix, int column){
        for (int i = 0; i < matrix.length; i++)
            matrix[i][column] = 0;
    }
}
