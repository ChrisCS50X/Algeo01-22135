package functions;

public class InterpolasiBikubik {
    //
    public static double bicubic(double[][] p, double x, double y) {
        // Membuat array untuk menyimpan hasil interpolasi kubik dari setiap baris
        double[] arr = new double[4];

        // Proses hitung interpolasi kubik pada setiap baris
        for (int i = 0; i < 4; i++) { // hanya sampai 4 karena kita membutuhkan data titik kontrol dari 4 baris yang berdekatan
            // rumus interpolasi kubik untuk koordinat x pada baris
            arr[i] = p[i][1] + 0.5 * x * (p[i][2] - p[i][0] + x * (2.0 * p[i][0] - 5.0 * p[i][1] + 4.0 * p[i][2] - p[i][3] + x * (3.0 * (p[i][1] - p[i][2]) + p[i][3] - p[i][0])));
        }
        // Rumus interpolasi bicubik yang menggabungkan hasil interpolasi kubik pada koordinat y
        return arr[1] + 0.5 * y * (arr[2] - arr[0] + y * (2.0 * arr[0] - 5.0 * arr[1] + 4.0 * arr[2] - arr[3] + y * (3.0 * (arr[1] - arr[2]) + arr[3] - arr[0])));
        // kenapa array ke-1 dikarenakan hasil interpolasi kubik setiap baris diambil dari arr[1]
    }
}
