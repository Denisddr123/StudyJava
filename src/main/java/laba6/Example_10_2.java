package laba6;

public class Example_10_2 {
    public static void main(String[] args) {
        for (int i = 0; i<5; i++) System.out.println("Статическая переменная равна "+Example2.getA());
    }
}

class Example2 {
    private static int a = 0;

    static int getA () {
        return a++;
    }
}