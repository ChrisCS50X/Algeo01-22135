package functions;
import java.util.Scanner;

public class Matrix {
    public static Scanner scan;

    public static void OutputMatrix(double[][] M){
        for (int i = 0; i < M.length;i++){
            for (int j = 0; j< M[i].length;j++){
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] CreateIdentityMatrix(double[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static boolean IsSquare(double[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;
    
        if (nRows == nCols){
            return true;
        }
        else{
            return false;
        } 
    }

    public static double[][] copyMatrix(double[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        
        double[][] copy = new double[nRows][nCols];

        for (int i = 0; i < nRows;i++ ){
            for (int j = 0; j < nCols; j++){
                copy [i][j] = matrix[i][j];
            }
        }
        return copy;
    }

    public static double[][] transposeMatrix(double[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        
        double[][] transpose = new double[nCols][nRows];
        
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        
        return transpose;
    }

    public static double Determinan (double[][]matrix){
        
        double[][] GaussCopy = copyMatrix(matrix);

        int i,j,n,x;
        double temp, determinan, sum;
        n = GaussCopy.length;
        determinan = 1;
        sum = 1;

       
        for (i = 0 ; i < n ; i++){
            x = i;

            while (x < n && GaussCopy[x][i] == 0){
                x++;
            }

            if (x == n){ 
                return 0;
            }

            if (x != i){ 
                for (j = 0 ; j < n ; j++){ // 
                    temp = GaussCopy[i][j];
                    GaussCopy[i][j] = GaussCopy[x][j];
                    GaussCopy[x][j] = temp;
                }
                determinan *= -1; 
            }
            
            // Belom ditaro Operasi Baris Elementer
            
        }

        for (i = 0 ; i < n ; i++){
            determinan *= GaussCopy[i][i];
        }

        return determinan/sum;
    }
}
