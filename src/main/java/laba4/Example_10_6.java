package laba4;

import java.util.Random;

public class Example_10_6 {
    public static void main(String[] args) {
        Random random = new Random();
        int a = 5,b=7, strNum = random.nextInt(5), tblNum=random.nextInt(7), h=0, w;
        int[][] arr = new int[a][b];
        int[][] arr2 = new int[a-1][b-1];

        for (int i=0, z=10; i<a; i++) {
            for (int j=0; j<b; j++, z++) {
                arr[i][j]=z;
            }
        }

        for (int i=0; i<a; i++) {
            if (i==strNum) continue;
            w=0;
            for (int j=0; j<b; j++) {
                if (j==tblNum) continue;
                arr2[h][w]=arr[i][j];
                w++;
            }
            h++;
        }

        for (int[] x: arr) {
            for (int y: x) {
                System.out.print(y+" ");
            }
            System.out.println();
        }

        System.out.println("Массив после удаления "+(strNum+1)+" строки, "+(tblNum+1)+" столбца");

        for (int[] x: arr2) {
            for (int y: x) {
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }
}
