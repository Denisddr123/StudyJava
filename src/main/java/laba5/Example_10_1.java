package laba5;
import java.util.Scanner;

public class Example_10_1 {

    public static void main(String[] args) {
        ExChar example101 = new ExChar();
        Scanner scanner = new Scanner(System.in);
        char aChar;

        System.out.println("Введите символ");

        aChar = scanner.nextLine().charAt(0);

        example101.setAChar(aChar);

        System.out.println("Вызов метода, который возращает код символа.");
        System.out.println(example101.getaChar());

        System.out.println("Вызов метода, который возращает код символа и сам символ.");
        System.out.println(example101.toStringChar());

    }
}

class ExChar {
    private char aChar;

    public void setAChar(char aChar) {
        this.aChar = aChar;
    }

    public int getaChar() {
        return aChar;
    }

    public String toStringChar() {
        return getaChar()+" "+aChar;
    }
}
