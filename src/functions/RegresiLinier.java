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

    public static void OutputRegresi(double[] matrix){
        System.out.println("Hasil dari regresi berganda adalah: ");
        int len = matrix.length;
        String output = "";

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
        System.out.println(output);
    }


    //Buat Debugging
    /* 
    public static void Printmatrix(double[] M){
        //Mengeluarkan output matrix
            for (int i = 0; i < M.length;i++){
                    System.out.print(M[i] + " ");
                }
                System.out.println();
            }

    public static void main(String[] args) {
        // Create a test matrix
        double[][] testMatrix = {
            {1,10},{3,14},{4,15},
            {6,18},{7,20}
        };

        double[] y = {
            9,10,13,14,16
        };

        // Calculate the determinant using your function
        double [] interpolasi = Regresiganda(testMatrix,y);

        // Print the result
        Printmatrix(interpolasi);
        OutputRegresi(interpolasi); 
    } */
}
