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
                        clear();
                        System.out.println("---INTERPOLASI POLINOM---");
                        double[][] Mat = InputMatrix.InputInterpolasi();
                        System.out.print("Masukkan Nilai Taksiran: ");
                        Float X = scan.nextFloat();
                        batas();
                        double[] interpolasi = InterpolasiPolinom.Interpolate(Mat);
                        batas();
                        String hasil = "";
                        hasil += (InterpolasiPolinom.OutputInterpolasi(interpolasi));
                        hasil += (", f(" + X + ") = " + InterpolasiPolinom.estimasi(interpolasi, X));
                        System.out.println(hasil);
                        outputMatrix.outFile(hasil);
                    }
                    else if (optionInput == 2) {
                        clear();
                        System.out.println("---INTERPOLASI POLINOM---");
                        double[][] Mat = InputMatrix.InputFileInterpl();
                        batas();
                        double X = Mat[Mat.length-1][0];

                        int nRows = Mat.length;
                        int nCols = Mat[0].length;
                        
                        double[][] copy = new double[nRows-1][nCols];

                        for (int i = 0; i < nRows-1;i++ ){
                            for (int j = 0; j < nCols; j++){
                                copy [i][j] = Mat[i][j];
                            }
                        }

                        double[] interpolasi = InterpolasiPolinom.Interpolate(copy);
                        String hasil = "";
                        hasil += (InterpolasiPolinom.OutputInterpolasi(interpolasi));
                        hasil += (", f(" + X + ") = " + InterpolasiPolinom.estimasi(interpolasi, X));
                        System.out.println(hasil);
                        outputMatrix.outFile(hasil);
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
                        clear();
                        System.out.println("---INTERPOLASI BICUBIC SPLINE---");
                        double[][] Mat = InputMatrix.InputKeyboard();
                        System.out.print("Masukkan nilai a: ");
                        Float a = scan.nextFloat();
                        System.out.print("Masukkan nilai b: ");
                        Float b = scan.nextFloat();
                        batas();
                        System.out.println("f(" + a + "," + b + ") = " + InterpolasiBikubik.bicubicSplineInterpolation(Mat, a, b));
                        outputMatrix.outFile("f(" + a + "," + b + ") = " + InterpolasiBikubik.bicubicSplineInterpolation(Mat, a, b));

                    }
                    else if (optionInput == 2) {
                        clear();
                        System.out.println("---INTERPOLASI BICUBIC SPLINE---");
                        double[][] Mat = InputMatrix.InputFileInterBc();
                        batas();
                        double a = Mat[4][0];
                        double b = Mat[4][1];
                        double[][] copy = new double[4][4];

                        for (int i = 0; i < 4;i++ ){
                            for (int j = 0; j < 4; j++){
                                copy [i][j] = Mat[i][j];
                            }
                        }
                        System.out.println("f(" + a + "," + b + ") = " + InterpolasiBikubik.bicubicSplineInterpolation(copy, a, b));
                        outputMatrix.outFile("f(" + a + "," + b + ") = " + InterpolasiBikubik.bicubicSplineInterpolation(copy, a, b));
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
                        clear();
                        System.out.println("---REGRESI LINEAR GANDA---");
                        double[][] Mat = InputMatrix.InputRegresi();
                        double[] Taksiran = new double[Mat[0].length - 1];
                        System.out.println("Masukkan Matriks Taksiran: ");
                        for (int i = 0; i < Mat[0].length - 1; i++) {
                            Taksiran[i] = scan.nextDouble();
                        }
                        batas();
                        String hasil = "";
                        double[][] MatX = Matrix.BikinKiri(Mat);
                        double[][] MatY = Matrix.BikinKanan(Mat);
                        double[] Regresi = RegresiLinier.Regresiganda(MatX, MatY);
                        hasil += (RegresiLinier.OutputRegresi(Regresi));
                        hasil += (", f(");
                        for (int i = 0; i < Taksiran.length; i++) {
                            if (i < Taksiran.length - 1) {
                                hasil += (Taksiran[i] + ",");
                            }
                            else {
                                hasil += (Taksiran[i] + ") = " + RegresiLinier.FungsiRegresi(Regresi, Taksiran));
                            }
                        }
                        System.out.println(hasil);
                        outputMatrix.outFile(hasil);

                    }
                    else if (optionInput == 2) {
                        clear();
                        System.out.println("---REGRESI LINEAR GANDA---");
                        double[][] Mat = InputMatrix.InputFileReg();
                        batas();
                        double[] Taksiran = new double[Mat[0].length - 1];
                        for (int i = 0; i < Mat[0].length - 1; i++) {
                            Taksiran[i] = Mat[Mat.length-1][i];
                        }

                        double[][] copy = new double[Mat.length-1][Mat[0].length];
                        for (int i = 0; i < Mat.length-1;i++ ){
                            for (int j = 0; j < Mat[0].length; j++){
                                copy [i][j] = Mat[i][j];
                            }
                        }

                        double[][] MatX = Matrix.BikinKiri(copy);
                        double[][] MatY = Matrix.BikinKanan(copy);
                        double[] Regresi = RegresiLinier.Regresiganda(MatX, MatY);
                        String hasil = "";
                        hasil += (RegresiLinier.OutputRegresi(Regresi));
                        hasil += (", f(");
                        for (int i = 0; i < Taksiran.length; i++) {
                            if (i < Taksiran.length - 1) {
                                hasil += (Taksiran[i] + ",");
                            }
                            else {
                                hasil += (Taksiran[i] + ") = " + RegresiLinier.FungsiRegresi(Regresi, Taksiran));
                            }
                        }
                        System.out.println(hasil);
                        outputMatrix.outFile(hasil);
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
                default:
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
                    clear();
                    System.out.println("METODE ELIMINASI GAUSS:");
                    double[][] Mat = InputMatrix.InputKeyboard();
                    SPL.gaussElim(Mat);
                    batas();
                    System.out.println("Hasil Gauss:");
                    outputMatrix.OutString(Mat);
                    batas();
                    if (operations.cekHasil(Mat) == "Solusi unik") {
                        System.out.println(operations.solusiUnik(Mat));
                        batas();
                        outputMatrix.outFile(operations.solusiUnik(Mat));
                    }
                    else if (operations.cekHasil(Mat) == "Tidak ada solusi") {
                        System.out.println(operations.solusiTidakAda(Mat));
                        batas();
                        outputMatrix.outFile(operations.solusiTidakAda(Mat));
                    }
                    else {
                        System.out.println(operations.solusiBanyak(Mat));
                        batas();
                        outputMatrix.outFile(operations.solusiBanyak(Mat));
                    }
                }
                else if (optionInput == 2) {
                    clear();
                    System.out.println("METODE ELIMINASI GAUSS:");
                    double[][] Mat = InputMatrix.InputFile();
                    SPL.gaussElim(Mat);
                    batas();
                    System.out.println("Hasil Gauss:");
                    outputMatrix.OutString(Mat);
                    batas();
                    if (operations.cekHasil(Mat) == "Solusi unik") {
                        System.out.println(operations.solusiUnik(Mat));
                        batas();
                        outputMatrix.outFile(operations.solusiUnik(Mat));
                    }
                    else if (operations.cekHasil(Mat) == "Tidak ada solusi") {
                        System.out.println(operations.solusiTidakAda(Mat));
                        batas();
                        outputMatrix.outFile(operations.solusiTidakAda(Mat));
                    }
                    else {
                        System.out.println(operations.solusiBanyak(Mat));
                        batas();
                        outputMatrix.outFile(operations.solusiBanyak(Mat));
                    }
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
                    clear();
                    System.out.println("METODE ELIMINASI GAUSS-JORDAN:");
                    double[][] Mat = InputMatrix.InputKeyboard();
                    SPL.gaussJordanElim(Mat);
                    batas();
                    System.out.println("Hasil Gauss-Jordan:");
                    outputMatrix.OutString(Mat);
                    batas();
                    if (operations.cekHasil(Mat) == "Solusi unik") {
                        System.out.println(operations.solusiUnik(Mat));
                        outputMatrix.outFile(operations.solusiUnik(Mat));
                    }
                    else if (operations.cekHasil(Mat) == "Tidak ada solusi") {
                        System.out.println(operations.solusiTidakAda(Mat));
                        outputMatrix.outFile(operations.solusiTidakAda(Mat));
                    }
                    else {
                        System.out.println(operations.solusiBanyak(Mat));
                        outputMatrix.outFile(operations.solusiBanyak(Mat));
                    }
                }
                else if (optionInput == 2) {
                    double[][] Mat = InputMatrix.InputFile();
                    SPL.gaussJordanElim(Mat);
                    batas();
                    System.out.println("Hasil Gauss-Jordan:");
                    outputMatrix.OutString(Mat);
                    batas();
                    if (operations.cekHasil(Mat) == "Solusi unik") {
                        System.out.println(operations.solusiUnik(Mat));
                        outputMatrix.outFile(operations.solusiUnik(Mat));
                    }
                    else if (operations.cekHasil(Mat) == "Tidak ada solusi") {
                        System.out.println(operations.solusiTidakAda(Mat));
                        outputMatrix.outFile(operations.solusiTidakAda(Mat));
                    }
                    else {
                        System.out.println(operations.solusiBanyak(Mat));
                        outputMatrix.outFile(operations.solusiBanyak(Mat));
                    }
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
                    clear();
                    System.out.println("METODE MATRIKS BALIKAN:");
                    double[][] Mat = InputMatrix.InputKeyboard();
                    DecimalFormat df = new DecimalFormat("#.####");
                    double[][] Mat1 = Matrix.CopyMatrix(Mat);
                    batas();
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
                        outputMatrix.outFile(hasil);
                    }
                    else {
                        if (operations.cekHasil(SPL.gaussJordanElim(Mat)) == "Tidak ada solusi") {
                            System.out.println(operations.solusiTidakAda(Mat));
                            outputMatrix.outFile(operations.solusiTidakAda(Mat));
                        }
                        else {
                            System.out.println(operations.solusiBanyak(Mat));
                            outputMatrix.outFile(operations.solusiBanyak(Mat));
                        }
                    }
                }
                else if (optionInput == 2) {
                    clear();
                    System.out.println("METODE MATRIKS BALIKAN:");
                    double[][] Mat = InputMatrix.InputFile();
                    DecimalFormat df = new DecimalFormat("#.####");
                    double[][] Mat1 = Matrix.CopyMatrix(Mat);
                    batas();
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
                        outputMatrix.outFile(hasil);
                    }
                    else {
                        if (operations.cekHasil(SPL.gaussJordanElim(Mat)) == "Tidak ada solusi") {
                            System.out.println(operations.solusiTidakAda(Mat));
                            outputMatrix.outFile(operations.solusiTidakAda(Mat));
                        }
                        else {
                            System.out.println(operations.solusiBanyak(Mat));
                            outputMatrix.outFile(operations.solusiBanyak(Mat));
                        }
                    }
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
                    clear();
                    System.out.println("METODE KAIDAH CRAMER:");
                    double[][] Mat = InputMatrix.InputKeyboard();
                    batas();
                    if (SPL.kaidahCramer(Mat) !=  null) {
                        DecimalFormat df = new DecimalFormat("#.####");
                        String hasil = "nilai x = {";
                        for (int i = 0; i < Mat.length; i++) {
                            hasil += df.format(SPL.kaidahCramer(Mat)[i][0]);
                            if (i < Mat.length-1) {
                                hasil += ",";
                            }
                        }
                        hasil += "}";
                        System.out.println(hasil);
                        outputMatrix.outFile(hasil);
                    }
                    else {
                        if (operations.cekHasil(SPL.gaussJordanElim(Mat)) == "Tidak ada solusi") {
                            System.out.println(operations.solusiTidakAda(Mat));
                            outputMatrix.outFile(operations.solusiTidakAda(Mat));
                        }
                        else {
                            System.out.println(operations.solusiBanyak(Mat));
                            outputMatrix.outFile(operations.solusiBanyak(Mat));
                        }
                    }
                }
                else if (optionInput == 2) {
                    clear();
                    System.out.println("METODE KAIDAH CRAMER:");
                    double[][] Mat = InputMatrix.InputFile();
                    batas();
                    if (SPL.kaidahCramer(Mat) !=  null) {
                        DecimalFormat df = new DecimalFormat("#.####");
                        String hasil = "nilai x = {";
                        for (int i = 0; i < Mat.length; i++) {
                            hasil += df.format(SPL.kaidahCramer(Mat)[i][0]);
                            if (i < Mat.length-1) {
                                hasil += ",";
                            }
                        }
                        hasil += "}";
                        System.out.println(hasil);
                        outputMatrix.outFile(hasil);
                    }
                    else {
                        if (operations.cekHasil(SPL.gaussJordanElim(Mat)) == "Tidak ada solusi") {
                            System.out.println(operations.solusiTidakAda(Mat));
                            outputMatrix.outFile(operations.solusiTidakAda(Mat));
                        }
                        else {
                            System.out.println(operations.solusiBanyak(Mat));
                            outputMatrix.outFile(operations.solusiBanyak(Mat));
                        }
                    }
                }
                else {
                    SubmenuSPL();
                }
                Exit();
                break;
            case 5:
                main(null);
                break;
            default:
                clear();
                System.out.println("Pilihan tidak tersedia.");
                Exit();
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
                    clear();
                    System.out.println("METODE REDUKSI BARIS:");
                    DecimalFormat df = new DecimalFormat("#.####");
                    double[][] Mat = InputMatrix.InputKeyboard();
                    batas();
                    double hasil = Matrix.DeterminanOBE(Mat);
                    String hasilnya = "Determinan = " + df.format(hasil);
                    System.out.println(hasilnya);
                    outputMatrix.outFile(hasilnya);
                }
                else if (optionInput == 2) {
                    clear();
                    System.out.println("METODE REDUKSI BARIS:");
                    double[][] Mat = InputMatrix.InputFile();
                    batas();
                    DecimalFormat df = new DecimalFormat("#.####");
                    double hasil = Matrix.DeterminanOBE(Mat);
                    String hasilnya = "Determinan = " + df.format(hasil);
                    System.out.println(hasilnya);
                    outputMatrix.outFile(hasilnya);
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
                    clear();
                    System.out.println("METODE EKSPANSI KOFAKTOR:");
                    DecimalFormat df = new DecimalFormat("#.####");
                    double[][] Mat = InputMatrix.InputKeyboard();
                    batas();
                    double hasil = Matrix.DeterminanKofaktor(Mat);
                    String hasilnya = "Determinan = " + df.format(hasil);
                    System.out.println(hasilnya);
                    outputMatrix.outFile(hasilnya);
                }
                else if (optionInput == 2) {
                    clear();
                    System.out.println("METODE EKSPANSI KOFAKTOR:");
                    double[][] Mat = InputMatrix.InputFile();
                    batas();
                    DecimalFormat df = new DecimalFormat("#.####");
                    double hasil = Matrix.DeterminanKofaktor(Mat);
                    String hasilnya = "Determinan = " + df.format(hasil);
                    System.out.println(hasilnya);
                    outputMatrix.outFile(hasilnya);
                }
                else {
                    SubmenuDet();
                }
                Exit();
                break;
            case 3:
                main(null);
                break;
            default:
                clear();
                System.out.println("Pilihan tidak tersedia.");
                Exit();
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
                    clear();
                    System.out.println("METODE MATRIKS BALIKAN:");
                    double[][] Mat = InputMatrix.InputKeyboard();
                    batas();
                    double[][] Mat1 = Matrix.CopyMatrix(Mat);
                    if (Matrix.DeterminanOBE(Mat1) != 0) {
                        outputMatrix.OutString(Inverse.InversA(Mat));
                        outputMatrix.outFile(operations.doubletoStr(Inverse.InversA(Mat)));
                    }
                    else {
                        System.out.println("Matriks tidak mempunyai inverse atau merupakan matriks singular");
                        outputMatrix.outFile("Matriks tidak mempunyai inverse atau merupakan matriks singular");
                    }
                }
                else if (optionInput == 2) {
                    clear();
                    System.out.println("METODE MATRIKS BALIKAN:");
                    double[][] Mat = InputMatrix.InputFile();
                    batas();
                    double[][] Mat1 = Matrix.CopyMatrix(Mat);
                    if (Matrix.DeterminanOBE(Mat1) != 0) {
                        outputMatrix.OutString(Inverse.InversA(Mat));
                        outputMatrix.outFile(operations.doubletoStr(Inverse.InversA(Mat)));
                    }
                    else {
                        System.out.println("Matriks tidak mempunyai inverse atau merupakan matriks singular");
                        outputMatrix.outFile("Matriks tidak mempunyai inverse atau merupakan matriks singular");
                    }
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
                    clear();
                    System.out.println("METODE ADJOIN:");
                    double[][] Mat = InputMatrix.InputKeyboard();
                    batas();
                    double[][] Mat1 = Matrix.CopyMatrix(Mat);
                    if (Matrix.DeterminanKofaktor(Mat1) != 0) {
                        outputMatrix.OutString(Inverse.InverseCofactor(Mat));
                        outputMatrix.outFile(operations.doubletoStr(Inverse.InverseCofactor(Mat)));
                    }
                    else {
                        System.out.println("Matriks tidak mempunyai inverse atau merupakan matriks singular");
                        outputMatrix.outFile("Matriks tidak mempunyai inverse atau merupakan matriks singular");
                    }
                }
                else if (optionInput == 2) {
                    clear();
                    System.out.println("METODE ADJOIN:");
                    double[][] Mat = InputMatrix.InputFile();
                    batas();
                    double[][] Mat1 = Matrix.CopyMatrix(Mat);
                    if (Matrix.DeterminanKofaktor(Mat1) != 0) {
                        outputMatrix.OutString(Inverse.InverseCofactor(Mat));
                        outputMatrix.outFile(operations.doubletoStr(Inverse.InverseCofactor(Mat)));
                    }
                    else {
                        System.out.println("Matriks tidak mempunyai inverse atau merupakan matriks singular");
                        outputMatrix.outFile("Matriks tidak mempunyai inverse atau merupakan matriks singular");
                    }
                }
                else {
                    SubmenuInverse();
                }
                Exit();
                break;
            case 3:
                main(null);
                break;
            default:
                clear();
                System.out.println("Pilihan tidak tersedia.");
                Exit();
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

    public static void batas() {
        System.out.println("======================================================================");
    }
}
