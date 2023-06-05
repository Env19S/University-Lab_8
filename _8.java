public class _8 {

    public static void main(String[] args) {


        int n = 6; // Размерность массива


        int[][] array = new int[n][n]; // Создаем двумерный массив


        // Заполняем матрицу

        fillMatrix(array, n);


        // Выводим массив на экран

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print(array[i][j] + " ");

            }

            System.out.println();

        }

    }


    // Метод для заполнения блока матрицы

    public static int fillBlock(int[][] array, int startRow, int startY, int num, int end, int n, int startYY) {

        for (int i = startRow - 1, j = startY; i >= 0; i--, j++) {

            if (j < end)

                array[i][j] = num++;

        }

        for (int i = startYY; i < n; i++) {

            array[i][end - 1] = num++;

        }

        return num;

    }


    // Метод для заполнения всей матрицы

    public static void fillMatrix(int[][] array, int n) {

        int num = 1;

        int startCol = 0;

        int startRow = n;

        int startYY = 1;

        int end = n;

        int numRows = n;

        int numCols = n;


        while (numRows > 0 && numCols > 0) {

            num = fillBlock(array, startRow, startCol, num, end, n, startYY);

            end--;

            startYY += 2;

            startCol++;

            numRows--;

            numCols--;

        }

    }

}