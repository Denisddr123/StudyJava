package laba10;

public class Main {
    private static String[] args;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("example1");
        example1();
        System.out.println("example2");
        example2();
        System.out.println("example3");
        example3();
        System.out.println("example4");
        example4();
        System.out.println("example5");
        //example5();
        System.out.println("example6");
        example6();
        System.out.println("example7");
        //example7();
        System.out.println("example8");
        //System.out.println(example8());
        System.out.println("example9");
        System.out.println(example9());
        System.out.println("example10");
        System.out.println(example10());
        System.out.println("example11");
        example11();
        System.out.println("example12");
        //example12(null, 0.000001);
        System.out.println("example13");
        example13(args);
        System.out.println("example14");
        String[] arr = new String[0];
        example14(arr);
    }
    public static void example1() {
        try {
            System.out.println("0");
//          создан экземпляр RuntimeException с сообщением
            throw new RuntimeException("Непроверяемая ошибка");
//            исключение перехвачено
        } catch (RuntimeException e) {
//            исключение обработано
            System.out.println("1 "+e);
        }
        System.out.println("2");
    }
    public static void example2() {
        try {
            System.out.println("0");
//          создан экземпляр RuntimeException с сообщением
            throw new RuntimeException("Непроверяемая ошибка");
//            исключение перехвачено
        } catch (Exception e) {
//            исключение обработано
            System.out.println("2 "+e);
        }
        //следующий код выполняется
        System.out.println("3");
    }
    public static void example3() {
        try {
            System.out.println("0");
//          создан экземпляр RuntimeException с сообщением
            throw new RuntimeException("ошибка");
//            исключение перехватывается подходящим обработчиком
        } catch (NullPointerException e) {
            System.out.println("1 "+e);
        } catch (RuntimeException e) {
//            исключение обработано
            System.out.println("2 "+e);
        } catch (Exception e) {
                System.out.println("3 "+e);
        }
        //следующий код выполняется
        System.out.println("4");
    }
    public static void example4() {
        try {
            System.out.println("0");
//          создан экземпляр RuntimeException с сообщением
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
//            исключение перехвачено
        } catch (Exception e) {
//            исключение обработано
            System.out.println("2");
        } catch (Error e) {
            System.out.println("3");
        }
        System.out.println("4");
    }
    public static void example5() {
        try {
            System.out.println("0");
//          ошибка не будет обработана пользовательским кодом
            throw new RuntimeException("ошибка");
//            исключение не перехвачено
        } catch (NullPointerException e) {
            System.out.println("1");
        }
//            этот код не выполнится
        System.out.println("2");
    }
    public static void example6() {
        try {
            System.out.println("0");
//          создан экземпляр NullPointerException с сообщением
            throw new NullPointerException("ошибка");
//            код не будет скомпилирован, если раскоментировать код ниже
        } catch (ArithmeticException e) {
            System.out.println("1");
        } catch (Exception e) {
            System.out.println("2");
        }
        /*catch (RuntimeException e) {
            System.out.println("3");
        }*/
        System.out.println("4");
    }
    public static void example7() {
        try {
            System.out.println("0");
//          создан экземпляр NullPointerException с сообщением
            throw new NullPointerException("ошибка");
//            исключение перехвачено
        } catch (NullPointerException e) {
//            исключение обработано
            System.out.println("1");
//            созданное исключение будет обработано исполняющей системой java
            throw new ArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println("2");
        }
//            код не выполнится
        System.out.println("3");
    }
    public static int example8() {
        try {
            System.out.println("0");
//          создан экземпляр RuntimeException
            throw new RuntimeException();
//            код выполнится
        } finally {
            System.out.println("123");
        }
    }
    public static int example9() {
        try {
            System.out.println("0");
            return 55;
//            код в блоке finally выполнится раньше вызова return
        } finally {
            System.out.println("1");
        }
    }
    public static int example10() {
        try {
            System.out.println("0");
            return 15;
//            return код в блоке finally выполнится раньше
        } finally {
            System.out.println("1");
            return 20;
        }
    }
    public static void example11() {
        try {
            System.out.println("0");
//          создан экземпляр NullPointerException с сообщением
            throw new NullPointerException("ошибка");
//          ошибка перехвачена
        } catch (NullPointerException e) {
//          ошибка обработана
            System.out.println("1");
        } finally {
//          код будет выполнен
            System.out.println("2");
        }
//          этот код будет выполнен
        System.out.println("3");
    }
    public static void example12(String str, double x) {
//          создание экземпляров исключений, которые будут перехвачены исполняющей системой java. Этот тип исключений не обязательно указывать в сигнатуре метода.
        if (str==null) {
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (x>0.001) {
            throw new IllegalArgumentException("Неверное число");
        }
    }
    public static void example13(String[] args) {
        try {
            int L = args.length, h;
            System.out.println("Размер массива = "+L);
//          при делении на ноль возникает исключение
            h = 10/L;
//          получение несуществующего индекса приводит к исключению
            args[L+L] = "10";
//          исключение перехвачено
        } catch (ArithmeticException e) {
//          исключение обработано
            System.out.println("Деление на ноль");
//          исключение обработано
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс не существует");
        }
    }
    public static void example14(String[] args) {
        int L =args.length;
        System.out.println("Размер массива = "+L);
//          при делении на ноль возникает исключение, которое будет обработано исполняющей системой java
        m(L);
    }
    public static void m(int x) {
        int h=10/x;
    }
}