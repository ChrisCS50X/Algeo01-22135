package functions;

public class operations {
    public static double[][] extendMatrix(double[][] Matrix1, double[][] Matrix2) {
        double[][] extended;
        int Row, Column, i, j;
        Row = Matrix1.length;
        Column = Matrix1[0].length + Matrix2[0].length;

        extended = new double[Row][Column];
        for (i = 0; i < Row; i++) {
            for (j = 0; j < Column; j++){
                if (j < Matrix1[0].length){
                    extended[i][j] = Matrix1[i][j];
                } else {
                    extended[i][j] = Matrix2[i][j-Matrix1[0].length];
                }
            }
        }
        return extended;
    }
    
    public static double [][] MultiplyMatrix (double[][] matrix1, double[][] matrix2){
        int Row = matrix1.length;
        int Column = matrix2 [0].length;
        int i,j,k;
        double [][] m3 = new double [Row] [Column];
        for (i = 0 ; i < Row ; i++){
            for (j = 0 ; j < Column ; j++){
                m3[i][j] = 0;
                for (k = 0 ; k < matrix1[0].length ; k++){
                    m3[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return m3;
    } 
}