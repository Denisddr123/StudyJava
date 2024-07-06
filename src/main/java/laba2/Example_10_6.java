package laba2;

import java.util.Scanner;

public class Example_10_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        if (number%5 == 2) {

            if (number%7 == 1) {
                System.out.printf("Число %d при делении на 5 в остатке 2, при делении на 7 в остатке 1", number);
                return;
            }
        }

        System.out.printf("Число %d не подходит под условие", number);
    }
}
