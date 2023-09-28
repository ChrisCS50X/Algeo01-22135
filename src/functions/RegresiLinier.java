package functions;
public class RegresiLinier {
    public static double[] Regresiganda (double[][] matrix, double [] hasily){
        int row,col;
        row = matrix.length;
        col = matrix[0].length;

        double[][]matrixtemp = new double[row][col+2];

        for (int i = 0; i<row;i++){
            matrixtemp[i][0] = 1; 
        }


        for (int i = 0; i < row ; i++){
            for (int j = 1; j < col + 1 ; j++){
                matrixtemp [i][j] = matrix[i][j-1]; 
            }
        }

        for (int i = 0; i < row ; i++){
            matrixtemp[i][col + 1] = hasily[i];
        }

        double[][] newtemp = new double[col + 1][col + 2];

        for (int i = 0; i < col+1; i++) {
            for (int j = 0; j < col + 2; j++) {
                newtemp[i][j] = 0;
                for (int k = 0; k < row; k++) {
                    newtemp[i][j] += matrixtemp[k][i] * matrixtemp[k][j];
                }
            }
        }
        newtemp = SPL.gaussJordanElim(newtemp);

        int x = newtemp[0].length-1;
        double[] result = new double[x];

        for (int i = 0; i < x; i++) {
            result[i] = newtemp[i][x];
        }
        return result;
    }


    public static double FungsiRegresi(double[] function, double[] input) {
        double result;
        int n = input.length;

        result = function[0];

        for (int i=0;i<n;i++) {
            result += function[i+1]*input[i];
        }
        
        return result;
    }
}
