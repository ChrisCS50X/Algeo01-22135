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

    public static double DeterminanOBE (double[][]matrix){
        int i,j,k,n,counter;
        double nilai1, nilai2, nilai3, temp, determinan, sum;
        n = matrix.length;
        determinan = 1;
        sum = 1;

       
        for (i = 0 ; i < n ; i++){
            counter = i;

            while (counter < n && matrix[counter][i] == 0){
                counter++;
            }

            if (counter == n){ 
                return 0;
            }

            if (counter != i){ 
                for (j = 0 ; j < n ; j++){ // 
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[counter][j];
                    matrix[counter][j] = temp;
                }
                determinan *= -1; 
            }
            
            for (j = i + 1 ; j < n ; j++){
                nilai1 = matrix[i][i];
                nilai2 = matrix[j][i];

                for (k = 0 ; k < n ; k++){
                    nilai3 = (nilai1 * matrix[j][k]) - (nilai2 * matrix[i][k]);
                    matrix[j][k] = nilai3;
                }
                sum *= nilai1;
            }
        }

        for (i = 0 ; i < n ; i++){
            determinan *= matrix[i][i];
        }

        return determinan/sum;
    }
}