import java.util.Scanner;


public class _2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Введите элементы массива через пробел: ");

        String input = scanner.nextLine();

        String[] elements = input.split(" ");

        int[] sequence = new int[elements.length];


        for (int i = 0; i < elements.length; i++) {

            sequence[i] = Integer.parseInt(elements[i]);

        }


        boolean isPerrinSequence = checkPerrinSequence(sequence);


        if (isPerrinSequence) {

            System.out.println("Введенный массив является последовательностью Перрина.");

        } else {

            System.out.println("Введенный массив не является последовательностью Перрина.");

        }

    }


    private static boolean checkPerrinSequence(int[] sequence) {

        if (sequence.length < 3) {

            return false;

        }


        if (sequence[0] != 3 || sequence[1] != 0 || sequence[2] != 2) {

            return false;

        }


        for (int i = 3; i < sequence.length; i++) {

            int nextElement = sequence[i - 2] + sequence[i - 3];

            if (sequence[i] != nextElement) {

                return false;

            }

        }


        return true;

    }

}