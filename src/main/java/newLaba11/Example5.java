package newLaba11;

import java.util.List;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        String string = "Напишите функцию, которая принимает на вход список строк и " +
                "возвращает новый список, содержащий только те строки, которые содержат " +
                "заданную подстроку.";
        String substring;
        System.out.println(string);
        System.out.println("Введите подстроку:");
        Scanner scanner = new Scanner(System.in);
        substring = scanner.next();

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n Строка после сплитирования: \n");
        for (String e: strings) {
            System.out.println(e);
        }

        List<String> stringsAfter = filterCapitalizedStrings(strings, substring);

        System.out.println("\n Строка после преобразования: \n");
        for (String e: stringsAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> list, String substring) {
        return list.stream().filter(s -> s.toLowerCase().contains(substring.toLowerCase()))
                .toList();
    }
}
