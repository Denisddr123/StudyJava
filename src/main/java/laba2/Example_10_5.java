package laba2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Example_10_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        Pattern p = Pattern.compile("(\\d+)\\d{3}(,?\\d*)");

        Matcher m = p.matcher(number);
        boolean result = m.matches();

        if (result) {
            System.out.printf("Число %s содержит %s тысяч", number, m.group(1));

            return;
        }

        System.out.printf("Вы ввели %s, это должно быть число не меньше тысячи", number);


    }
}