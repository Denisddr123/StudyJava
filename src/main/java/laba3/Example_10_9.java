package laba3;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Example_10_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите размер массива ");
        int number = scanner.nextInt();
        Integer[] arr = new Integer[number];
        Random random = new Random();
        Integer[][] array = new Integer[number][2];
        int a = 201;
        int j = 0;

        System.out.println("Размер массива = "+number);

        for (int i = 0; i < number; i++) {
            arr[i] = random.nextInt(200);

            if (arr[i] == a) {
                j=j+1;
                array[j][1] = i;
                array[j][0] = arr[i];
            }
            if (arr[i] < a) {
                array = new Integer[number][2];
                j = 0;
                array[j][1] = i;
                array[j][0] = arr[i];
                a = arr[i];
            }
        }

        String[] arrayFilter = new String[j+1];

        for (int i=0; i<j+1; i++) {
            arrayFilter[i]= array[i][0]+" минимальное значение "+array[i][1]+" позиция в массиве";
        }

        System.out.println("Массив полностью = " + Arrays.toString(arr));

        System.out.println("Массив полностью = " + Arrays.toString(arrayFilter));
    }
}
