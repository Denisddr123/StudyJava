package laba6;
import java.util.Arrays;

public class Example_10_10 {
    public static void main(String[] args) {
        int[] arr = {54, 54,65,36,57,35,78,45,76,43};
        System.out.println("массив = " + Arrays.toString(arr));
        System.out.println("минимум и максимум = " + Arrays.toString(ArrayMinMax.valueMinMax(arr)));
    }
}

class ArrayMinMax {
    static int[] valueMinMax(int ... arr) {
        int x = arr.length;
        Arrays.sort(arr);

        return new int[]{arr[0], arr[x - 1]};
    }
}
