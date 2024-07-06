package laba10;

import java.util.Scanner;

public class ByteValueTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte[] bytes = new byte[5];
        int y;
        String str;
        System.out.println("Ввод чисел в диапазоне типа Byte.");
        for (int x = 0; x<5; x++) {
            try {
                str = scanner.next();
                y = getInt(str);
                checkRangeByte(y);
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
    public static void checkRangeByte(int x) throws MyException {
        if (x>127 || x<-128) throw new MyException("Выход за диапазон значений для типа Byte.");
    }
    public static int getInt(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }
}
