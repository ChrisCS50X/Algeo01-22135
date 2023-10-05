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
}
