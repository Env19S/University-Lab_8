public class _9 {

    public static void main(String[] args) {


        int n = 5;

        int n2 = n * 2; // Размерность массива


        int[][] array = new int[n2][n2]; // Создаем двумерный массив


        // Заполняем матрицу

        fillMatrix(array, n2);


        // Выводим массив на экран

        for (int i = 0; i < n2; i++) {

            for (int j = 0; j < n2; j++) {

                System.out.print(array[i][j] + " ");

            }

            System.out.println();

        }

    }


    // Метод для заполнения блока матрицы

    public static int fillBlock(int[][] array, int num, int numRows, int numCols, int currentRow, int currentCol) {

       /*for (int j = 0; j < cols; j++) {

           array[currentRow][j] = num++;

       }

       for (int i = 1; i < rowsCount; i++) {

           array[i][col-1] = num++;

       }

       return num;*/


        // Заполнение первой строки

        for (int i = currentRow; i < numCols; i++) {

            array[currentRow][i] = num++;

        }


        // Заполнение последнего столбца

        for (int i = currentRow + 1; i < numRows; i++) {

            array[i][numCols - 1] = num++;

        }


        // Заполнение первого столбца

        for (int i = currentRow + 1; i < numRows; i++) {

            array[i][currentCol] = num++;

        }


        // Заполнение последней строки

        for (int i = currentRow + 1; i < numCols - 1; i++) {

            array[numRows - 1][i] = num++;

        }

        return num;

    }


    // Метод для заполнения всей матрицы

    public static void fillMatrix(int[][] array, int n) {

        int num = 1;

        int numRows = n;

        int numCols = n;

        int currentRow = 0;

        int currentCol = 0;


        while (numRows > 0 && numCols > 0) {

            num = fillBlock(array, num, numRows, numCols, currentRow, currentCol);

            numRows--;

            numCols--;

            currentRow++;

            currentCol++;

        }

    }

}

