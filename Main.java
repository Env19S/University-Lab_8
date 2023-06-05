import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Введите количество элементов в массиве: ");

        int n = scanner.nextInt();


        int[] octalArray = new int[n];


        System.out.println("Введите элементы массива (целые числа от 0 до 8):");

        for (int i = 0; i < n; i++) {

            int element = scanner.nextInt();

            if (element < 0 || element > 8) {

                System.out.println("Некорректный элемент. Допустимы только числа от 0 до 8.");

                return;

            }

            octalArray[i] = element;

        }


        int decimalNumber = convertOctalToDecimal(octalArray);

        int[] decimalArray = convertDecimalToArray(decimalNumber);


        System.out.println("В 10-ой:");

        for (int element : decimalArray) {

            System.out.println(element);

        }

    }


    private static int convertOctalToDecimal(int[] octalArray) {

        int decimalNumber = 0;

        int power = 0;

        for (int i = octalArray.length - 1; i >= 0; i--) {

            decimalNumber += octalArray[i] * Math.pow(9, power);

            power++;

        }

        return decimalNumber;

    }


    private static int[] convertDecimalToArray(int decimalNumber) {

        String decimalString = String.valueOf(decimalNumber);

        int[] decimalArray = new int[decimalString.length()];

        for (int i = 0; i < decimalString.length(); i++) {

            decimalArray[i] = Integer.parseInt(String.valueOf(decimalString.charAt(i)));

        }

        return decimalArray;

    }

}