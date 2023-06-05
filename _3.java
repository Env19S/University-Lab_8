import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;


public class _3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Введите количество точек (N): ");

        int n = scanner.nextInt();


        int[] coordinates = new int[2 * n];

        System.out.println("Введите координаты точек (x, y) через пробел:");


        for (int i = 0; i < 2 * n; i++) {

            coordinates[i] = scanner.nextInt();

        }


        List<Integer> trianglePoints = findIsoscelesTrianglePoints(coordinates);


        if (trianglePoints.isEmpty()) {

            System.out.println("В заданном массиве нет точек, которые могут являться вершинами равнобедренного треугольника.");

        } else {

            System.out.println("Точки, которые могут являться вершинами равнобедренного треугольника: ");

            for (int point : trianglePoints) {

                System.out.println("Номер точки: " + point);

            }

        }

    }


    private static List<Integer> findIsoscelesTrianglePoints(int[] coordinates) {

        List<Integer> trianglePoints = new ArrayList<>();


        for (int i = 0; i < coordinates.length; i += 2) {

            int x1 = coordinates[i];

            int y1 = coordinates[i + 1];


            for (int j = i + 2; j < coordinates.length; j += 2) {

                int x2 = coordinates[j];

                int y2 = coordinates[j + 1];


                if (isIsoscelesTriangle(x1, y1, x2, y2)) {

                    trianglePoints.add(i / 2 + 1);

                    trianglePoints.add(j / 2 + 1);

                }

            }

        }


        return trianglePoints;

    }


    private static boolean isIsoscelesTriangle(int x1, int y1, int x2, int y2) {

        int dx = Math.abs(x2 - x1);

        int dy = Math.abs(y2 - y1);

        return dx == dy;

    }

}