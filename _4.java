import java.util.ArrayList;

public class _4 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'(', '8', '+', '2', ')', '-', '(', '3', '+', '1', ')', '=', '5'},
                {'2', '+', '3', '+', '4', '=', '9'},
                {'(', '6', '+', '1', ')', '-', '2', '=', '5'}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        ArrayList<String> incorrectExpressions = new ArrayList<>();

        // Проверка по строкам
        for (int i = 0; i < rows; i++) {
            String expression = "";
            int result = 0;
            boolean validExpression = true;

            for (int j = 0; j < cols; j++) {
                if (Character.isDigit(matrix[i][j])) {
                    expression += matrix[i][j];
                } else if (matrix[i][j] == '(') {
                    int start = j + 1;
                    while (matrix[i][j] != ')') {
                        j++;
                    }
                    int end = j - 1;
                    String subExpression = expression.substring(start, end);
                    try {
                        result = Integer.parseInt(subExpression);
                    } catch (NumberFormatException e) {
                        validExpression = false;
                    }
                } else if (matrix[i][j] == '=') {
                    int expectedResult = Character.getNumericValue(matrix[i][j + 1]);
                    if (result != expectedResult) {
                        validExpression = false;
                        incorrectExpressions.add(expression + "=" + expectedResult);
                    }
                    break;
                } else {
                    expression += matrix[i][j];
                }
            }

            if (validExpression) {
                System.out.println("Правильное выражение по строке " + (i + 1) + ": " + expression);
            } else {
                System.out.println("Неправильное выражение по строке " + (i + 1) + ": " + expression);
            }
        }

        // Проверка по столбцам
        for (int j = 0; j < cols; j++) {
            String expression = "";
            int result = 0;
            boolean validExpression = true;

            for (int i = 0; i < rows; i++) {
                if (Character.isDigit(matrix[i][j])) {
                    expression += matrix[i][j];
                } else if (matrix[i][j] == '(') {
                    int start = j + 1;
                    while (matrix[i][j] != ')') {
                        j++;
                    }
                    int end = j - 1;
                    String subExpression = expression.substring(start, end);
                    try {
                        result = Integer.parseInt(subExpression);
                    } catch (NumberFormatException e) {
                        validExpression = false;
                    }
                } else if (matrix[i][j] == '=') {
                    int expectedResult = Character.getNumericValue(matrix[i][j + 1]);
                    if (result != expectedResult) {
                        validExpression = false;
                        incorrectExpressions.add(expression + "=" + expectedResult);
                    }
                    break;
                } else {
                    expression += matrix[i][j];
                }
            }

            if (validExpression) {
                System.out.println("Правильное выражение по столбцу " + (j + 1) + ": " + expression);
            } else {
                System.out.println("Неправильное выражение по столбцу " + (j + 1) + ": " + expression);
            }
        }

        // Вывод неправильно вычисленных выражений
        System.out.println("Неправильно вычисленные выражения:");
        for (String incorrectExpression : incorrectExpressions) {
            System.out.println(incorrectExpression);
        }
        System.out.println("Количество неправильно вычисленных выражений: " + incorrectExpressions.size());
    }
}
