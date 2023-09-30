package functions;
import java.lang.Math;

public class InterpolasiPolinom {

    public static double[] Interpolate (double[][]matrix){
    // Menghasilkan a0,a1,a2,an dan dikumpulkan dalam suatu matrix
        int i,j;
        int n = matrix.length;
        int row = n;
        int col = n;

        double [][] temp = new double[row][col+1];

        for (i = 0 ; i < row ; i++){
            for (j = 0 ; j < col + 1 ; j++){
                if (j == col){
                    temp[i][j] = matrix[i][1];
                }
                else{
                    temp[i][j] = Math.pow(matrix[i][0], j);
                }
            }
        }

        double [][] newtemp = SPL.gaussJordanElim(temp);

        double [] hasil = new double[row];
        for (i = 0; i < row ; i++){
            hasil[i] = newtemp [i][col];
        }

        return hasil;
    }

    public static double estimasi (double[]matrix, double x){
    //Menghitung estimasi nilai fungsi pada x
        int n,i;
        double hasil = 0;
        n = matrix.length;

        for (i = 0; i < n ; i++){
            hasil += matrix[i] * Math.pow(x,i);
        }
        return hasil;
    }

    public static void OutputInterpolasi(double[] matrix){
        System.out.println("Hasil dari interpolasi adalah: ");
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
            
            if (i == 1){
                output += matrix[i] + "x";
            }
            else if (i > 1){
                output += (matrix[i] + "x^" + i);
            }

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
            {8,2.0794},
            {9.0, 2.1972},{9.5, 2.2513}
        };

        // Calculate the determinant using your function
        double [] interpolasi = Interpolate(testMatrix);

        // Print the result
        Printmatrix(interpolasi);
        OutputInterpolasi(interpolasi);
        System.out.print(estimasi(interpolasi, 9.2)); 
    } */
}