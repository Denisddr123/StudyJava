package laba5;
import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        TwoExChar1 example101 = new TwoExChar1();
        Scanner scanner = new Scanner(System.in);
        char aChar;
        char bChar;

        System.out.println("Введите первый символ");

        aChar = scanner.nextLine().charAt(0);

        System.out.println("Введите второй символ");

        bChar = scanner.nextLine().charAt(0);

        example101.setAChar(aChar, bChar);

        System.out.println("Вызов метода, который возращает код символа и сам символ.");
        System.out.println(example101.toStringChars());
    }
}

class TwoExChar1 {
    private char aChar;
    private char bChar;
    private char[] arrChar;

    public void setAChar(char aChar, char bChar) {

        if (aChar < bChar) {
            this.aChar = aChar;
            this.bChar = bChar;
        } else {
            this.aChar = bChar;
            this.bChar = aChar;
        }

        this.setArrChar();
    }

    private void setArrChar() {
        arrChar = new char[bChar-aChar];

        for (int i=0; i<arrChar.length; i++, aChar++) {
            arrChar[i] = aChar;
        }
    }

    public String toStringChars() {
        return new String(arrChar);
    }
}