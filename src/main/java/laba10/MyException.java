package laba10;

public class MyException extends Exception {
    public MyException(String s) {
        super(s);
    }

    public String toString() {
        return getMessage();
    }
}
