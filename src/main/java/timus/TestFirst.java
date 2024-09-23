package timus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TestFirst {
    public static void main(String[] args) {
        int begin_index = 4, shortPathToZ, temp, minindex, min, countV, countL,
                vFirst, vSecond, distance, fromItoZ;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        String[] first, second;
        String[] numberVandL;
        String[] test = {"1 2 7", "1 3 9", "1 6 14", "2 3 10", "2 4 15", "3 4 11", "3 6 2", "4 5 6", "5 6 9"};
        String[] test2 = {"1 7 7", "1 6 13", "1 5 1", "1 4 10", "2 7 8", "2 3 5", "2 5 3",
                "3 7 6", "3 2 5", "3 6 10", "4 1 10", "4 5 1", "4 8 9", "5 4 1", "5 1 1",
                "5 2 3", "5 6 1", "6 3 10", "6 1 13", "6 5 1", "6 8 4",
                "7 1 7", "7 2 8", "7 3 6", "8 4 9", "8 5 7", "8 6 4",
        };
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
            //a[i][i] = 0;
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

                            break;
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
                a[begin_index][z] = fromItoZ;
                shortPathToZ = shortPathToZ+a[begin_index][z];
                System.out.println("vertex: "+(z+1) +" path: "+shortPathToZ);
                for (int i : v) {
                    System.out.print(i+" ");
                }
                System.out.println();
            }
        }
        //Шаг алгоритма

        // Вывод кратчайших расстояний до вершин
        System.out.println("Кратчайшие расстояния до вершин: ");
        for (int i=0; i<countV; i++) System.out.print(d[i]+" ");

       /* // Восстановление пути
        // массив посещенных вершин
        int[] ver = new int[countV];
        // индекс конечной вершины = 5 - 1
        int end = 4;
        // начальный элемент - конечная вершина
        ver[0] = end+1;
        // индекс предыдущей вершины
        int k = 1;
        // вес конечной вершины
        int weight = d[end];

        // пока не дошли до начальной вершины
        while (end != begin_index) {
            // просматриваем все вершины
            for (int i = 0; i<countV; i++) {
                // если связь есть
                if (a[i][end] != 0) {
                    // определяем вес пути из предыдущей вершины
                    temp = weight - a[i][end];
                    // если вес совпал с рассчитанным
                    if (temp == d[i]) {
                        // значит из этой вершины и был переход
                        weight = temp;
                        // сохраняем предыдущую вершину
                        end = i;
                        // и записываем ее в массив
                        ver[k] = i + 1;
                        k++;
                    }
                }
            }
        }
        // Вывод пути (начальная вершина оказалась в конце массива из k элементов)
        System.out.println("Вывод кратчайшего пути");
        for (int i = k - 1; i >= 0; i--)
            System.out.print(ver[i] + " ");*/

    }
}
