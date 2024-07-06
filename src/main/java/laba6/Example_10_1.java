package laba6;

public class Example_10_1 {
    public static void main(String[] args) {

        Example example = new Example();
        System.out.println("символьное поле "+example.getA() +" текстовое поле " + example.getStr());

        example.setValue('a');
        System.out.println("символьное поле "+example.getA() +" текстовое поле " + example.getStr());

        example.setValue("text");
        System.out.println("символьное поле "+example.getA() +" текстовое поле " + example.getStr());

        char[] str = {'a','d','v','i','c','e'};
        example.setValue(str);
        System.out.println("символьное поле "+example.getA() +" текстовое поле " + example.getStr());

        char[] str2 = {'b'};
        example.setValue(str2);
        System.out.println("символьное поле "+example.getA() +" текстовое поле " + example.getStr());
    }
}

class Example {
    private char a;
    private String str;

    void setValue(char a) {
        this.a = a;
    }

    void setValue(String a) {
        this.str = a;
    }

    void setValue(char[] a) {
        if (a.length == 1) setValue(a[0]);
        else {
            setValue(new String(a));
        }
    }

    public char getA() {
        return a;
    }

    public String getStr() {
        return str;
    }
}
