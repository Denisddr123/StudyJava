package laba5;
import java.util.Scanner;

public class Example_10_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExCharInt exCharInt;
        int b;
        char aChar;
        double a;

        System.out.println("Введите символ");
        aChar = scanner.nextLine().charAt(0);

        System.out.println("Введите целое число");
        b = scanner.nextInt();

        System.out.println("Введите число с плавающей точкой");
        a = scanner.nextDouble();

        scanner.close();

        exCharInt = new ExCharInt(aChar, b);
        System.out.println("Конструктор с параметрами: символьный и целочисленный:");
        System.out.println(exCharInt.getaChar()+" "+ exCharInt.getB());

        exCharInt = new ExCharInt(a);
        System.out.println("Конструктор с параметром: число с плавающей запятой:");
        System.out.println(exCharInt.getaChar()+" "+ exCharInt.getB());
    }
}

class ExCharInt {
    private final char aChar;
    private final int b;

    ExCharInt(char aChar, int b) {
        this.aChar = aChar;
        this.b = b;
    }

    ExCharInt(double a) {
        int x = (int) a;
        this.aChar =(char) x;
        this.b =((int) (a*100)) - x*100;
    }

    public char getaChar() {
        return aChar;
    }

    public int getB() {
        return b;
    }
}