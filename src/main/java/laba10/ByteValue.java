package laba10;

import java.util.Scanner;

public class ByteValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte[] bytes = new byte[5];
        int y;
        String str;
        System.out.println("Ввод чисел в диапазоне типа Byte.");
        for (int x = 0; x<5; x++) {
            try {
                str = scanner.next();
                y = Integer.parseInt(str);
                if (y>127 || y<-128) throw new MyException("Выход за диапазон значений для типа Byte.");
                bytes[x] = (byte) y;
            } catch (NumberFormatException e) {
                System.out.println("Введённое значение не должно быть строкой.");
                x = x-1;
            } catch (MyException e) {
                System.out.println(e.getMessage());
                x = x-1;
            }
        }
        y=0;
        for (int a: bytes) {
            y = y+a;
        }
        System.out.println("Сумма равна "+y);
    }
}
