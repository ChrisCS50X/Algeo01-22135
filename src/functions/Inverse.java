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
        int coltemp = col * 2;
        
        double det = Matrix.DeterminanOBE(matrix);

        if (det == 0){
            return null;
        }

        else{
        double [][] hasil = new double[row][col];
        double [][] temp = new double [row][coltemp];
        double [][] MatrixGaussJordaned = new double [row] [coltemp];

        for (i = 0 ; i < row ; i++ ){
            for (j = 0; j < coltemp ; j++){
                if (j < col){
                    temp [i] [j] = matrix[i][j];}
                else{
                    if (j - col == i){
                        temp[i][j] = 1; 
                    }
                    else{
                        temp [i][j] = 0;
                    }
                }
            }
        }

        MatrixGaussJordaned = SPL.gaussJordanElim(temp);

        for (i = 0; i < row ; i++){
            for (j = 0; j < col; j ++){
                hasil[i][j] = MatrixGaussJordaned[i][j + col];
            }
        }
        return hasil;
        }
    }
}
