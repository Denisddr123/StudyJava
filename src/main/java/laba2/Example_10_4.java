package laba2;

import java.util.Scanner;

public class Example_10_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        if (5 <= number && number <= 10) {
            System.out.printf("Число %d больше либо равно 5 и меньше либо равно 10", number);
        } else {
            System.out.printf("Число %d не больше 4 или не меньше 11", number);
        }
    }
}
