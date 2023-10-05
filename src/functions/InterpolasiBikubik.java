package functions;
    
public class InterpolasiBikubik {
    public static String bicubicSplineInterpolation(double[][] Mat, double a, double b) {
        // Inisialisasi matriks pendukung
        double[][] matriks = new double[16][16];

        int X, Y = 0;
    
        // Loop untuk mengisi matriks pendukung
        while (Y < 16) {
            for (int x = 0; x < 2; x++) {
                X = 0;
                for (int y = 0; y < 2; y++) {
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            // Mengisi elemen matriks sesuai dengan kondisi
                            if (Y < 4) {
                                matriks[Y][X] = Math.pow(x, i) * Math.pow(y, j);
                            } else if (Y < 8) {
                                if (j == 0) {
                                    matriks[Y][X] = 0;
                                } else {
                                    matriks[Y][X] = j * Math.pow(x, i) * Math.pow(y, j - 1);
                                }
                            } else if (Y < 12) {
                                if (i == 0) {
                                    matriks[Y][X] = 0;
                                } else {
                                    matriks[Y][X] = i * Math.pow(x, i - 1) * Math.pow(y, j);
                                }
                            } else {
                                if (i == 0 || j == 0) {
                                    matriks[Y][X] = 0;
                                } else {
                                    matriks[Y][X] = i * j * Math.pow(x, i - 1) * Math.pow(y, j - 1);
                                }
                            }
                            X++;
                        }
                    }
                    X = 0;
                    Y++;
                }
            }
        }
    
        // Menginverskan matriks pendukung
        matriks = Inverse.InversA(matriks);
    
        // Matriks untuk menyimpan nilai Mat
        double[][] nilai = new double[16][1];
    
        int tempRow = 0;
    
        // Loop untuk mengisi matriks nilai
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                nilai[tempRow][0] = Mat[i][j];
                tempRow++;
            }
        }
    
        // Mengalikan matriks pendukung yang sudah diinverskan dengan matriks nilai
        double[][] matriksA = operations.MultiplyMatrix(matriks, nilai);
    
        double hasil = 0;
    
        tempRow = 0;
    
        // Perhitungan hasil interpolasi bicubic spline
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                hasil += (matriksA[tempRow][0] * Math.pow(a, j) * Math.pow(b, i));
                tempRow++;
            }
        }
        
        String hasilnya = "";
        // Menampilkan hasil interpolasi
        hasilnya += "Hasil taksirannya adalah " + hasil;
        return hasilnya;
    }
    
}
