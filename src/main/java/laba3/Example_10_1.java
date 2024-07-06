package laba3;

import java.util.Scanner;

public class Example_10_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер дня недели от 1 до 7");
        int number = scanner.nextInt();

        if (1 <= number && number <= 7) {
            System.out.printf("День недели %s", dayOfWeek(number));
        } else System.out.print("Не правильно ввели номер");
    }

    public static String dayOfWeek(int number) {
        String value = "";
        switch (number) {
            case 1:
                value = "Понедельник";
                break;
            case 2:
                value = "Вторник";
                break;
            case 3:
                value = "Среда";
                break;
            case 4:
                value = "Четверг";
                break;
            case 5:
                value = "Пятница";
                break;
            case 6:
                value = "Суббота";
                break;
            case 7:
                value = "Воскресенье";
                break;
            default:
                break;
        }
        return value;
    }
}
