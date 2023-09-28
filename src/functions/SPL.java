package functions;

public class SPL {
    
    public static double[][] gaussElim(double[][] matrix) {
        int Row = matrix.length;
        int Column = matrix[0].length;

        for (int pivot = 0; pivot < Row; pivot++ ) {
            // pivot value fungsinya untuk mengetahui nilai-nilai pada diagonal utama
            double pivotVal = matrix[pivot][pivot];

            for (int col = 0; col < Column; col++) {
                // fungsi ini merupakan sebuah operasi dimana satu baris akan dibagi nilainya dengan nilai yang sudah ada pada pivot Value
                if(matrix[pivot][col] != 0) {
                    if(pivotVal == 0) {
                        matrix[pivot][col] /= 1;
                    }
                    else {
                       matrix[pivot][col] /= pivotVal; 
                    }
                }
                else {
                    matrix[pivot][col] = 0;
                }
            }
            
            for (int row = 0; row < Row; row++) {
                // fungsi ini beroperasi pada baris dibawah pivot jadi baris diatas yang sudah ada satu utama tidak diganti
                if (row > pivot) {
                    double temp = matrix[row][pivot];

                    for (int col = 0; col < Column; col++) {
                        //nilai matrix yang dibawah pivot akan dikurangi dengan dirinya sendiri yang membuat nilainya 0
                        matrix[row][col] -= temp * matrix[pivot][col];
                    }

                }
            }
        }
        return matrix;
    }


    public static double[][] gaussJordanElim(double[][] matrix) {
        int Row = matrix.length;
        int Column = matrix[0].length;

        for (int pivot = 0; pivot < Row; pivot++ ) {
            // pivot value fungsinya untuk mengetahui nilai-nilai pada diagonal utama
            double pivotVal = matrix[pivot][pivot];

            for (int col = 0; col < Column; col++) {
                // fungsi ini merupakan sebuah operasi dimana satu baris akan dibagi nilainya dengan nilai yang sudah ada pada pivot Value
                if(matrix[pivot][col] != 0) {
                    if(pivotVal == 0) {
                        matrix[pivot][col] /= 1;
                    }
                    else {
                       matrix[pivot][col] /= pivotVal; 
                    }
                }
                else {
                    matrix[pivot][col] = 0;
                }
            }

            for (int row = 0; row < Row; row++) {
                // fungsi ini beroperasi pada baris selain baris pivot yang sedang dikerjakan
                if (row != pivot) {
                    double temp = matrix[row][pivot];

                    for (int col = 0; col < Column; col++) {
                        //nilai matrix yang dibawah pivot akan dikurangi dengan dirinya sendiri yang membuat nilainya 0
                        matrix[row][col] -= temp * matrix[pivot][col];
                    }

                }
            }
        }
        return matrix;
    }

    public static double[][] matrixBalikan(double[][] matrix) {

        double matrix1[][] = Matrix.BikinKiri(matrix);
        double matrix2[][] = Matrix.BikinKanan(matrix);

        //cek apakah matriks kiri bisa untuk dikalikan dengan matriks kanan
        if (matrix1[0].length == matrix2.length) {
            //mencari invers matriks kiri
            double matrixInvers[][] = functions.Inverse.InverseCofactor(matrix1);
    
            if (matrixInvers != null) {
                int Row = matrixInvers.length;
                int Column = matrix2[0].length;
                double resultMatrix[][] = new double[Row][Column];
    
                //perkalian invers kiri dengan kanan
                for (int row = 0; row < Row; row++) {
                    for (int col = 0; col < Column; col++) {
                        double sum = 0;
                        for (int k = 0; k < matrixInvers[0].length; k++) {
                            sum += matrixInvers[row][k] * matrix2[k][col];
                        }
                        resultMatrix[row][col] = sum;
                    }
                }
    
                return resultMatrix;
            } 
            else {
                return null;
            }
        } 
        else {
            return null;
        }
    }
    
    public static double[][] kaidahCramer(double[][] matrix) {
        double A[][] = Matrix.BikinKiri(matrix);
        double B[][] = Matrix.BikinKanan(matrix);
        double A1[][] = Matrix.CopyMatrix(A);
        double detA = Matrix.DeterminanOBE(A1);
        
        int Row = A.length;
        int Column = A[0].length;

        //inisiasi matriks dengan ukuran yang sama
        double[][] resultMatrix = new double[Row][1];
        
        if (detA != 0) {
            for (int i = 0; i < Row; i++) {
                // salinan matriks A untuk diganti dengan matriks gabungan A dan B
                double[][] matrixTemp = new double[Row][Column];
                for (int j = 0; j < Row; j++) {
                    for (int k = 0; k < Column; k++) {
                        matrixTemp[j][k] = A[j][k];
                    }
                }
            
                // mengganti kolom matriks A dengan B
                for (int n = 0; n < Row; n++) {
                    matrixTemp[n][i] = B[n][0];
                }

                // menghitung determinan matriks gabungan
                double detMatrixTemp = Matrix.DeterminanOBE(matrixTemp);

                double resultX = detMatrixTemp / detA;
                // masukan nilai hasil X kedalam matriks
                resultMatrix[i][0] = resultX;
            }
        }
        else {
            resultMatrix = null;
        }
        return resultMatrix;
        
    }
}
