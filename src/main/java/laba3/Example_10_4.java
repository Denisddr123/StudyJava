package laba3;

import java.util.Scanner;

public class Example_10_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;
        int i;

        System.out.println("Введите первое число");
        int a = scanner.nextInt();

        System.out.println("Введите второе число");
        int b = scanner.nextInt();

        if (a>b){
            count = a;
            i = b;
        } else {
            count = b;
            i = a;
        }

        System.out.println("Цикл for");
        for (int j = i; j<=count; j++)
            System.out.println(j);

        System.out.println("Цикл do while");
        do {
            System.out.println(i);
            i++;
        } while (i<=count);
    }
}
