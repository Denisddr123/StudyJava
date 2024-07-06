package laba1;

import java.util.Scanner;

class example_10_11
{
    public static void main(String[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите месяц: ");
        String month = scanner.nextLine();
				System.out.print("введите количество дней: ");
        int number = scanner.nextInt();
        System.out.printf("месяц: %s содержит %d дней \n", month, number);
        scanner.close();
    }
}
