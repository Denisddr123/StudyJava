package laba5;
import java.util.Scanner;

public class Example_10_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OneInt oneInt;
        int a;

        System.out.println("Введите значение целочисленной переменной");
        a = scanner.nextInt();

        oneInt = new OneInt();
        System.out.println("Создать объект, не передавая параметров в конструктор, переменная равна "+oneInt.getA());

        oneInt = new OneInt(a);
        System.out.println("Конструктор с параметрами, переменная равна "+oneInt.getA());
    }
}

class OneInt {
    private int a;

    OneInt() {
        this.a = 0;
    }

    OneInt(int a) {
        this.a = Math.min(a, 100);
    }

    public void setA(int a) {
        this.a = Math.min(a, 100);
    }

    public void setA() {
        this.a = 0;
    }

    public int getA() {
        return a;
    }
}