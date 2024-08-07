package newLaba11;

import java.util.List;
import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        String string = "Напишите функцию, которая принимает на вход список строк и " +
                "возвращает новый список, содержащий только те строки, которые имеют " +
                "длину больше заданного значения.";
        int lenght;
        System.out.println(string);
        System.out.println("Введите длину строки:");
        Scanner scanner = new Scanner(System.in);
        lenght = scanner.nextInt();

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n Строка после сплитирования: \n");
        for (String e: strings) {
            System.out.println(e);
        }

        List<String> stringsAfter = filterCapitalizedStrings(strings, lenght);

        System.out.println("\n Строка после преобразования: \n");
        for (String e: stringsAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> list, int lenght) {
        return list.stream().filter(s -> s.length() > lenght)
                .toList();
    }
}
