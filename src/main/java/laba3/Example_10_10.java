package laba3;

import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

public class Example_10_10 {
    public static void main(String[] args) {
        int number = 20;
        Integer[] array = new Integer[number];
        Random random = new Random();

        for (int i=0; i<number; i++) {
            array[i] = random.nextInt(200);
        }

        System.out.println("Массив из "+number+" элементов                                    "+Arrays.toString(array));

        Arrays.sort(array, Collections.reverseOrder());

        System.out.println("Массив из "+number+" элементов отсортированный в обратном порядке "+Arrays.toString(array));
    }
}
