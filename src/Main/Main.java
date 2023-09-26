package Main;

import userinterference.*;
import functions.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static Scanner scan;

    public static void main(String[] args) {
        clear();
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. interpolasi polinom");
        System.out.println("5. Interpolasi Bicupic Spline");
        System.out.println("6. Regresi Linier berganda");
        System.out.println("7. Keluar");
        scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch (option) {
            case 1:
                clear();
                System.out.println("---SISTEM PERSAMAAN LINIER---");
                Submenu();
                break;
            case 2:
                clear();
                System.out.println("---DETERMINAN---");
                Submenu();
                break;
            case 3:
                clear();
                System.out.println("---MATRIKS BALIKAN---");
                Submenu();
                break;
            case 4:
                clear();
                System.out.println("---INTERPOLASI POLINOM---");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                scan = new Scanner(System.in);
                int optionInput = scan.nextInt();
                if (optionInput == 1) {
                    double[][] Mat = InputMatrix.InputKeyboard();
                }
                else {
                    InputMatrix.InputFile();
                }
                break;
            case 5:
                clear();
                System.out.println("---INTERPOLASI BICUPIC SPLINE---");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                scan = new Scanner(System.in);
                optionInput = scan.nextInt();
                if (optionInput == 1) {
                    double[][] Mat = InputMatrix.InputKeyboard();
                }
                else {
                    InputMatrix.InputFile();
                }
                break;
            case 6:
                clear();
                System.out.println("---REGRESI LINEAR GANDA---");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                scan = new Scanner(System.in);
                optionInput = scan.nextInt();
                if (optionInput == 1) {
                    double[][] Mat = InputMatrix.InputKeyboard();
                }
                else {
                    InputMatrix.InputFile();
                }
                break;
            case 7:
                clear();
                System.out.println("DADAH...");
                break;
        }
    }

    public static void Submenu() {
        System.out.println("MENU");
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah Cramer");
        scan = new Scanner(System.in);
        int optionSub = scan.nextInt();
        switch(optionSub) {
            case 1:
                clear();
                System.out.println("METODE ELIMINASI GAUSS:");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
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
                else {
                    InputMatrix.InputFile();
                }
                break;
            case 2:
                clear();
                System.out.println("METODE ELIMINASI GAUSS-JORDAN:");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                scan = new Scanner(System.in);
                optionInput = scan.nextInt();
                if (optionInput == 1) {
                    double[][] Mat = InputMatrix.InputKeyboard();
                    SPL.gaussJordanElim(Mat);
                    if (operations.cekHasil(Mat) == "Solusi unik" || operations.cekHasil(Mat) == "Tidak ada solusi") {
                        System.out.println(operations.solusiUnik(Mat));
                    }
                    else {
                        System.out.println(operations.solusiBanyak(Mat));
                    }
                }
                else {
                    InputMatrix.InputFile();
                }
                break;
            case 3:
                clear();
                System.out.println("METODE MATRIKS BALIKAN:");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                scan = new Scanner(System.in);
                optionInput = scan.nextInt();
                if (optionInput == 1) {
                    double[][] Mat = InputMatrix.InputKeyboard();
                    DecimalFormat df = new DecimalFormat("#.##");
                    String hasil = "nilai x = {";
                    for (int i = 0; i < Mat.length; i++) {
                        hasil += df.format(SPL.matrixBalikan(Mat)[i][0]);
                        if (i < Mat.length-1) {
                            hasil += ",";
                        }
                    }
                    hasil += "}";
                    System.out.println(hasil);
                }
                else {
                    InputMatrix.InputFile();
                }
                break;
            case 4:
                clear();
                System.out.println("METODE KAIDAH CRAMER:");
                System.out.println("MENU");
                System.out.println("1. Input Keyboard");
                System.out.println("2. Input File");
                scan = new Scanner(System.in);
                optionInput = scan.nextInt();
                if (optionInput == 1) {
                    double[][] Mat = InputMatrix.InputKeyboard();
                }
                else {
                    InputMatrix.InputFile();
                }
                break;
        }
    }
    
    public static void clear() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
