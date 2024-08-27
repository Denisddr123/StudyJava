package timus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test2 {
    static int begin_index = 0;
    static int countV = 0;
    //private static int[] d;

    public static void main(String[] args) {
        int shortPathToZ, temp, minindex, min, countL,
                vFirst, vSecond, distance, fromItoZ;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        String[] first, second;
        String[] test = {"1 2 7", "1 3 9", "1 6 14", "2 3 10", "2 4 15", "3 4 11", "3 6 2", "4 5 6", "5 6 9"};
        String[] test2 = {"1 7 7", "1 6 13", "1 5 1", "1 4 10", "2 7 8", "2 3 5", "2 5 3",
                "3 7 6", "3 2 5", "3 6 10", "4 1 10", "4 5 1", "4 8 9", "5 4 1", "5 1 1",
                "5 2 3", "5 6 1", "6 3 10", "6 1 13", "6 5 1", "6 8 4",
                "7 1 7", "7 2 8", "7 3 6", "8 4 9", "8 5 7", "8 6 4",
        };
        begin_index = 7;
        //8 27

        Scanner scanner = new Scanner(System.in);
        //first = scanner.nextLine().split(" ");
        //Число перекрёстков
        //countV = Integer.parseInt(first[0]);
        //countV = 6;
        countV = 8;
        //Число дорог
        //countL = Integer.parseInt(first[1]);
        //countL = 9;
        countL = 27;
        //массив для хранения минимальных расстояний
        int[] id = new int[countV];
        int[] d = new int[countV];
        // посещенные вершины
        int[] iv = new int[countV];
        int[] v;
        //Матрица перекрёстков
        int[][] a = new int[countV][countV];

        for (int i = 0; i<countL; i++) {
            //second = scanner.nextLine().split(" ");
            second = test2[i].split(" ");
            //Первый перекрёсток
            vFirst = Integer.parseInt(second[0])-1;
            //Второй перекрёсток
            vSecond = Integer.parseInt(second[1])-1;
            //Растояние между ними
            distance = Integer.parseInt(second[2]);
            a[vFirst][vSecond] = distance;
            a[vSecond][vFirst] = distance;
        }

        for (int i=0; i<countV; i++) {
            for (int j=0; j<countV; j++) System.out.print(a[i][j]+" ");
            System.out.println();
        }

        //Инициализация вершин и расстояний
        for (int i = 0; i<countV; i++) {
            id[i] = 10000;
            //id[i][1] = 10000;
            //id[i][0] = i;
            iv[i] = 1;
        }

        for (int z=0; z<countV; z++) {
            if (a[begin_index][z] != 0) {
                fromItoZ = a[begin_index][z];
                a[begin_index][z] = 0;
                d = Arrays.copyOf(id, countV);
                v = Arrays.copyOf(iv, countV);
                d[begin_index] = 0;
                shortPathToZ = 10000;

                do {
                    minindex = 10000;
                    min = shortPathToZ;
                    for (int i = 0; i<countV; i++) {
                        //Если вершину ещё не обошли и вес меньше min
                        if (v[i] == 1 && (d[i]<min)) {
                            min = d[i];
                            minindex = i;

                            //break;
                        }
                    }
                    // Добавляем найденный минимальный вес
                    // к текущему весу вершины
                    // и сравниваем с текущим минимальным весом вершины
                    if (minindex != 10000) {
                        if (minindex == z) {
                            shortPathToZ = min;
                        } else {
                            for (int i = 0; i<countV; i++) {
                                if (a[minindex][i] > 0) {
                                    temp = min + a[minindex][i];
                                    if (temp < d[i]) {
                                        d[i] = temp;
                                    }
                                }
                            }
                            v[minindex] = 0;
                        }

                    }
                } while (minindex < 10000);
                shortPathToZ = shortPathToZ+fromItoZ;
                a[begin_index][z] = fromItoZ;
                System.out.println("vertex: "+(z+1) +" path: "+shortPathToZ);
                for (int i : v) {
                    System.out.print(i+" ");
                }
                System.out.println();
                getPath(a, d, shortPathToZ, z);
            }
        }

        // Вывод кратчайших расстояний до вершин
        System.out.println("Кратчайшие расстояния до вершин: ");
        for (int i=0; i<countV; i++) System.out.print(d[i]+" ");

    }
    public static void getPath(int[][] a, int[] d, int shortPathToZ, int z) {
        int[] ver = new int[countV];
        StringBuilder str = new StringBuilder();
        str.append(z + 1);
        ver[0] = z+1;
        int k = 1, end = z, temp, x;
        x = a[begin_index][z];
        int pathToZ = shortPathToZ-x;
        while (end != begin_index) {
            for (int i =0; i<countV; i++) {
                if (a[i][end] != 0) {
                    temp = pathToZ - a[i][end];
                    if (temp == d[i]) {
                        pathToZ = temp;
                        end = i;
                        ver[k] = i+1;
                        str.append(" ").append(i + 1);
                        k++;
                    }
                }
            }
        }
        /*for (int i = k - 1; i >= 0; i--)
            System.out.print(ver[i] + " ");*/
        System.out.println(str);
    }
}
