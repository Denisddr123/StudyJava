package laba7;

public class Example_10_3 {
    public static void main(String[] args) {
        A a = new A(10);
        B b = new B(11, 'S');
        C c = new C(12, 'F', "test");

        System.out.println("A = " + a);
        System.out.println("B = " + b);
        System.out.println("C = " + c);
    }
}

class A {
    private int x;

    A(int x) {
        this.x = x;
    }

    void setX(int x) {this.x = x;}

    String getValue() {
        return "числовой параметр = "+this.x;
    }

    public String toString() {
        return "Class name: "+ this.getClass().getSimpleName()+", "+ this.getValue();
    }
}

class B extends A {
    private char aChar;
    B(int x, char aChar) {
        super(x);
        this.aChar = aChar;
    }

    void setX(int x, char aChar) {
        super.setX(x);
        this.aChar = aChar;
    }

    public String getValue() {
        String str = super.getValue();
        return str +", символьное поле = "+ this.aChar;
    }
}

class C extends B {
    public String str;

    C(int x, char aChar, String str) {
      super(x, aChar);
      this.str = str;
    }

    void setX(int x, char aChar, String str) {
        super.setX(x, aChar);
        this.str = str;
    }

    public String getValue() {
        String str = super.getValue();
        return str + ", строковое поле = " + this.str;
    }
}