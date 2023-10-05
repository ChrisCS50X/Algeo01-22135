package userinterference;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import Main.Main;

public class outputMatrix {
    public static void OutString(double[][] matrix) {
        DecimalFormat df = new DecimalFormat("#.####");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                matrix[i][j] += 0;
                System.out.print(df.format(matrix[i][j]));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static Scanner scan;

    public static void outFile(String s) {
    try {
        scan = new Scanner(System.in);
        System.out.println("Apakah anda ingin menyimpan hasil ke dalam file? (y/n)");
        String pilih = scan.nextLine();
        if (pilih.equals("y")) {
            System.out.print("Masukkan Nama File Output: ");
            String namaFile = scan.nextLine();
            File file = new File("..\\test\\" + namaFile + ".txt");
            while (file.exists()) {
                System.out.println("File sudah ada, masukkan ulang nama file!");
                System.out.print("Masukkan nama file: ");
                namaFile = scan.nextLine();
                file = new File("..\\test\\" + namaFile + ".txt");
            }
            FileWriter writer = new FileWriter(file);
            writer.write(s);
            writer.close();
            System.out.println("File disimpan!");
        }

    } catch (IOException e) {
        System.out.println("Error!");
    }
}

}