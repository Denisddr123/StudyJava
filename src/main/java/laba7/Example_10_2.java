package laba7;

public class Example_10_2 {
    public static void main(String[] args) {
        SuperClass superClass = new SuperClass("SuperClass");
        test(superClass);
        SubClass subClass = new SubClass(9, "SubClass");
        test(subClass);
        subClass.setStr1(10);
        System.out.println("метод с целочисленным параметром = " + subClass);
        subClass.setStr1("test"+superClass.getClass().getSimpleName(), 11);
        System.out.println("метод с целочисленным параметром и строкой = " + subClass);
    }

    static void test(SuperClass superClass) {
        System.out.println("Значения полей инициализированные в конструкторе = " + superClass);
        superClass.setStr1();
        System.out.println("метод без параметров = " + superClass);
        superClass.setStr1("test"+superClass.getClass().getSimpleName());
        System.out.println("С текстовым параметром = " + superClass);
    }
}

class SuperClass {
    private String str1;

    SuperClass(String str1) {
        this.str1 = str1;
    }

    void setStr1() {
        this.str1 = "default";
    }

    void setStr1(String str1) {
        this.str1 = str1;
    }

    int getStr1() {
        return str1.length();
    }

    public String toString() {
        return "Class name: "+ this.getClass().getSimpleName()+", длина строки= "+ this.getStr1();
    }
}

class SubClass extends SuperClass {
    public int x;

    SubClass(int x, String str1) {
        super(str1);
        this.x = x;
    }

    void setStr1() {
        super.setStr1();
        this.x = 0;
    }

    void setStr1(String str1) {
        super.setStr1(str1);
        this.x=1;
    }

    void setStr1(int x) {
        super.setStr1();
        this.x=x;
    }

    void setStr1(String str1, int x) {
        super.setStr1(str1);
        this.x = x;
    }

    public String toString() {
        return "Class name: "+ this.getClass().getSimpleName()+", длина строки= "+ this.getStr1()+", переменная х= " +this.x;
    }

}
