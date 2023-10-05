package functions;
public class RegresiLinier {
    public static double[] Regresiganda (double[][] matrix, double [][] hasily){
        /*  Menghasilkan nilai dari b0,b1,b2,...bn dengan memanfaatkan Normal Estimation 
        Equation for Multiple Linear Regression */
        
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
            matrixtemp[i][col + 1] = hasily[i][0];
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
        // Menghasilkan nilai estimasi dari nilai-nilai yang diketahui (input dari nilai-nilai)

        double result;
        int n = input.length;

        result = function[0];

        for (int i=0;i<n;i++) {
            result += function[i+1]*input[i];
        }
        
        return result;
    }

    public static String OutputRegresi(double[] matrix){
        // Mengeluarkan output berupa persamaan regresi berganda

        int len = matrix.length;
        String output = "Hasil dari regresi berganda adalah:\n";

        output += matrix[0];

        for (int i = 1; i<len;i++){
            boolean IsNeg = false;

            if (matrix[i] < 0){
                output += " - ";
                matrix[i] *= -1;
                IsNeg = true;
            }

            else {
                output += " + ";
            }
            
            output += matrix[i] + "*x" + i; 

            if (IsNeg == true){
                matrix[i] *= -1;
            }
        }
        return output;
    }
}
