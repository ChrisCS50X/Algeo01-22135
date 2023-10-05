package functions;
import java.util.Scanner;

public class Matrix {
    public static Scanner scan;

    public static void OutputMatrix(double[][] matrix){
    //Mengeluarkan output matrix

        for (int i = 0; i < matrix.length;i++){
            for (int j = 0; j< matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] CreateIdentityMatrix(double[][] matrix, int n) {
        // Membuat Matrix identitas

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
        //Cek apakah suatu matrix merupakan matrix persegi

        int nRows = matrix.length;
        int nCols = matrix[0].length;
    
        if (nRows == nCols){
            return true;
        }
        else{
            return false;
        } 
    }

    public static double[][] CopyMatrix(double[][] matrix) {
        //Mengcopy keseluruhan matrix

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

    public static double[][] TransposeMatrix(double[][] matrix) {
        //Men-transpose kan suatu matrix dan mengembalikan matrix transposenya

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
        //Mencari determinan menggunakan OBE

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

    public static double[][] GetMinorMatrix(double[][] matrix, int row, int col) {
        //Mengembalikan matriks minor dari kolom dan baris yang diinput

        int n = matrix.length;
        double[][] newMatrix = new double[n-1][n-1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < row) {
                    if (j < col) {
                        newMatrix[i][j] = matrix[i][j];
                    } else if (j > col) {
                        newMatrix[i][j - 1] = matrix[i][j];
                    }
                } else if (i > row) {
                    if (j < col) {
                        newMatrix[i - 1][j] = matrix[i][j];
                    } else if (j > col) {
                        newMatrix[i - 1][j - 1] = matrix[i][j];
                    }
                }
            }
        }

        return newMatrix;
    }
    
    public static double DeterminanKofaktor (double[][] matrix){
        // Mencari Determinan menggunakan ekspansi kofaktor

        int n = matrix.length;
        double det, detminor;
        int sign = 1;

        if (n == 1) {
            det = matrix[0][0];
        } 
        
        else {
            det = 0;
            for (int i = 0; i < n; i++) {
                detminor = DeterminanKofaktor(GetMinorMatrix(matrix, 0, i));
                det += sign * matrix[0][i] * detminor;
                sign *= (-1);
            }
        }

        return det;
    }

    public static double [][] MatrixKofaktor (double[][] matrix){
        //Matriks yang semua elemennya merupakan kofaktor dari suatu matrix
        
        int n,i,j,c;
        n = matrix.length;
        double [][] matrixkofak = new double[n][n];

        if (n == 1) {
            matrixkofak[0][0] = matrix[0][0];}
        
        else{
        for (i = 0; i<n; i++){
            for (j = 0; j < n; j++){
                c = 1;
                if ((i + j) % 2 == 1){
                    c = -1;
                }
                matrixkofak[i][j] = c * DeterminanKofaktor(GetMinorMatrix(matrix,i,j));
            }
        }
    }
    return matrixkofak;
    }

    public static double[][] BikinKiri(double[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        double[][] MatKiri = new double[row][col-1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col-1; j++) {
                MatKiri[i][j] = matrix[i][j];
            }
        }
        return MatKiri;
    }

    public static double[][] BikinKanan(double[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        double[][] MatKanan = new double[row][1];

        for (int i = 0; i < row; i++) {
            MatKanan[i][0] = matrix[i][col-1];
        }
        return MatKanan;


    }
}