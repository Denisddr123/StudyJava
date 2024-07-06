package laba6;

import java.util.Arrays;

public class Example_10_3 {
    public static void main(String[] args) {
        Example3.aVoid(1,3,76,42,335,32,1,88);
        int[] arr = {1,2,6,54,78,67,68,46,32};
        Example3.aVoid(arr);
    }
}

class Example3 {
    static void aVoid (int ... v) {
        Arrays.sort(v);
        int a = v.length;
        System.out.println("v = " + Arrays.toString(v));
        System.out.println("минимальное значение " + v[0]+", максимальное значение "+v[a - 1]);
        if (a % 2 == 0) {
            System.out.println("средние значения " + v[(a-1)/2]+", и "+v[(a-1)/2 + 1]);
        } else {
            System.out.println("среднее значение " + v[a/2]);
        }


    }
}