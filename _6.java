import java.util.Arrays;


public class _6 {

    public static void main(String[] args) {

        int[][] matrix = {

                {5, 3, 2, 4},

                {7, 6, 8, 1},

                {9, 5, 2, 7}

        };


        int[][] localMaxIndices = findLocalMax(matrix);

        int[][] localMinIndices = findLocalMin(matrix);


        int[][] modifiedMatrix = replaceLocalMaxWithMin(matrix, localMaxIndices, localMinIndices);


        System.out.println("Исходная матрица:");

        printMatrix(matrix);


        System.out.println("Индексы локальных максимумов:");

        printMatrix(localMaxIndices);


        System.out.println("Индексы локальных минимумов:");

        printMatrix(localMinIndices);


        System.out.println("Модифицированная матрица:");

        printMatrix(modifiedMatrix);

    }


    private static int[][] findLocalMax(int[][] matrix) {

        int m = matrix.length;

        int n = matrix[0].length;

        int[][] localMaxIndices = new int[m][n];


        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (isLocalMax(matrix, i, j)) {

                    localMaxIndices[i][j] = 1;

                }

            }

        }


        return localMaxIndices;

    }


    private static boolean isLocalMax(int[][] matrix, int row, int col) {

        int m = matrix.length;

        int n = matrix[0].length;

        int current = matrix[row][col];


        if (row > 0 && matrix[row - 1][col] >= current) {

            return false;

        }


        if (row < m - 1 && matrix[row + 1][col] >= current) {

            return false;

        }


        if (col > 0 && matrix[row][col - 1] >= current) {

            return false;

        }


        return col >= n - 1 || matrix[row][col + 1] < current;

    }


    private static int[][] findLocalMin(int[][] matrix) {

        int m = matrix.length;

        int n = matrix[0].length;

        int[][] localMinIndices = new int[m][n];


        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (isLocalMin(matrix, i, j)) {

                    localMinIndices[i][j] = 1;

                }

            }

        }


        return localMinIndices;

    }


    private static boolean isLocalMin(int[][] matrix, int row, int col) {

        int m = matrix.length;

        int n = matrix[0].length;

        int current = matrix[row][col];


        if (row > 0 && matrix[row - 1][col] <= current) {

            return false;

        }


        if (row < m - 1 && matrix[row + 1][col] <= current) {

            return false;

        }


        if (col > 0 && matrix[row][col - 1] <= current) {

            return false;

        }


        return col >= n - 1 || matrix[row][col + 1] > current;

    }


    private static int[][] replaceLocalMaxWithMin(int[][] matrix, int[][] localMaxIndices, int[][] localMinIndices) {

        int m = matrix.length;

        int n = matrix[0].length;

        int[][] modifiedMatrix = new int[m][n];


        int localMinCount = countLocalMin(localMinIndices);

        int localMaxCount = countLocalMax(localMaxIndices);


        int minIndex = 0;

        int maxIndex = 0;


        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (localMaxIndices[i][j] == 1) {

                    if (minIndex < localMinCount) {

                        modifiedMatrix[i][j] = findNextLocalMin(matrix, localMinIndices, minIndex);

                        minIndex++;

                    } else {

                        modifiedMatrix[i][j] = -findNextLocalMin(matrix, localMinIndices, maxIndex);

                        maxIndex++;

                    }

                } else {

                    modifiedMatrix[i][j] = matrix[i][j];

                }

            }

        }


        return modifiedMatrix;

    }


    private static int countLocalMin(int[][] localMinIndices) {

        int count = 0;


        for (int[] row : localMinIndices) {

            for (int value : row) {

                if (value == 1) {

                    count++;

                }

            }

        }


        return count;

    }


    private static int countLocalMax(int[][] localMaxIndices) {

        int count = 0;


        for (int[] row : localMaxIndices) {

            for (int value : row) {

                if (value == 1) {

                    count++;

                }

            }

        }


        return count;

    }


    private static int findNextLocalMin(int[][] matrix, int[][] localMinIndices, int startIndex) {

        int m = matrix.length;

        int n = matrix[0].length;


        int currentIndex = 0;


        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (localMinIndices[i][j] == 1) {

                    if (currentIndex == startIndex) {

                        return matrix[i][j];

                    }

                    currentIndex++;

                }

            }

        }


        return 0;

    }


    private static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {

            System.out.println(Arrays.toString(row));

        }

        System.out.println();

    }

}