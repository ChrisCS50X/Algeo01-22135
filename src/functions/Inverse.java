package functions;

public class Inverse {
    public static double [][] InverseCofactor (double[][]matrix){
        //Mengembalikan matriks inverse menggunakan metode ekspansi kofaktor
        double det = Matrix.DeterminanKofaktor(matrix);
        double [][] tempkofak = Matrix.MatrixKofaktor(matrix);
        double [][] adjoin = Matrix.TransposeMatrix(tempkofak);
        double [][] MatrixInvers = Operations.multiplyConst(adjoin,1/det);

        return MatrixInvers;
    }
}
