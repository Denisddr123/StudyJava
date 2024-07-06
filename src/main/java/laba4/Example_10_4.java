package laba4;

import java.util.Arrays;
import java.util.Scanner;

public class Example_10_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Напишите программу, в которой создается двумерный массив,\n" +
                "который выводит прямоугольный треугольник");

        System.out.println("Введите размер длины одной стороны: ");
        int a = scanner.nextInt();

        System.out.println("Введите размер длины другой стороны: ");
        int b = scanner.nextInt();
        int[][] arr = new int[a][];
        int x, i, w;

        if (a>b) {
            x = a/b;
            for (i=0; i<a; i++){
                w = ((i /x)+1);
                arr[i] = new int[w];

                Arrays.fill(arr[i], 2);
            }

        } else if (b>a) {
            x = b/a;
            for (i=0; i<a; i++){
                w = ((i+1) *x);
                arr[i] = new int[w];

                Arrays.fill(arr[i], 2);
            }
        } else {
            for (i=0; i<a; i++){
                arr[i] = new int[i+1];

                Arrays.fill(arr[i], 2);
            }
        }



        for (int [] xx: arr) {
            for (int yy: xx) {
                System.out.print(yy);
            }
            System.out.println();
        }
    }
}
