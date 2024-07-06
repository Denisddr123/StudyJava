package laba3;

import java.util.Scanner;

public class Example_10_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите день недели");
        String day = scanner.nextLine();

        int numberDay;
        numberDay = dayOfWeek(day);
        if (numberDay == 0) {
            System.out.print("Нет такого дня недели");

        } else System.out.printf("День недели %d", numberDay);
    }

    public static int dayOfWeek(String day) {
        int value;
        switch (day) {
            case "Понедельник":
                value = 1;
                break;
            case "Вторник":
                value = 2;
                break;
            case "Среда":
                value = 3;
                break;
            case "Четверг":
                value = 4;
                break;
            case "Пятница":
                value = 5;
                break;
            case "Суббота":
                value = 6;
                break;
            case "Воскресенье":
                value = 7;
                break;
            default:
                value = 0;
                break;
        }
        return value;
    }
}