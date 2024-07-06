package laba10;

import java.util.Arrays;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println("Введите целые, положительные числа");
        for (int x = 0; x<5; x++) {
            try {
                if ((arr[x] = Integer.parseInt(scanner.next())) < 0) throw new ArithmeticException("Введёное число должно быть положительным.");
            } catch (NumberFormatException e) {
                System.out.println("Введённое значение не должно быть строкой или числом с плавающей точкой");
                x = x-1;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                x = x-1;
            }
        }
        System.out.println(Arrays.stream(arr).sum()/arr.length);
    }
}
