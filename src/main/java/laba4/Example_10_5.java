package laba4;

import java.util.Random;
import java.util.Scanner;

public class Example_10_5 {
    public static void main(String[] args) {
        int a, b;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размерность двухмерного массива, \n" +
                "число строк: ");
        a = scanner.nextInt();

        System.out.println("число столбцов: ");

        b = scanner.nextInt();

        int[][] arr = new int[a][b];
        int[][] arr2 = new int[b][a];

        for (int i=0; i<a; i++) {
            for (int j=0; j<b; j++) {
                arr[i][j]=random.nextInt(10);
            }
        }

        for (int j=0; j<b; j++) {
            for (int i=0; i<a; i++) {
                arr2[j][i] = arr[a-i-1][j];
            }
        }

        for (int[] x: arr) {
            for (int y: x) {
                System.out.print(y+" ");
            }
            System.out.println();
        }

        System.out.println("Перевёрнутый массив.");

        for (int[] x: arr2) {
            for (int y: x) {
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }
}
