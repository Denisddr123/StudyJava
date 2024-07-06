package laba4;

public class Example_10_2 {
    public static void main(String[] args) {
        int a =11;
        String str;
        System.out.println("|\\");

        for (int i=0; i<a; i++){
            System.out.print("|");
            for (int j=0; j<i+1; j++) {
                str = "  ";
                if (i==a-1) str = "__";
                System.out.print(str);
            }
            System.out.println("\\");

        }
    }
}
