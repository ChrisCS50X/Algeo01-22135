package userinterference;

public class outputMatrix {
    public static String OutString(double[][] matrix) {
        String hasil = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                hasil += matrix[i][j] + " ";
            }
            hasil += "\n";
        }

        return hasil;
    }
}
