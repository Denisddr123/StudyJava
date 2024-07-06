package laba4;

import java.util.Scanner;

public class Example_10_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         System.out.println("Напишите программу, в которой создается двумерный массив,\n" +
                 "который выводит прямоугольник из цифр 2");

         System.out.println("Введите размер длины одной стороны: ");
         int a = scanner.nextInt();

         System.out.println("Введите размер длины другой стороны: ");
         int b = scanner.nextInt();
         int[][] arr = new int[a][b];

        for (int i=0; i<a; i++){
            for (int j=0; j<b; j++) {
                arr[i][j] = 2;
            }
        }

        for (int [] x: arr) {
            for (int y: x) {
                System.out.print(y);
            }
            System.out.println("");
        }
    }
}
