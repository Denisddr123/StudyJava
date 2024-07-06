package laba1;

import java.util.Scanner;

class example_10_9
{
    public static void main(String[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("введите имя: ");
        String name = scanner.nextLine();
        System.out.print("введите возраст: ");
        int age = scanner.nextInt();
        System.out.printf("имя: %s возраст: %d \n", name, age);
        scanner.close();
    }
}
