package laba3;

import java.util.Scanner;

public class Example_10_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        int b;
        int x;
        int y = 1;
        x = scanner.nextInt();

        System.out.println("Цикл for");

        for (int i = 1; i < x*3; i=i+3) {
            b = i*5+2;
            System.out.println("Число: "+b);
            a = a + b;
        }

        System.out.println("Сумма равна: "+a);
        a = 0;

        System.out.println("Цикл while");

        while (0 < x) {
            b = y*5+2;
            a = a+b;
            System.out.println("Число: "+b);
            y = y+3;
            x--;
        }

        System.out.println("Сумма равна: "+a);
    }
}
