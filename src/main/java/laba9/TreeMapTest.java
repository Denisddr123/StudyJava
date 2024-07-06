package laba9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(16777216);
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        /*arrayAddSort(array);
        System.out.println("Добавление 16777216 элементов в TreeMap, ключи которых отсортированы в порядке возрастания = "+ fromArrayToTree(treeMap, array));

        System.out.println(treeMap.size());
        treeMap.clear();
        array.clear();*/
        /*recursN(0, 8388608, array);
        arrayAdd(array);
        System.out.println("Добавление элементов в TreeMap, порядок ключей позволяет обойтись меньшим количеством операций перестроения дерева,\n"
                + "в отличии от последовательности ключей в порядке возрастания = "+fromArrayToTree(treeMap, array));
        System.out.println("Время добавления 1000 элементов в TreeMap = "+addThousandValue(treeMap));
        System.out.println("Время удаления 1000 элементов в TreeMap = "+removeThousandValue(treeMap));
        System.out.println("Время получения элемента в TreeMap по индексу = "+getValue(6000000, treeMap));*/

        System.out.println("Добавление 12000000 элементов в TreeMap, ключи которых отсортированы в порядке возрастания = "+add(treeMap));
        System.out.println("Время добавления 1000 элементов в TreeMap = "+addThousandValue(treeMap));
        System.out.println("Время удаления 1000 элементов в TreeMap = "+removeThousandValue(treeMap));
        System.out.println("Время получения элемента в TreeMap по индексу = "+getValue(6000000, treeMap));
        System.out.println("Время получения элемента в TreeMap по индексу = "+getValue(600000, treeMap));

    }
    public static void arrayAddSort(ArrayList<Integer> array) {
        for (int i=0; i<16777216; i++) {
            array.add(i);
        }
    }
    public static void arrayAdd(ArrayList<Integer> array ) {
        for (int i = 3; i < 16777216; i=i+2) {
            array.add(i);
        }
    }
    public static void recursN(int x, int y, ArrayList<Integer> array) {
        int a, b;
        a= y/2;
        b = x+y;
        if (a<1) return;
        array.add(b);
        recursN(x, a, array);
        recursN(b, a, array);

    }
    public static long fromArrayToTree(TreeMap<Integer, String> treeMap, ArrayList<Integer> array) {
        Iterator<Integer> iterator =  array.iterator();
        int x;
        long start = System.nanoTime();
        while (iterator.hasNext()) {
            x = iterator.next();
            treeMap.put(x, "1 ");
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long add(TreeMap<Integer, String> treeMap) {
        long start = System.nanoTime();
        for (int i = 0; i < 12000000; i++) {
            treeMap.put(i, "1 ");
        }
        return System.nanoTime()-start;
    }
    public static long addThousandValue(TreeMap<Integer, String> treeMap) {
        int x = treeMap.size();
        long start = System.nanoTime();
        for (int i = x; i<x+1000; i++) {
            treeMap.put(i, "1 ");
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long removeThousandValue(TreeMap<Integer, String> treeMap) {
        int x = treeMap.size()/2;
        long start = System.nanoTime();
        for (int i = x; i<x+1000; i++) {
            treeMap.remove(i);
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long getValue(int x, TreeMap<Integer, String> treeMap) {
        long start = System.nanoTime();
        treeMap.get(x);
        long end = System.nanoTime();
        return end-start;
    }
}
