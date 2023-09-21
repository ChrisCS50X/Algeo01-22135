import java.util.Scanner;

public class InputMatrix {
    public static Scanner sc;
    public static int[][] InputKeyboard() {
        sc = new Scanner(System.in);

        System.out.print("Masukkan Jumlah Baris: ");
        int M = sc.nextInt();
        System.out.print("Masukkan Jumlah Kolom: ");
        int N = sc.nextInt();

        int[][] Matrix = new int[M][N]; 

        System.out.println("Masukkan Elemen Matrix: ");
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                Matrix[i][j] = sc.nextInt();
            }
        }
        return Matrix;
    }   
}
