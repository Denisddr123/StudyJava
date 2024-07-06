package laba2;

import java.util.Scanner;

public class Example_10_1
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        if (number%3 == 0){
            System.out.printf("Число %d делится на 3", number);
        } else System.out.printf("Число %d не делится на 3", number);
    }
}
