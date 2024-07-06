package laba1;

import java.util.Scanner;

class example_10_10
{
    public static void main(String[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("день недели: ");
        String dayOfWeek = scanner.nextLine();
        System.out.print("месяц: ");
        String month = scanner.nextLine();
        System.out.print("число: ");
        int number = scanner.nextInt();
        System.out.printf("дата: %s %d %s \n", dayOfWeek, number, month);
        scanner.close();
    }
}
