public class _7 {

    public static void main(String[] args) {

        int n = 6; // Размерность массива


        int[][] array = new int[n][n]; // Создаем двумерный массив


        int num = 1; // Значение для заполнения массива


        int startRow = n - 1; // Начальная строка

        int endRow = 0; // Конечная строка

        int startCol = 0; // Начальный столбец

        int endCol = n - 1; // Конечный столбец


        while (startRow >= endRow && startCol <= endCol) {

            // Заполнение столбца сверху вниз

            for (int i = startRow; i >= endRow; i--) {

                array[i][startCol] = num;

                num++;

            }

            startCol++; // Уменьшаем начальный столбец


            // Заполнение строки слева направо

            for (int i = startCol; i <= endCol; i++) {

                array[endRow][i] = num;

                num++;

            }

            endRow++; // Увеличиваем конечную строку


            // Заполнение столбца снизу вверх

            for (int i = endRow; i <= startRow; i++) {

                array[i][endCol] = num;

                num++;

            }

            endCol--; // Уменьшаем конечный столбец

        }


        // Выводим массив на экран

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print(array[i][j] + " ");

            }

            System.out.println();

        }

    }

}