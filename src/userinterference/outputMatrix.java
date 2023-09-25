package userinterference;

import java.text.DecimalFormat;

public class outputMatrix {
    public static void OutString(double[][] matrix) {
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                matrix[i][j] += 0;
                System.out.print(df.format(matrix[i][j]));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
