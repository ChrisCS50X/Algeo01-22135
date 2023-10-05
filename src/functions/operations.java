package functions;

import java.text.DecimalFormat;
import java.util.Arrays;

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
        String hasil = "Solusi unik";

        for (int i = 0; i < row; i++) {
            if (matrix[i][i] == 0) {
                if (matrix[i][col-1] == 0) {
                    hasil = "Solusi banyak";
                }
                else {
                    hasil = "Tidak ada solusi";
                }
            }
        }
        return hasil;
    }

    public static String solusiUnik(double[][] matrix) {
        DecimalFormat df = new DecimalFormat("#.####");
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
        DecimalFormat df = new DecimalFormat("#.####");
        int row = matrix.length;
        int col = matrix[0].length;
        int[] arrparam = new int[col];
        int nonPar = 0;
        Arrays.fill(arrparam, 0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    arrparam[j] = 1;
                    nonPar++;
                    break;
                }
            }
        }
        String hasilpar = "";
        String[] arrhasilpar = new String[col - nonPar - 1];
        int idxarrhasilpar = 0;
        for (int i = 0; i < col - 1; i++) {
            if (arrparam[i] == 0) {
                hasilpar += "x" + (i + 1) + " = " + "x" + (i + 1);
                arrhasilpar[idxarrhasilpar] = hasilpar;
                idxarrhasilpar++;
                hasilpar = "";
            }
        }
        String[] arrhasil = new String[nonPar + 1 + arrhasilpar.length];
        int idxarrhasil = 0;
        int temp = 0;
        int cek = 0;
        String hasil = "";
        for (int i = row - 1; i > -1; i--) {
            for (int j = 0; j < col - 1; j++) {
                if (matrix[i][j] != 0) {
                    temp++;
                    if (temp == 1) {
                        if (matrix[i][j] == 1) {
                            if (matrix[i][col - 1] != 0) {
                                hasil += "x" + (j + 1) + " = " + df.format(matrix[i][col - 1]);
                            } else {
                                for (int k = j + 1; k < col - 1; k++) {
                                    if (matrix[i][k] != 0) {
                                        cek += 1;
                                    }
                                }
                                if (cek != 0) {
                                    hasil += "x" + (j + 1) + " = ";
                                } else {
                                    hasil += "x" + (j + 1) + " = 0";
                                }
                            }
                        } else {
                            if (matrix[i][col - 1] != 0) {
                                hasil += df.format(matrix[i][j]) + "x" + (j + 1) + " = " + df.format(matrix[i][col - 1]);
                            } else {
                                hasil += df.format(matrix[i][j]) + "x" + (j + 1) + " = ";
                            }
                        }
                    } else {
                        if (matrix[i][j] < 0) {
                            hasil += " + " + df.format(Math.abs(matrix[i][j])) + "x" + (j + 1);
                        } else if (matrix[i][j] == 1) {
                            hasil += " - " + "x" + (j + 1);
                        } else {
                            hasil += " - " + df.format(matrix[i][j]) + "x" + (j + 1);
                        }
                    }
                }
            }
            temp = 0;
            arrhasil[idxarrhasil] = hasil;
            idxarrhasil++;
            hasil = "";
        }
        for (int i = 0; i < arrhasilpar.length; i++) {
            arrhasil[idxarrhasil] = arrhasilpar[i];
            idxarrhasil++;
        }

        String solusi = "";
        for (int i = 0; i < arrhasil.length; i++) {
            solusi += (arrhasil[i]) + "\n";
        }
        return solusi;
    }

    public static Double[][] UpdateHasil(Double[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] += 0;
            }
        }
        return matrix;
    }

    public static String doubletoStr(double[][] matrix) {
        DecimalFormat df = new DecimalFormat("#.####");
        int row = matrix.length;
        int col = matrix[0].length;
        String hasil = "";

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                hasil += df.format(matrix[i][j]) + " ";
            }
            hasil += "\n";
        }
        return hasil;
    }

public static boolean IsZero(double[][] matrix, int n) {
    int cnt = 0;
    int col = matrix[0].length;
    boolean isZero = false;

    //jika di suatu row semua elemen nya adalah zero, maka boolean true
    for (int i = 0; i < col; i++) {
            if (matrix[n][i] == 0) {
                cnt++;
            }
        }
        if (cnt == col) {
            return true;
        }
    return isZero;    
    }
    

public static double[][] SwapRow(double[][] matriks, int row1, int row2) {
    int n = matriks[0].length;
    double[] temp = new double[n];
   
    for (int i = 0; i < n; i++) {
     temp[i] = matriks[row1][i];
    }
    for (int i = 0; i < n; i++) {
     matriks[row1][i] = matriks[row2][i];
    }
    for (int i = 0; i < n; i++) {
     matriks[row2][i] = temp[i];
    }
    return matriks;
}

public static double[][] OBE(double[][] matriks) {
        int pivot = 0;
        int row = matriks.length;
        int col = matriks[0].length;

        for (int i = 0; i < row; i++) {
            if (pivot == col - 1) {
                break;
            }
            if (operations.IsZero(matriks, i)) {
                if (i == row - 1) {
                    return matriks;
                }
                else {
                operations.SwapRow(matriks, i - 1, i);
                }

            } 
            else if (matriks[i][pivot] == 0 && i != row - 1) {
                int tempRow = i + 1;
                while (tempRow < row) {
                    if (matriks[tempRow][pivot] != 0) {
                        operations.SwapRow(matriks, i, tempRow);
                        break;
                    }
                    tempRow++;
                }
            }
            while (matriks[i][pivot] == 0 && pivot < col - 1) {
                pivot++;
            }
            if (matriks[i][pivot] != 1 && matriks[i][pivot] != 0) {
                double temp = matriks[i][pivot];
                for (int j = pivot; j < col; j++) {
                    matriks[i][j] /= temp;
                }
            }
            if (i != row - 1) {
                for (int j = i + 1; j < row; j++) {
                    double temp = matriks[j][pivot];
                    for (int k = pivot; k < col; k++) {
                        matriks[j][k] = matriks[j][k] - (temp * matriks[i][k]);
                    }
                }
            }

        }
        return matriks;
    }

    public static double[][] OBE_Tereduksi(double[][] matriks){
        int i,j;
        int row = matriks.length;
        int col = matriks[0].length;
        matriks = OBE(matriks);

        for (i = row-1 ; i >= 0 ; i--){
            for (j = col-1 ; j >= 0 ; j--){
                if (matriks[i][j] == 1){
                    double Factor;
                    int otherRow = i - 1;

                    while (otherRow >= 0){
                        Factor = matriks[otherRow][j];
                        double value;
                        for (int k = 0 ; k < col ; k++){
                            value = matriks[i][k] * Factor;
                            matriks[otherRow][k] -= value;
                        }
                        otherRow--;
                    }
                }
            }
        }

        return matriks;
    }

}