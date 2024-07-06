package laba5;
import java.util.Arrays;
import java.util.Scanner;

public class Example_10_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        TwoInt twoInt;

        System.out.println("Введите первое число");
        a = scanner.nextInt();

        System.out.println("Введите второе число");
        b = scanner.nextInt();

        twoInt = new TwoInt(a);
        System.out.println("Создание объекта с передачей одного аргумента, меньшее "+twoInt.getMin()+", большее "+twoInt.getMax());

        twoInt = new TwoInt(a, b);
        System.out.println("Создание объекта с передачей двух аргументов, меньшее "+twoInt.getMin()+", большее "+twoInt.getMax());
    }
}

class TwoInt {
    private int min;
    private int max;
    private int[] arr = new int[0];

    TwoInt(int a) {
        sortNumbers(a, 0);
    }

    TwoInt(int a, int b) {
        sortNumbers(a, b);
    }

    public void setNumbers(int a) {
        sortNumbers(a, 0);
    }

    public void setNumbers(int a, int b) {
        sortNumbers(a, b);
    }

    private void sortNumbers(int a, int b) {
        if (this.arr.length == 0) {
            this.arr = new int[]{a, b};
            Arrays.sort(arr);
        } else {
            int[] arr2 = {a, b};
            Arrays.sort(arr2);
            if (arr2[0]<arr[0]) arr[0] = arr2[0];
            if (arr2[1]>arr[1]) arr[1] = arr2[1];
        }
        this.min = arr[0];
        this.max = arr[1];


    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}