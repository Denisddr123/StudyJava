package laba8.Binary;
import java.util.Scanner;

public class BinaryNumber {
    public static void main(String[] args) {
        int x;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число ");
        x = scanner.nextInt();
        System.out.println("Число " + x +" в двоичной системе равно: " + value(x));
    }

    public static int value(int x) {
        int result;
        if (x==0) {
            result = 0;
        } else {
            result = x%2+10*(value(x/2));
        }

        return result;
    }
}
