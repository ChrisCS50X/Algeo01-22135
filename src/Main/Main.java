package Main;

import userinterference.InputMatrix;
import userinterference.outputMatrix;
import java.util.Scanner;

public class Main {
    public static Scanner scan;

    public static void main(String[] args) {
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
                    System.out.println("---SISTEM PERSAMAAN LINIER---");
                    Submenu();
                    break;
                case 2:
                    System.out.println("---DETERMINAN---");
                    Submenu();
                    break;
                case 3:
                    System.out.println("---MATRIKS BALIKAN---");
                    Submenu();
                    break;
                case 4:
                    System.out.println("---INTERPOLASI POLINOM---");
                    input();
                    break;
                case 5:
                    System.out.println("---INTERPOLASI BICUPIC SPLINE---");
                    input();
                    break;
                case 6:
                    System.out.println("---REGRESI LINEAR GANDA---");
                    input();
                    break;
                case 7:
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
                    System.out.println("METODE ELIMINASI GAUSS:");
                    input();
                    break;
                case 2:
                    System.out.println("METODE ELIMINASI GAUSS-JORDAN:");
                    input();
                    break;
                case 3:
                    System.out.println("METODE MATRIKS BALIKAN:");
                    input();
                    break;
                case 4:
                    System.out.println("METODE KAIDAH CRAMER:");
                    input();
                    break;
            }
    }

    public static void input() {
            System.out.println("MENU");
            System.out.println("1. Input Keyboard");
            System.out.println("2. Input File");
            scan = new Scanner(System.in);
            int optionInput = scan.nextInt();
            switch(optionInput) {
                case 1:
                    double[][] M = InputMatrix.InputKeyboard();
                    System.out.println(outputMatrix.OutString(M));
                    break;
                case 2:
                    InputMatrix.InputFile();
                    break;
            }
        }
}
