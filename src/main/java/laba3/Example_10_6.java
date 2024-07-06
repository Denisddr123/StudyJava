package laba3;

import java.util.Arrays;
import java.util.Scanner;

public class Example_10_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность создаваемого массива");
        int number = scanner.nextInt();
        int[] arr = new int[number];

        System.out.println("Введите по одному числа, в результате деления на 5 которые, дают в остатке 2 и заполните массив.");

        for (int i=1; i<=number; ) {
            System.out.println("Введите число под номером " +i+" из "+number);
            int a = scanner.nextInt();
            if (a%5 == 2) {
                arr[i-1]=a;
                i++;
            } else {
                System.out.println("Вы ввели не верное число = " + a);
            }

        }

        System.out.println("Массив полностью = " + Arrays.toString(arr));
    }
}
