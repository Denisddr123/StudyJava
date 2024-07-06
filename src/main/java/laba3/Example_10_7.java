package laba3;

import java.util.Arrays;
import java.util.Collections;

public class Example_10_7 {

    public static int number = 10;
    public static void main(String[] args) {

        String[] strings = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        String[] strings1 = new  String[number];
        String[] strings2 = new String[number];
        System.out.println("strings = " + Arrays.toString(strings));

        for (int i = 0, j = 0; i < number; i++, j=j+2) {
            strings1[i] = strings[j];
            strings2[number-1-i] = strings[j];
        }

        System.out.println("Массив в прямом порядке = " + Arrays.toString(strings1));

        Arrays.sort(strings1, Collections.reverseOrder());
        System.out.println("Массив отсортированный в обратном порядке с помощью Collections.reverseOrder() = " + Arrays.toString(strings1));

        System.out.println("Массив отсортированный в обратном порядке в цикле for = " + Arrays.toString(strings2));
    }
}
