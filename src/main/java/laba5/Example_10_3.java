package laba5;
import java.util.Scanner;

public class Example_10_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExampleInt exampleInt;
        int a, b;

        System.out.println("Создаётся объект, у которого есть два целочисленных поля");

        System.out.println("Введите первый параметр");
        a = scanner.nextInt();

        System.out.println("Введите второй параметр");
        b = scanner.nextInt();

        System.out.println("Без передачи параметров конструктору, переменным присваиваются нулевые значения");

        exampleInt = new ExampleInt();
        System.out.println(exampleInt.getExample());

        System.out.println("С одним параметром");

        exampleInt = new ExampleInt(a);
        System.out.println(exampleInt.getExample());

        System.out.println("С двумя параметрами");

        exampleInt = new ExampleInt(a, b);
        System.out.println(exampleInt.getExample());
    }
}

class ExampleInt {
    private final int a;
    private final int b;

    ExampleInt() {
        this.a = 0;
        this.b = 0;
    }

    ExampleInt(int a) {
        this.a = a;
        this.b = 0;
    }

    ExampleInt(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String getExample() {
        return a + " " + b;
    }
}