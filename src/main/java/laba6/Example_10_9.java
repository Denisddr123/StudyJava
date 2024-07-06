package laba6;

import java.util.Arrays;

public class Example_10_9 {
    public static void main(String[] args) {
        char[] arr = {'a','d','v','i','c','e'};
        System.out.println("массив символов до сортировки = " + Arrays.toString(arr));
        System.out.println("массив символов после сортировки = " + Arrays.toString(ParnigientChange.valueArr(arr)));
    }
}

class ParnigientChange {
    static char[] valueArr(char[] arr) {
        int x=arr.length;
        char yChar;
        for (int i=1; i<x; i +=2) {
            yChar = arr[i-1];
            arr[i-1] = arr[i];
            arr[i] = yChar;
        }
        return arr;
    }
}