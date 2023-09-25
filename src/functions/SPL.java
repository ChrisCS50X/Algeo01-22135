package functions;

public class SPL {
    
    public static void gaussElim(double[][] matrix) {
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
                        matrix[row][col] -= temp * matrix[pivot][col]; // harus dikalikan dengan matrix[pivot][col] agar baris-baris dibawah baris pertama tetap bernilai 0
                    }
                }
            }
        }
    }
}
