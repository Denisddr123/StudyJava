package laba6;
import java.util.Arrays;

public class Example_10_7 {
    public static void main(String[] args) {
        char[] arr = {'a','d','v','i','c','e'};
        System.out.println("массив символов = " + Arrays.toString(arr));
        System.out.println("целочисленным массив, состоящий из кодов символов из массива-аргумента = " + Arrays.toString(CharExample.arrChar(arr)));
    }
}

class CharExample {
    static int[] arrChar(char[] arr) {
        int[] ints = new int[arr.length];
        for (int i =0; i<arr.length; i++) {
            ints[i] = arr[i];
        }
        return ints;
    }
}