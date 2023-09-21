package functions;

public class Matrix {
    public static double[][] CreateIdentityMatrix(double[][] M, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    M[i][j] = 1;
                } else {
                    M[i][j] = 0;
                }
            }
        }
        return M;
    }
}
