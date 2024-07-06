package laba4;

import java.util.Scanner;

public class Example_10_8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сообщение: ");
        String beforeString = scanner.nextLine();
        char[] afterString = new char[beforeString.length()];

        System.out.println("Введите ключ: ");
        int key = scanner.nextInt();

        for (int i = 0; i < beforeString.length(); i++) {
            afterString[i] = (char) (beforeString.charAt(i) + key);
        }

        System.out.println("новая строка: " + new String(afterString));

        System.out.println("Выполнить обратное преобразование? Введите Y для подтверждения или N для выхода");

        do {
            String boolStr = scanner.next();
            boolStr = boolStr.toLowerCase();

            if (boolStr.equals("y")) {
                for (int i = 0; i < afterString.length; i++) {
                    afterString[i] = (char) (afterString[i] - key);
                }
                System.out.println("новая строка: " + new String(afterString));
                break;
            } else if (boolStr.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else System.out.println("Введите корректный ответ");

        } while (true);

    }
}
