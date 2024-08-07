package newLaba11;

import java.util.List;

public class Example9 {
    public static void main(String[] args) {
        String string = "Напишите функцию, которая 999 принимает на 99/9 вход список 111111 строк и " +
                "возвращает новый 2список, содержащий только@ те строки, которые11 содержат\n" +
                "только буквы (без цифр и символов).";
        System.out.println(string);

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n Строка после сплитирования: \n");
        for (String e: strings) {
            System.out.println(e);
        }

        List<String> stringsAfter = filterCapitalizedStrings(strings);

        System.out.println("\n Строка после преобразования: \n");
        for (String e: stringsAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream().filter(s -> s.matches("[а-яА-Я]+"))
                .toList();
    }
}
