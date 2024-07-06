package laba9;

import java.util.ArrayList;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(12000000);
        System.out.println("Вывод времени в наносекундах");
        System.out.println("Добавление 12 миллионов элементов в ArrayList = "+ arrayListAdd(arrayList));
        System.out.println("Добавление тысячи элементов в ArrayList в конец списка = "+ arrayListAddLast(arrayList));
        System.out.println("Добавление тысячи элементов в ArrayList в начало списка = "+ arrayListAddFirst(arrayList));
        System.out.println("Добавление тысячи элементов в ArrayList в середину списка = "+ arrayListAddMiddle(arrayList));
        System.out.println("время получения элемента из ArrayList по индексу = "+getArrayList(arrayList, 7000001));

        System.out.println("Удаление тысячи элементов в ArrayList с конца списка = "+ arrayListRemoveLast(arrayList));
        System.out.println("Удаление тысячи элементов в ArrayList с начала списка = "+ arrayListRemoveFirst(arrayList));
        System.out.println("Удаление тысячи элементов в ArrayList с середины списка = "+ arrayListRemoveMiddle(arrayList));
        System.out.println("время получения элемента из ArrayList по индексу = "+getArrayList(arrayList, 7000000));
        System.out.println("время получения элемента из ArrayList по индексу = "+getArrayList(arrayList, 7056000));
    }
    public static long arrayListAdd(ArrayList<String> arrayList) {
        long a = System.nanoTime();
        for (int x = 0; x < 12000000; x++) {
            arrayList.add( "1");
        }
        return System.nanoTime() - a;
    }
    public static long arrayListAddLast(ArrayList<String> array) {
        long start = System.nanoTime();
        for (int i=0; i < 1000; i++) {
            array.add("1");
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long arrayListAddFirst(ArrayList<String> array) {
        long start = System.nanoTime();
        for (int i=0; i < 1000; i++) {
            array.add(0, "1");
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long arrayListAddMiddle(ArrayList<String> array) {
        long start = System.nanoTime();
        for (int i=0; i < 1000; i++) {
            array.add(6000000, "1");
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long arrayListRemoveLast(ArrayList<String> array) {
        int x = array.size();
        long start = System.nanoTime();
        for (int i=0; i < 1000; i++) {
            array.remove(x-1-i);
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long arrayListRemoveFirst(ArrayList<String> array) {
        long start = System.nanoTime();
        array.subList(0, 1000).clear();
        long end = System.nanoTime();
        return end-start;
    }
    public static long arrayListRemoveMiddle(ArrayList<String> array) {
        long start = System.nanoTime();
        for (int i=0; i < 1000; i++) {
            array.remove(6000000);
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long arrayListRemove(ArrayList<String> array) {
        int x = array.size();
        long start = System.nanoTime();
        for (int i=0; i < x; i++) {
            array.remove(x-1-i);
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long getArrayList(ArrayList<String> arrayList, int x) {
        long start = System.nanoTime();
        arrayList.get(x);
        long end = System.nanoTime();
        return end-start;
    }
}
