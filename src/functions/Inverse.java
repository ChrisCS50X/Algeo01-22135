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

    public static double[][] InversA(double[][] m) {
      int i, j, k;
      int row = m.length;
      int col = m[0].length;

      double[][] mSum = new double[row][row * 2];
      double[][] mSum2 = new double[row][row];
      for (i = 0; i < row; i++) {
          for (j = 0; j < row; j++) {
              mSum[i][j] = m[i][j];
          }
      }

      for (i = 0; i < row; i++) {
          for (j = row; j < mSum[0].length; j++) {
              if (i + (row) == j) {
                  mSum[i][j] = 1;
              } else {
                  mSum[i][j] = 0;
              }
          }
      }
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
      for (i = mSum.length - 1; i >= 0; i--) {
          for (j = i - 1; j >= 0; j--) {
              double temp = mSum[j][i];
              for (k = i; k < mSum[0].length; k++) {
                  mSum[j][k] -= (temp * mSum[i][k]);
              }
          }
      }

      for (i = 0; i < mSum2.length; i++) {
          for (j = 0; j < mSum2[0].length; j++) {
              mSum2[i][j] = mSum[i][j + mSum2[0].length];
          }
      }
      return mSum2;
  }
}
