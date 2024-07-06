package laba6;
import java.util.Arrays;
public class Example_10_6 {
    public static void main(String[] args) {
        int[] a = {2,3,54,76,57,35,42,39,76};
        int b = 5;
        int[] arr = ArrayExample.array2(a, b);
        System.out.println(Arrays.toString(arr));
    }
}

class ArrayExample {
    static int[] array2(int[] arr, int a) {
        if (a>arr.length) return arr.clone();
        return  Arrays.copyOf(arr, a);
    }
}
