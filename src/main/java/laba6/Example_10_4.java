package laba6;


public class Example_10_4 {
    public static void main(String[] args) {
        int a = 8;
        System.out.println("Вычисление факториала через рекурсию = " + Factorial.factRecursive(a));
        System.out.println("Вычисление факториала через цикл = " + Factorial.factFor(a));
    }
}

class Factorial {
    static int factRecursive(int a) {
        int result;
        if (a < 2) return 1;

        result = factRecursive(a - 2) * a;
        return result;
    }

    static int factFor(int b) {
        int result = 1;

        for (int a = b; a >=1; a -=2) {
            result = result * a;
        }
        return result;
    }
}