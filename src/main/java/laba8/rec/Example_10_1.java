package laba8.rec;

public class Example_10_1 {
    static int y;
    private static int step = 0;
    public static void main(String[] args) {
        int i = 12;
        y = 60;
        System.out.println("Прямая последовательность (2*х+1) ");
        rec1(2);
        System.out.println("Обратная последовательность (2*х+1) ");
        rec2(2);
        System.out.println("Вывод параметра перед вхождением и после него: ");
        rec3(2);
        System.out.println("Вычисление факториала ");

        System.out.println("факториал числа " + i + " равен: "+ fact(i));
        System.out.println("Вычисление числа Фибоначчи по его порядковому номеру ");
        step = 0;
        i=9;
        System.out.println("Под номером "+i+" число Фибоначчи = " + value(i));
    }

    public static void rec1(int x) {
        int i = z(x);
        System.out.println("x = " + x);
        if (aBoolean(i)) {
            rec1(i);
        }
    }

    public static void rec2(int x) {
        int i = z(x);
        if (aBoolean(i)) { rec2(i); }
        System.out.println("x = " + x);
    }

    public static void rec3(int x) {
        space();
        int i = z(x);
        System.out.println( x+"-> ");
        step++;
        if (aBoolean(i)) { rec3(i); }
        step--;
        space();
        System.out.println( x+" <-");
    }

    public static void f() {
        System.out.println("Рекурсивный вызов метода № " + ++step);
    }

    public static void nResult(int result) {
        System.out.println("Метод вернул значение = " + result);
    }

    public static int value(int x) {
        int result;
        if (x==0) {
            result = 0;
            nResult(result );
            return result;
        } else if (x==1) {
            result = 1;
            nResult(result);
            return result;
        } else {
            f();
            result = value(x-2)+value(x-1);
            nResult(result);
            return result;
        }
    }

    public static int fact(int x) {
        int result;
        if (x==1) return 1;
        else { result = fact(x-1)*x; }
        return result;
    }

    public static void space() {
        for (int i=0; i<step; i++) {
            System.out.print(" ");
        }
    }

    public static boolean aBoolean(int z) {
        return z<y;
    }

    public static int z(int x) {return (2*x+1); }
}
