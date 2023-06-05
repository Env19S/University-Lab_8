import java.util.Arrays;


public class _5 {

    public static void main(String[] args) {

        int[][] matrix = {

                {1, 2, 3},

                {4, 5, 6},

                {7, 8, 9}

        };


        System.out.println("Исходная матрица:");

        printMatrix(matrix);


        rotateMatrix180(matrix);


        System.out.println("Матрица, повернутая на 180°:");

        printMatrix(matrix);

    }


    private static void rotateMatrix180(int[][] matrix) {

        int n = matrix.length;


        for (int i = 0; i < n / 2; i++) {

            for (int j = 0; j < n; j++) {

                int temp = matrix[i][j];

                matrix[i][j] = matrix[n - 1 - i][n - 1 - j];

                matrix[n - 1 - i][n - 1 - j] = temp;

            }

        }

    }


    private static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {

            System.out.println(Arrays.toString(row));

        }

        System.out.println();

    }

}