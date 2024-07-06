package laba7;


public class Example_10_5 {
    public static void main(String[] args) {
        AExample aExample = new AExample("AExample");
        BExample bExample = new BExample("BExample", 10);
        CExample cExample = new CExample("CExample", 'A');

        System.out.println("AExample = " + aExample.getValue());
        System.out.println("BExample = " + bExample.getValue());
        System.out.println("CExample = " + cExample.getValue());

        aExample = cExample;
        System.out.println("AExample = " + aExample.getValue());
    }
}

class AExample{
    private final String str;

    AExample(String str) {
        this.str = str;
    }

    String getValue() {
        return "Class name: "+ this.getClass().getSimpleName()+", строковое поле = " + this.str;
    }
}

class BExample extends AExample{
    private final int x;

    BExample(String str, int x) {
        super(str);
        this.x = x;
    }

    @Override
    String getValue() {
        return super.getValue()+", числовой параметр = "+this.x;
    }
}

class CExample extends AExample{
    private final char aChar;
    CExample(String str, char aChar) {
        super(str);
        this.aChar = aChar;
    }

    @Override
    String getValue() {
        return super.getValue()+", символьное поле = "+ this.aChar;
    }
}
