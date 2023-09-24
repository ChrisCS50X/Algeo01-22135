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

    public static double[][] CreateIdentityMatrix(double[][] M, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    M[i][j] = 1;
                } else {
                    M[i][j] = 0;
                }
            }
        }
        return M;
    }

    public static boolean IsSquare(double[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;
    
        for (int i = 1; i < nRows; i++) {
            if (matrix[i].length != nCols) {
                return false;
            }
        }
    
        return true;
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

    
}
