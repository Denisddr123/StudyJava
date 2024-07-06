package laba6;
import java.lang.Math;

public class Example_10_5 {
    public static void main(String[] args) {
        int a = 5;
        System.out.println("Вычисление суммы квадратов через рекурсию = " + Example5.sumPowRecursive(a));
        System.out.println("Вычисление суммы квадратов цикл = " + Example5.sumPowFor(a));
    }
}

class Example5 {
    static int sumPowRecursive(int a) {
        int result;
        if (a == 1) return 1;

        result = (int) (sumPowRecursive(a - 1) + Math.pow(a,2));
        return result;
    }

    static int sumPowFor(int b) {
        int result = 0;

        for (int a = b; a >=1; a--) {
            result = (int) (result + Math.pow(a,2));
        }
        return result;
    }
}
