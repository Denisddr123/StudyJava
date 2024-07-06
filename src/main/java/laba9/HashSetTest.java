package laba9;

import java.util.*;

public class HashSetTest {

    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<>(15000001);
        HashSet<Integer> hashSet2 = new HashSet<>(15000001);

        System.out.println("Вывод времени в наносекундах");

        System.out.println("Добавление 12 миллионов элементов типа String в HashSet = "+ addHashSetString(hashSet));
        System.out.println("Время проверки существования элемента типа String в HashSet = "+getValueString(6000000, hashSet));
        System.out.println("Время добавления 1000 элементов типа String в HashSet = "+addValueString(hashSet));
        System.out.println("Удаление 1000 элементов типа String в hashSet  = "+ hashSetRemove(hashSet));
        hashSet.clear();

        System.out.println("Добавление 12 миллионов элементов типа Integer в HashSet = "+ addHashSetInteger(hashSet2));
        System.out.println("Время проверки существования элемента типа Integer в HashSet = "+getValueInteger(7000000, hashSet2));
        System.out.println("Время добавления 1000 элементов типа Integer в HashSet = "+addValueInteger(hashSet2));
        System.out.println("Удаление 1000 элементов типа Integer в hashSet  = "+ hashSetRemoveInteger(hashSet2, 4000000));
        hashSet2.clear();
    }
    public static long addHashSetString(Collection<String> collection) {
        long start = System.nanoTime();
        for (int i=0; i < 12000000; i++) {
            collection.add(""+i);
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long addHashSetInteger(Collection<Integer> collection) {
        long start = System.nanoTime();
        for (int i=0; i < 12000000; i++) {
            collection.add(i);
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long hashSetRemoveInteger(HashSet<Integer> hashSet, int x) {
        long start = System.nanoTime();
        for (int i=x; i < x+1000; i++) {
            hashSet.remove(i);
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long hashSetRemove(HashSet<String> hashSet) {
        long start = System.nanoTime();
        for (int i=0; i < 1000; i++) {
            hashSet.remove(""+i);
        }
        long end = System.nanoTime();
        return end-start;
    }
    public static long getValueInteger(int i, HashSet<Integer> hashSet) {
        long a = System.nanoTime(), b;
        if (hashSet.contains(i)) {
            b = System.nanoTime() - a;
        } else b = 0;
        return b;
    }
    public static long getValueString(int i, HashSet<String> hashSet) {
        long a = System.nanoTime(), b;
        if (hashSet.contains(""+i)) {
            b = System.nanoTime() - a;
        } else b = 0;
        return b;
    }
    public static long addValueString(HashSet<String> hashSet) {
        int i=hashSet.size(), b=hashSet.size()+1000;
        long start = System.nanoTime();
        while (i<b) {
            hashSet.add(""+i);
            i++;
        }
        return System.nanoTime()-start;
    }
    public static long addValueInteger(HashSet<Integer> hashSet) {
        int i=hashSet.size(), b=hashSet.size()+1000;
        long start = System.nanoTime();
        while (i<b) {
            hashSet.add(i);
            i++;
        }
        return System.nanoTime()-start;
    }
}