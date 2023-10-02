package Main;

import userinterference.*;
import functions.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static Scanner scan;

    public static void main(String[] args) {
        while(true) {
            clear();
            System.out.println("MAIN MENU");
            System.out.println("1. Sistem Persamaan Linier");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks balikan");
            System.out.println("4. interpolasi polinom");
            System.out.println("5. Interpolasi Bicupic Spline");
            System.out.println("6. Regresi Linier berganda");
            System.out.println("7. Keluar");
            System.out.print("Masukkan Pilihan Anda: ");
            scan = new Scanner(System.in);
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    SubmenuSPL();
                    break;
                case 2:
                    SubmenuDet();
                    break;
                case 3:
                    SubmenuInverse();
                    break;
                case 4:
                    clear();
                    System.out.println("---INTERPOLASI POLINOM---");
                    System.out.println("MENU");
                    System.out.println("1. Input Keyboard");
                    System.out.println("2. Input File");
                    System.out.println("3. Kembali");
                    System.out.print("Masukkan Pilihan Anda: ");
                    scan = new Scanner(System.in);
                    int optionInput = scan.nextInt();
                    if (optionInput == 1) {
                        double[][] Mat = InputMatrix.InputInterpolasi();
                        System.out.print("Masukkan Nilai Taksiran: ");
                        Float X = scan.nextFloat();
                        double[] interpolasi = InterpolasiPolinom.Interpolate(Mat);
                        System.out.print(InterpolasiPolinom.OutputInterpolasi(interpolasi));
                        System.out.println(", f(" + X + ") = " + InterpolasiPolinom.estimasi(interpolasi, X));
                    }
                    else if (optionInput == 2) {
                        InputMatrix.InputFile();
                    }
                    else {
                        main(args);
                    }
                    Exit();
                    break;
                case 5:
                    clear();
                    System.out.println("---INTERPOLASI BICUBIC SPLINE---");
                    System.out.println("MENU");
                    System.out.println("1. Input Keyboard");
                    System.out.println("2. Input File");
                    System.out.println("3. Kembali");
                    System.out.print("Masukkan Pilihan Anda: ");
                    scan = new Scanner(System.in);
                    optionInput = scan.nextInt();
                    if (optionInput == 1) {
                        double[][] Mat = InputMatrix.InputKeyboard();
                        System.out.print("Masukkan nilai a: ");
                        Float a = scan.nextFloat();
                        System.out.print("Masukkan nilai b: ");
                        Float b = scan.nextFloat();
                        System.out.println("f(" + a + "," + b + ") = " + InterpolasiBikubik.bicubic(Mat, a, b));
                    }
                    else if (optionInput == 2) {
                        InputMatrix.InputFile();
                    }
                    else {
                        main(args);
                    }
                    Exit();
                    break;
                case 6:
                    clear();
                    System.out.println("---REGRESI LINEAR GANDA---");
                    System.out.println("MENU");
                    System.out.println("1. Input Keyboard");
                    System.out.println("2. Input File");
                    System.out.println("3. Kembali");
                    System.out.print("Masukkan Pilihan Anda: ");
                    scan = new Scanner(System.in);
                    optionInput = scan.nextInt();
                    if (optionInput == 1) {
                        double[][] Mat = InputMatrix.InputRegresi();
                        double[] Taksiran = new double[Mat[0].length - 1];
                        System.out.println("Masukkan Matriks Taksiran: ");
                        for (int i = 0; i < Mat[0].length - 1; i++) {
                            Taksiran[i] = scan.nextDouble();
                        }

                        double[][] MatX = Matrix.BikinKiri(Mat);
                        double[][] MatY = Matrix.BikinKanan(Mat);
                        double[] Regresi = RegresiLinier.Regresiganda(MatX, MatY);
                        System.out.print(RegresiLinier.OutputRegresi(Regresi));
                        System.out.print(", f(");
                        for (int i = 0; i < Taksiran.length; i++) {
                            if (i < Taksiran.length - 1) {
                                System.out.print(Taksiran[i] + ",");
                            }
                            else {
                                System.out.println(Taksiran[i] + ") = " + RegresiLinier.FungsiRegresi(Regresi, Taksiran));
                            }
                        }

                    }
                    else if (optionInput == 2) {
                        InputMatrix.InputFile();
                    }
                    else {
                        main(args);
                    }
                    Exit();
                    break;
                case 7:
                    clear();
                    System.out.println("DADAH...");
                    System.exit(0);
                    break;
                case 8:
                    clear();
                    System.out.println("Pilihan tidak tersedia.");
                    Exit();
            }
        }
    }

    public static void SubmenuSPL() {
        clear();
        System.out.println("---SISTEM PERSAMAAN LINIER---");
        System.out.println("MENU");
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah Cramer");
        System.out.println("5. Kembali");
        scan = new Scanner(System.in);
        System.out.print("Masukkan Pilihan Anda: ");
        int optionSub = scan.nextInt();
        switch(optionSub) {
            case 1:
                clear();
                System.out.println("METODE ELIMINASI GAUSS:");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                System.out.println("3. Kembali");
                System.out.print("Masukkan Pilihan Anda: ");
                scan = new Scanner(System.in);
                int optionInput = scan.nextInt();
                if (optionInput == 1) {
                    double[][] Mat = InputMatrix.InputKeyboard();
                    SPL.gaussElim(Mat);
                    if (operations.cekHasil(Mat) == "Solusi unik") {
                        System.out.println(operations.solusiUnik(Mat));
                    }
                    else if (operations.cekHasil(Mat) == "Tidak ada solusi") {
                        System.out.println(operations.solusiTidakAda(Mat));
                    }
                    else {
                        System.out.println(operations.solusiBanyak(Mat));
                    }
                }
                else if (optionInput == 2) {
                    InputMatrix.InputFile();
                }
                else {
                    SubmenuSPL();
                }
                Exit();
                break;
            case 2:
                clear();
                System.out.println("METODE ELIMINASI GAUSS-JORDAN:");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                System.out.println("3. Kembali");
                System.out.print("Masukkan Pilihan Anda: ");
                scan = new Scanner(System.in);
                optionInput = scan.nextInt();
                if (optionInput == 1) {
                    double[][] Mat = InputMatrix.InputKeyboard();
                    SPL.gaussJordanElim(Mat);
                    if (operations.cekHasil(Mat) == "Solusi unik") {
                        System.out.println(operations.solusiUnik(Mat));
                    }
                    else if (operations.cekHasil(Mat) == "Tidak ada solusi") {
                        System.out.println(operations.solusiTidakAda(Mat));
                    }
                    else {
                        System.out.println(operations.solusiBanyak(Mat));
                    }
                }
                else if (optionInput == 2) {
                    InputMatrix.InputFile();
                }
                else {
                    SubmenuSPL();
                }
                Exit();
                break;
            case 3:
                clear();
                System.out.println("METODE MATRIKS BALIKAN:");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                System.out.println("3. Kembali");
                System.out.print("Masukkan Pilihan Anda: ");
                scan = new Scanner(System.in);
                optionInput = scan.nextInt();
                if (optionInput == 1) {
                    double[][] Mat = InputMatrix.InputKeyboard();
                    DecimalFormat df = new DecimalFormat("#.##");
                    double[][] Mat1 = Matrix.CopyMatrix(Mat);
                    if (Matrix.DeterminanOBE(Mat1) != 0) {
                        String hasil = "nilai x = {";
                        int row = SPL.matrixBalikan(Mat).length;
                        int col = SPL.matrixBalikan(Mat)[0].length;
                        for (int i = 0; i < row; i++) {
                            hasil += df.format(SPL.matrixBalikan(Mat)[i][col-1]);
                            if (i < row-1) {
                                hasil += ",";
                            }
                        }
                        hasil += "}";
                        System.out.println(hasil);
                    }
                    else {
                        if (operations.cekHasil(SPL.gaussJordanElim(Mat)) == "Tidak ada solusi") {
                            System.out.println(operations.solusiTidakAda(Mat));
                        }
                        else {
                            System.out.println(operations.solusiBanyak(Mat));
                        }
                    }
                }
                else if (optionInput == 2) {
                    InputMatrix.InputFile();
                }
                else {
                    SubmenuSPL();
                }
                Exit();
                break;
            case 4:
                clear();
                System.out.println("METODE KAIDAH CRAMER:");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                System.out.println("3. Kembali");
                System.out.print("Masukkan Pilihan Anda: ");
                scan = new Scanner(System.in);
                optionInput = scan.nextInt();
                if (optionInput == 1) {
                    double[][] Mat = InputMatrix.InputKeyboard();
                    if (SPL.kaidahCramer(Mat) !=  null) {
                        DecimalFormat df = new DecimalFormat("#.##");
                        String hasil = "nilai x = {";
                        for (int i = 0; i < Mat.length; i++) {
                            hasil += df.format(SPL.kaidahCramer(Mat)[i][0]);
                            if (i < Mat.length-1) {
                                hasil += ",";
                            }
                        }
                        hasil += "}";
                        System.out.println(hasil);
                    }
                    else {
                        if (operations.cekHasil(SPL.gaussJordanElim(Mat)) == "Tidak ada solusi") {
                            System.out.println(operations.solusiTidakAda(Mat));
                        }
                        else {
                            System.out.println(operations.solusiBanyak(Mat));
                        }
                    }
                }
                else if (optionInput == 2) {
                    InputMatrix.InputFile();
                }
                else {
                    SubmenuSPL();
                }
                Exit();
                break;
            case 5:
                main(null);
                break;
        }
    }

    public static void SubmenuDet() {
        clear();
        System.out.println("---DETERMINAN---");
        System.out.println("MENU");
        System.out.println("1. Metode reduksi baris");
        System.out.println("2. Metode ekspansi kofaktor");
        System.out.println("3. Kembali");
        System.out.print("Masukkan Pilihan Anda: ");
        scan = new Scanner(System.in);
        int optionSub = scan.nextInt();
        switch(optionSub) {
            case 1:
                clear();
                System.out.println("METODE REDUKSI BARIS:");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                System.out.println("3. Kembali");
                System.out.print("Masukkan Pilihan Anda: ");
                scan = new Scanner(System.in);
                int optionInput = scan.nextInt();
                if (optionInput == 1) {
                    DecimalFormat df = new DecimalFormat("#.##");
                    double[][] Mat = InputMatrix.InputKeyboard();
                    double hasil = Matrix.DeterminanOBE(Mat);
                    System.out.print("Determinan = ");
                    System.out.println(df.format(hasil));
                }
                else if (optionInput == 2) {
                    InputMatrix.InputFile();
                }
                else {
                    SubmenuDet();
                }
                Exit();
                break;
            case 2:
                clear();
                System.out.println("METODE EKSPANSI KOFAKTOR:");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                System.out.println("3. Kembali");
                System.out.print("Masukkan Pilihan Anda: ");
                scan = new Scanner(System.in);
                optionInput = scan.nextInt();
                if (optionInput == 1) {
                    DecimalFormat df = new DecimalFormat("#.##");
                    double[][] Mat = InputMatrix.InputKeyboard();
                    double hasil = Matrix.DeterminanKofaktor(Mat);
                    System.out.print("Determinan = ");
                    System.out.println(df.format(hasil));
                }
                else if (optionInput == 2) {
                    InputMatrix.InputFile();
                }
                else {
                    SubmenuDet();
                }
                Exit();
                break;
            case 3:
                main(null);
                break;
        }
    }

    public static void SubmenuInverse() {
        clear();
        System.out.println("---MATRIKS BALIKAN---");
        System.out.println("MENU");
        System.out.println("1. Metode matriks balikan");
        System.out.println("2. Metode adjoin");
        System.out.println("3. Kembali");
        System.out.print("Masukkan Pilihan Anda: ");
        scan = new Scanner(System.in);
        int optionSub = scan.nextInt();
        switch(optionSub) {
            case 1:
                clear();
                System.out.println("METODE MATRIKS BALIKAN:");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                System.out.println("3. Kembali");
                System.out.print("Masukkan Pilihan Anda: ");
                scan = new Scanner(System.in);
                int optionInput = scan.nextInt();
                if (optionInput == 1) {
                    double[][] Mat = InputMatrix.InputKeyboard();
                    double[][] Mat1 = Matrix.CopyMatrix(Mat);
                    if (Matrix.DeterminanOBE(Mat1) != 0) {
                        outputMatrix.OutString(Inverse.InverseOBE(Mat));
                    }
                    else {
                        System.out.println("Matriks tidak mempunyai inverse atau merupakan matriks singular");
                    }
                }
                else if (optionInput == 2) {
                    InputMatrix.InputFile();
                }
                else {
                    SubmenuInverse();
                }
                Exit();
                break;
            case 2:
                clear();
                System.out.println("METODE ADJOIN:");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                System.out.println("3. Kembali");
                System.out.print("Masukkan Pilihan Anda: ");
                scan = new Scanner(System.in);
                optionInput = scan.nextInt();
                if (optionInput == 1) {
                    double[][] Mat = InputMatrix.InputKeyboard();
                    double[][] Mat1 = Matrix.CopyMatrix(Mat);
                    if (Matrix.DeterminanKofaktor(Mat1) != 0) {
                        outputMatrix.OutString(Inverse.InverseCofactor(Mat));
                    }
                    else {
                        System.out.println("Matriks tidak mempunyai inverse atau merupakan matriks singular");
                    }
                }
                else if (optionInput == 2) {
                    InputMatrix.InputFile();
                }
                else {
                    SubmenuInverse();
                }
                Exit();
                break;
            case 3:
                main(null);
                break;
        }
    }
    
    public static void clear() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  


    public static void Exit() {
        System.out.print("Press enter to exit");
        scan = new Scanner(System.in);
        scan.nextLine();
    }
}
