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
}