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

    public static double[][] InverseOBE(double[][] m) {
      int i, j, k;
      int row = m.length;

      double[][] mSum = new double[row][row * 2];
      double[][] mSum2 = new double[row][row];
      //loop isi nilai mSum
      for (i = 0; i < row; i++) {
          for (j = 0; j < row; j++) {
              mSum[i][j] = m[i][j];
          }
      }
      //loop matriks awal ditambah matriks identitas
      for (i = 0; i < row; i++) {
          for (j = row; j < mSum[0].length; j++) {
              if (i + (row) == j) {
                  mSum[i][j] = 1;
              } else {
                  mSum[i][j] = 0;
              }
          }
      }
      //fungsi tukar baris
      for (i = 0; i < mSum.length; i++) {
          if (operations.IsZero(mSum, i) && i != mSum.length - 1) {
              operations.SwapRow(mSum, i, i + 1);
          } else if (mSum[i][i] == 0 && i != mSum.length - 1) {
              int temprow = i + 1;
              while (temprow < mSum.length) {
                  if (mSum[temprow][i] != 0) {
                      operations.SwapRow(mSum, i, temprow);
                      break;
                  }
                  temprow++;
              }
          }
          if (mSum[i][i] != 1 && mSum[i][i] != 0) {
              double temp = mSum[i][i];
              for (j = i; j < mSum[0].length; j++) {
                  mSum[i][j] /= temp;
              }
          }

          if (i != mSum.length - 1) {
              for (j = i + 1; j < mSum.length; j++) {
                  double temp = mSum[j][i];
                  for (k = i; k < mSum[0].length; k++) {
                      mSum[j][k] = mSum[j][k] - (temp * mSum[i][k]);
                  }
              }
          }
      }
      //loop mengurangi nilai matriks awal dengan hasil perkalian nilai matriks dengan value temporary
      for (i = mSum.length - 1; i >= 0; i--) {
          for (j = i - 1; j >= 0; j--) {
              double temp = mSum[j][i];
              for (k = i; k < mSum[0].length; k++) {
                  mSum[j][k] -= (temp * mSum[i][k]);
              }
          }
      }
      //loop input hasil invers
      for (i = 0; i < mSum2.length; i++) {
          for (j = 0; j < mSum2[0].length; j++) {
              mSum2[i][j] = mSum[i][j + mSum2[0].length];
          }
      }
      //hasil dari matrisk Inverse OBE
      return mSum2;
  }
}
