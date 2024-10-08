package timus;

import java.util.Scanner;

public class ShortPath {
    public static void main(String[] args) {
        int size = 6, begin_index = 0, temp, minindex, min, countV, countL,
        vFirst, vSecond, distance;
        String[] first, second;
        String[] numberVandL;

        Scanner scanner = new Scanner(System.in);
        first = scanner.nextLine().split(" ");
        countV = Integer.parseInt(first[0]);
        countL = Integer.parseInt(first[1]);
        // минимальное расстояние
        int[] d = new int[countV];
        // посещенные вершины
        int[] v = new int[countV];
        int[][] a = new int[countV][countV];

        for (int i = 0; i<countL; i++) {
            //a[i][i] = 0;
            second = scanner.nextLine().split(" ");
            vFirst = Integer.parseInt(second[0])-1;
            vSecond = Integer.parseInt(second[1])-1;
            distance = Integer.parseInt(second[2]);
            a[vFirst][vSecond] = distance;
            a[vSecond][vFirst] = distance;

            /*for (int j= i+1; j<size; j++) {
                System.out.println("Введите расстояние от: " +(i+1)+" до: "+(j+1));
                temp = scanner.nextInt();
                a[i][j] = temp;
                a[j][i] = temp;
            }*/
        }

        for (int i=0; i<countV; i++) {
            for (int j=0; j<countV; j++) System.out.print(a[i][j]+" ");
            System.out.println();
        }

        //Инициализация вершин и расстояний
        for (int i = 0; i<countV; i++) {
            d[i] = 10000;
            v[i] = 1;
        }
        d[begin_index] = 0;
        //Шаг алгоритма
        do {
            minindex = 10000;
            min = 10000;
            for (int i = 0; i<countV; i++) {
                //Если вершину ещё не обошли и вес ьеньше min
                if (v[i] == 1 && (d[i]<min)) {
                    min = d[i];
                    minindex = i;
                }
            }
            // Добавляем найденный минимальный вес
            // к текущему весу вершины
            // и сравниваем с текущим минимальным весом вершины
            if (minindex != 10000) {
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
        } while (minindex < 10000);
        // Вывод кратчайших расстояний до вершин
        System.out.println("Кратчайшие расстояния до вершин: ");
        for (int i=0; i<countV; i++) System.out.print(d[i]+" ");

        // Восстановление пути
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
            System.out.print(ver[i] + " ");

    }
}
