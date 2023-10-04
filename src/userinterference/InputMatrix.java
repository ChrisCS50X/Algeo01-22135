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

    public static double[][] InputInterpolasi() {
        scan = new Scanner(System.in);
        System.out.print("Masukkan Banyaknya Titik: ");
        int N = scan.nextInt();
        System.out.println("Masukkan Matriks Titik-Titik: ");

        double[][] Matrix = new double[N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                Matrix[i][j] = scan.nextDouble();
            }
        }

        return Matrix;
    }

    public static double[][] InputRegresi() {
        scan = new Scanner(System.in);
        System.out.print("Masukkan jumlah peubah x: ");
        int N = scan.nextInt();
        System.out.print("Masukkan jumlah sampel: ");
        int M = scan.nextInt();
        System.out.println("Masukkan Matriks sampel: ");

        double[][] Matrix = new double[M][N+1];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N+1; j++) {
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
                String arr = FileScan.nextLine();
                String[] arrhasil = arr.split(" ");
                Col = arrhasil.length;
                Row++;
            }
            double[][] Matrix = new double[Row][Col];
            FileScan.close();

            String hasil = "";
            FileScan = new Scanner(file);
            for (int i = 0; i < Row; i++) {
                hasil = FileScan.nextLine();
                String[] arrhasil = hasil.split(" ");
                for (int j = 0; j < Col; j++) {
                    Matrix[i][j] = Double.parseDouble(arrhasil[j]);
                }
            }
            FileScan.close();
            return Matrix;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static double[][] InputFileReg() {
        scan = new Scanner(System.in);
        System.out.print("Masukkan Nama File Input: ");
        String NamaFile = scan.nextLine();

        String path = "..\\test\\" + NamaFile;
        
        try {
            File file = new File(path);
            Scanner FileScan = new Scanner(file);
            // Baca baris dan kolom matrix dalam file
            int Row = 0;
            int Col = 0;
            while (FileScan.hasNextLine()) {
                String arr = FileScan.nextLine();
                String[] arrhasil = arr.split(" ");
                Col = arrhasil.length;
                Row++;
            }
            double[][] Matrix = new double[Row][Col+1];
            FileScan.close();

            String hasil = "";
            FileScan = new Scanner(file);
            for (int i = 0; i < Row; i++) {
                hasil = FileScan.nextLine();
                String[] arrhasil = hasil.split(" ");
                for (int j = 0; j < Col+1; j++) {
                    if (i == Row-1 && j == Col) {
                        Matrix[i][j] = 0;
                    }
                    else {
                        Matrix[i][j] = Double.parseDouble(arrhasil[j]);
                    }
                }
            }
            FileScan.close();
            return Matrix;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static double[][] InputFileInterpl() {
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
                String arr = FileScan.nextLine();
                String[] arrhasil = arr.split(" ");
                Col = arrhasil.length;
                Row++;
            }
            double[][] Matrix = new double[Row][Col+1];
            FileScan.close();

            String hasil = "";
            FileScan = new Scanner(file);
            for (int i = 0; i < Row; i++) {
                hasil = FileScan.nextLine();
                String[] arrhasil = hasil.split(" ");
                for (int j = 0; j < 2; j++) {
                    if (i == Row-1 && j == Col) {
                        Matrix[i][j] = 0;
                    }
                    else {
                        Matrix[i][j] = Double.parseDouble(arrhasil[j]);
                    }
                }
            }
            FileScan.close();
            return Matrix;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static double[][] InputFileInterBc() {
        scan = new Scanner(System.in);
        System.out.print("Masukkan Nama File: ");
        String NamaFile = scan.nextLine();

        String path = "..\\test\\" + NamaFile;
        
        try {
            File file = new File(path);
            Scanner FileScan = new Scanner(file);
            // Baca baris dan kolom matrix dalam file
            int Row = 5;
            int Col = 4;
            double[][] Matrix = new double[Row][Col];
            FileScan.close();

            String hasil = "";
            FileScan = new Scanner(file);
            for (int i = 0; i < Row; i++) {
                hasil = FileScan.nextLine();
                String[] arrhasil = hasil.split(" ");
                for (int j = 0; j < Col; j++) {
                    if (i == Row-1 && j > 1) {
                        Matrix[i][j] = 0;
                    }
                    else {
                        Matrix[i][j] = Double.parseDouble(arrhasil[j]);
                    }
                }
            }
            FileScan.close();
            return Matrix;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

