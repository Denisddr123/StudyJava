package laba3;

import java.util.Scanner;

public class Example_10_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 2;

        System.out.println("Введите количество чисел, которое будет выведенно из последовательности Фибоначчи");
        int number = scanner.nextInt();
        int[] forNumbs = new int[number];
        int[] whileNumbs = new int[number];
        forNumbs[0] = 1;
        forNumbs[1] = 1;
        whileNumbs[0] = 1;
        whileNumbs[1] = 1;

        for (int i = 2; i < number; i++)
        {
            forNumbs[i] = forNumbs[i-2]+forNumbs[i-1];
        }

        for (int i = 0; i < number; i++)
        {
            System.out.println("Элемент массива ["+i+"] в цикле for = " + forNumbs[i]);
        }

        while (count < number) {
            whileNumbs[count] = whileNumbs[count - 1] + whileNumbs[count - 2];
            count++;
        }

        count = 0;

        for (int whilenumb : whileNumbs) {
            System.out.println("Элемент массива ["+count+"] в цикле foreach = " + whilenumb);
            count++;
        }

    }
}
