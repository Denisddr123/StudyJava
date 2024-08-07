package newLaba11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                Напишите функцию, которая принимает на вход список целых чисел и
                возвращает новый список, содержащий только те числа, которые меньше
                заданного значения.""");
        List<Integer> integers = new ArrayList<>();

        System.out.println("Введите размер списка");
        int size = in.nextInt();
        Random random = new Random();
        System.out.println("Введите число для сравнения:");
        int y = in.nextInt();

        for (int i = 0; i < size; i++) {
            integers.add(random.nextInt(1000));
        }
        System.out.println("Список до фильтра = " + integers);

        List<Integer> integersAfter = filterEqualsNumbers(integers, y);

        System.out.println("Список после фильтра = " + integersAfter);
    }

    public static List<Integer> filterEqualsNumbers(List<Integer> integerList, int y) {
        return integerList.stream().filter(x -> x < y).toList();
    }
}
