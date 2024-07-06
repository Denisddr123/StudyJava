package laba7;

public class Example_10_1 {
    public static void main(String[] args) {
        SuperClassTest superClassTest = new SuperClassTest("передал в конструктор суперкласса");
        System.out.println(superClassTest);

        SubClassTest subClassTest = new SubClassTest("передал в конструктор подкласса");
        System.out.println(subClassTest);

        SubClassTest subClassTest2 = new SubClassTest("передал в конструктор подкласса", "где два параметра");
        System.out.println(subClassTest2);
    }
}

class SuperClassTest {
    private String str1="";

    SuperClassTest(String str1) {
        this.str1 = str1;
    }

    SuperClassTest() {}

    public String toString() {
        return "super \n Class name: "+ this.getClass().getSimpleName()+"\n str1= "+ this.getStr1();
    }

    String getStr1() {
        return str1;
    }
}

class SubClassTest extends SuperClassTest {
    private String str2=" пусто";

    SubClassTest(String str1) {
        super(str1);
    }

    SubClassTest(String str1, String str2) {
        super(str1);
        this.str2 = str2;
    }

    public String toString() {
        return "super \n Class name: "+ this.getClass().getSimpleName()+"\n str1= "+ this.getStr1()+" str2= " +this.getStr2();
    }

    String getStr2() {
        return this.str2;
    }
}
