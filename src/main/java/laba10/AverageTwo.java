package laba10;

import java.util.Arrays;
import java.util.Scanner;

public class AverageTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println("Введите целое, положительное число");
        for (int x = 0; x<5; x++) {
            try {
                arr[x] = parseIntFromString(scanner.next());
                checkPositiveNumber(arr[x]);
            } catch (NumberFormatException e) {
                System.out.println("Введённое значение не должно быть строкой или числом с плавающей точкой");
                x = x-1;
            } catch (MyException e) {
                System.out.println(e.getMessage());
                x = x-1;
            }
        }
        System.out.println("Среднее значение равно "+Arrays.stream(arr).sum()/arr.length);
    }
    public static int parseIntFromString(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }
    public static void checkPositiveNumber(int x) throws MyException {
        if (x<0) throw new MyException("Введёное число должно быть положительным.");
    }
}
