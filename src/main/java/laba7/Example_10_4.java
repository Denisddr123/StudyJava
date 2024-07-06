package laba7;

public class Example_10_4 {
    public static void main(String[] args) {
        ClassA classA = new ClassA('A');
        ClassB classB = new ClassB('B', "ClassB");
        ClassC classC = new ClassC('C', "ClassC", 20);

        System.out.println("ClassA.aChar = " + classA.aChar);
        System.out.println("ClassB.aChar = " + classB.aChar+", ClassB.str = "+ classB.str);
        System.out.println("ClassC.aChar = " + classC.aChar+", ClassC.str = "+ classC.str+", ClassC.x = "+classC.x);

        ClassA classAA = new ClassA(classA);
        ClassB classBB = new ClassB(classB);
        ClassC classCC = new ClassC(classC);

        System.out.println("ClassAA.aChar = " + classAA.aChar);
        System.out.println("ClassBB.aChar = " + classBB.aChar+", ClassBB.str = "+ classBB.str);
        System.out.println("ClassCC.aChar = " + classCC.aChar+", ClassCC.str = "+ classCC.str+", ClassCC.x = "+classCC.x);
    }
}

class ClassA{
    public char aChar;

    ClassA(char aChar) {
        this.aChar = aChar;
    }

    ClassA(ClassA classA) {
        this.aChar = classA.aChar;
    }
}

class ClassB extends ClassA{
    public String str;

    ClassB(char aChar, String str) {
        super(aChar);
        this.str = str;
    }

    ClassB(ClassB classB) {
        super(classB.aChar);
        this.str = classB.str;
    }
}

class ClassC extends ClassB{
    public int x;
    ClassC(char aChar, String str, int x) {
        super(aChar, str);
        this.x = x;
    }

    ClassC(ClassC classC) {
        super(classC.aChar, classC.str);
        this.x = classC.x;
    }
}
