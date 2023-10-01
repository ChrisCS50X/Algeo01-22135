package functions;

public class Inverse {
    public static double [][] InverseCofactor (double[][]matrix){
        //Menghasilkan matriks inverse menggunakan metode ekspansi kofaktor

        double det = Matrix.DeterminanKofaktor(matrix);
        double [][] tempkofak = Matrix.MatrixKofaktor(matrix);
        double [][] adjoin = Matrix.TransposeMatrix(tempkofak);
        double [][] MatrixInvers = operations.multiplyConst(adjoin,1/det);

        return MatrixInvers;
    }

    public static double [][] InverseOBE (double[][]matrix){
      //Menghasilkan matriks inverse menggunakan metode eliminasi gauss jordan
    
      int i,j;
      int row = matrix.length;
      int col = matrix [0].length;
      double [][] temp = new double [row][2 * col];
      double [][] hasil = new double[row][col];
     
      for (i = 0; i < row; i++) {
        for (j = 0; j < col * 2; j++) {
          if (j < col) {
            temp[i][j] = matrix[i][j];
        } 
        else {
          if ((j - col == i)) {
            temp[i][j] = 1;
          } 
          else {
            temp[i][j] = 0;
          }
        }
      }
    }

    temp = SPL.gaussJordanElim(temp);

    for (i = 0; i < row ; i++){
        for (j = 0; j < col; j ++){
              hasil[i][j] = temp[i][j + col];
        }
      }
      return hasil; 
  }

    //Buat Debugging
    /* 
    public static void main(String[] args) {
        // Create a test matrix
        double[][] testMatrix = {
            {1, 5},
            {3, 7}
        };

        // Compute the inverse using your function
        double[][] inverseMatrix = InverseOBE(testMatrix);

        // Print the result
        System.out.println("Inverse Matrix:");
        printMatrix(inverseMatrix);
    }

    // Helper function to print a matrix
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }*/
}
