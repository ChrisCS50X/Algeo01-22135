package functions;

public class Inverse {
    public static double [][] InverseCofactor (double[][]matrix){
        //Mengembalikan matriks inverse menggunakan metode ekspansi kofaktor
        double det = Matrix.DeterminanKofaktor(matrix);

        if (det == 0){
            return null;
        }

        else {
        double [][] tempkofak = Matrix.MatrixKofaktor(matrix);
        double [][] adjoin = Matrix.TransposeMatrix(tempkofak);
        double [][] MatrixInvers = operations.multiplyConst(adjoin,1/det);

        return MatrixInvers;
        }
    }

    public static double [][] InverseOBE (double[][]matrix){
        int i,j;
        int row = matrix.length;
        int col = matrix [0].length;
        double [][] temp = new double [row][col * 2];
        double [][] hasil = new double[row][col];
       
        double det = Matrix.DeterminanOBE(matrix);

        if (det == 0){
            return null;
        }

        else{
        for (i = 0 ; i < temp.length ; i++ ){
            for (j = 0; j < temp[0].length; j++){
                if (j < col){
                    temp [i][j] = matrix[i][j];}
                else{
                    if ((j - col == i)) {
                        temp[i][j] = 1; 
                    }
                    else{
                        temp [i][j] = 0;
                    }
                }
            }
        }

        temp = SPL.gaussJordanElim(temp);

        for (i = 0; i < hasil.length ; i++){
            for (j = 0; j < hasil[0].length; j ++){
                hasil[i][j] = temp[i][j + col];
            }
        }
        return hasil;
        }
    }
}
