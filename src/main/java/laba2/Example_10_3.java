package laba2;

import java.util.Scanner;

public class Example_10_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        if (number > 10 && number%4 == 0 ) {
            System.out.printf("Число %d больше 10 и делится на 4", number);
            return;
        }

        System.out.printf("Число %d не больше 10 или не делится на 4", number);
    }
}
