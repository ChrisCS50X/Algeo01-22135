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
                matrix[pivot][col] /= pivotVal;
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
                matrix[pivot][col] /= pivotVal;
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
        if (matrix1.length == matrix2[0].length) {
            //mencari invers matriks kiri
            double matrixInvers[][] = SPL.gaussJordanElim(matrix1);
    
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
                System.out.println("Matriks tidak memiliki matriks balikan.");
                return null;
            }
        } 
        else {
            System.out.println("Jumlah kolom matriks kiri harus sama dengan jumlah baris matriks kanan.");
            return null;
        }
    }
    
}
