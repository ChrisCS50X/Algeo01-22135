package functions;

import java.text.DecimalFormat;

import userinterference.outputMatrix;

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
    
    public static double[][] MultiplyMatrix (double[][] matrix1, double[][] matrix2){
        int Row = matrix1.length;
        int Column = matrix2[0].length;
        int i,j,k;
        double[][] m3 = new double [Row][Column];
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

    public static double[][] multiplyConst( double[][] matrix, double k) {
        int row = matrix.length;
        int col = matrix[0].length;
        double[][] newMat = new double[row][col];
    
        for (int i = 0; i < row; i++) {
          for (int j = 0; j < col; j++) {
            newMat[i][j] = k * matrix[i][j];
          }
        }
        return newMat;
      }
    
    public static String cekHasil(double[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int cekNol = 0;
        int banyak = 0;
        int tidak = 0;
        String hasil = "";

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    cekNol += 1;
                }
                else if (matrix[i][j] != 0 && j < col-1){
                    cekNol = 0;
                    continue;
                }
            }
            if (cekNol == col) {
                banyak += 1;
            }
            else if (cekNol == col-1) {
                tidak += 1;
            }
            cekNol = 0;
            
        }

        if (banyak != 0) {
            hasil = "Solusi banyak";
        }
        else if (banyak == 0 && tidak != 0) {
            hasil = "Tidak ada solusi";
        }
        else if (banyak == 0 && tidak == 0) {
            hasil = "Solusi unik";
        }
        return hasil;
    }

    public static String solusiUnik(double[][] matrix) {
        DecimalFormat df = new DecimalFormat("#.##");
        String hasil = "nilai x = {";
        int row = matrix.length;
        int col = matrix[0].length;
        SPL.gaussJordanElim(matrix);
        for (int i = 0; i < row; i++) {
            hasil += df.format(matrix[i][col-1]);
            if (i < row-1) {
                hasil += ",";
            }
        }
        hasil += "}";
        return hasil;
    }

    public static String solusiTidakAda(double[][] matrix) {
        String hasil = "Solusi tidak ada";
        return hasil;
    }

    public static String solusiBanyak(double[][] matrix) {
        DecimalFormat df = new DecimalFormat("#.##");
        String Parameter[] = {"r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String hasil[] = new String[matrix.length];
        String jawaban = "";

        int row = matrix.length;
        int col = matrix[0].length;
        int cekNol = 0;
        int k = col-1;
        for (int i = row-1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    cekNol += 1;
                }
            }
            if (cekNol == col) {
                hasil[i] = Parameter[row - i];
            }
            else {
                if (i == row -1) {
                    hasil[i] = (df.format(matrix[i][k])) + "-" + hasil[i+1]; //minusnya ga masuk kedalem. harus tau cara ngalinya gmn
                }
                else {
                    hasil[i] = (df.format(matrix[i][k])) + "-" + hasil[i+1];
                }
                //enak kalo rekursif cmn belom kepikiran
            }
        }

        for (int i = 1; i <= hasil.length; i++){
            jawaban += "X" + "[" + i + "]" + " = " + hasil[i-1] + " ";
        }
        return jawaban;
    }
}