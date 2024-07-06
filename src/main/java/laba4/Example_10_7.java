package laba4;

public class Example_10_7 {
    public static void main(String[] args) {
        int a=5, b=7, z, h, x=0;
        int[][] arr = new int[a][b];

        for (int i=0; i<a; i++) {
            z=1;
            h=0;
            if (i%2==1) {
                z = -1;
                h = b-1;
            }
            for (int j=0; j<b; j++) {
                x++;
                arr[i][h+(z*j)] = x;
            }
        }

        System.out.println("Массив змейкой: ");

        for (int[] xx: arr) {
            for (int y: xx) {
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }
}
