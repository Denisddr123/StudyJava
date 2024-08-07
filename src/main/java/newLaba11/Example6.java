package newLaba11;

import java.util.*;

public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                Напишите функцию, которая принимает на вход список целых чисел и\s
                возвращает новый список, содержащий только те числа, которые делятся на
                заданное число без остатка.""");
        List<Integer> integers = new ArrayList<>();

        System.out.println("Введите размер списка");
        int size = in.nextInt();
        Random random = new Random();
        System.out.println("Введите делитель:");
        int y = in.nextInt();

        for (int i = 0; i < size; i++) {
            integers.add(random.nextInt(1000));
        }
        System.out.println("Список до фильтра = " + integers);

        List<Integer> integersAfter = filterNumbers(integers, y);

        System.out.println("Список после фильтра = " + integersAfter);
    }

    public static List<Integer> filterNumbers(List<Integer> integerList, int y) {
        return integerList.stream().filter(x -> x % y == 0).toList();
    }
}
