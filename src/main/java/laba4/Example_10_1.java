package laba4;

public class Example_10_1 {
    public static void main(String[] args) {
        int a =11, b=23;
        String str;

        for (int i=0; i<a; i++){
            System.out.print("|");
            for (int j=0; j<b; j++) {
                str = " ";
                if (i==0 || i==a-1) str = "_";
                System.out.print(str);
            }
            System.out.print("|");
            System.out.println("");

        }
    }
}
