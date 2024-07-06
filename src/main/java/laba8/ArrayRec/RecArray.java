package laba8.ArrayRec;
import java.util.Arrays;
import java.util.Scanner;

public class RecArray {
    static int[] arr;
    static int j=0, i=0;

    static String str = "";
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Созданать массив, используя рекурсию метода \n ");
        System.out.println("Создать массив, используя рекурсию метода \nВведите размер массива");
        i = scanner.nextInt();
        arr = new int[i];
        recArray();
        j = 0;
        System.out.println("Вывод полученного массива " + Arrays.toString(arr));

        System.out.println("Вывод массива с помощью рекурсивного метода " + getValue());
    }

    public static void recArray() {
        if (j<i) {
            System.out.println("Введите целочисленное значение в массив");
            arr[j] = scanner.nextInt();
            j++;
            recArray();
        }
    }

    static String getValue() {

        if (j<i) {
            str = arr[j++]+" "+getValue();
        }
        return str;
    }
}
