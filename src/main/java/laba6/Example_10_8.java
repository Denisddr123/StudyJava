package laba6;
import java.util.Arrays;

public class Example_10_8 {
    public static void main(String[] args) {
        int[] arr = {54, 54,65,36,57,35,78,45,76,43};
        System.out.println("массив = " + Arrays.toString(arr));
        System.out.println("среднее = " + AverageValue.average(arr));
    }
}

class AverageValue {
    static double average(int[] arr) {
        int x = arr.length;
        int y = 0;
        for (int j : arr) {
            y += j;
        }
        return (double) y/x;
    }
}
