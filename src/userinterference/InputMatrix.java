package userinterference;

import java.io.File;
import java.util.Scanner;

public class InputMatrix {
    public static Scanner scan;
    public static double[][] InputKeyboard() {

        scan = new Scanner(System.in);
        System.out.print("Masukkan Jumlah Baris: ");
        int M = scan.nextInt();
        System.out.print("Masukkan Jumlah Kolom: ");
        int N = scan.nextInt();

        double[][] Matrix = new double[M][N]; 

        System.out.println("Masukkan Elemen-Elemen Matrix: ");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Matrix[i][j] = scan.nextDouble();
            }
        }
        return Matrix;   
    }

    public static double[][] InputFile() {
        scan = new Scanner(System.in);
        System.out.print("Masukkan Nama File: ");
        String NamaFile = scan.nextLine();

        String path = "..\\test\\" + NamaFile;
        
        try {
            File file = new File(path);
            Scanner FileScan = new Scanner(file);
            // Baca baris dan kolom matrix dalam file
            int Row = 0;
            int Col = 0;
            while (FileScan.hasNextLine()) {
                Row++;
                Scanner colReader = new Scanner(FileScan.nextLine());
                while (colReader.hasNextLine()) {
                    Col++;
                }
            }
            double[][] Matrix = new double[Row][Col];
            FileScan.close();

            FileScan = new Scanner(file);
            for (int i = 0; i < Row; i++) {
                for (int j = 0; j < 0; j++) {
                    if(FileScan.hasNextDouble()) {
                        Matrix[i][j] = FileScan.nextDouble();
                    }
                }
            }
            FileScan.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            double[][] Matrix = new double[1][1];
            return Matrix;
        }
        return null;
    }
}

