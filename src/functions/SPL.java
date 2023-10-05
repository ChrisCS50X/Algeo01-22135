package functions;

public class SPL {
    
    public static double[][] gaussElim(double[][] matrix) {
        matrix = operations.OBE(matrix);
        return matrix;
    }


    public static double[][] gaussJordanElim(double[][] matrix) {
        matrix = operations.OBE_Tereduksi(matrix);
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
