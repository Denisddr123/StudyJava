package newLaba12;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Example6 {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 10000, sum = 0;
        long beginT = 0, endT = 0;
        Integer[] integers = new Integer[size];

        for (int i = 0; i < size; i++) {
            integers[i] = random.nextInt(20000);
        }
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            int x = forkJoinPool.getParallelism();
            SumInt sumInt = new SumInt(integers, x, 0, 12);
            beginT = System.nanoTime();
            sum = forkJoinPool.invoke(sumInt);
            endT = System.nanoTime();
        } catch (SecurityException e) {
            System.out.println("e = " + e);
        }

        System.out.println("sum = " + sum);
        System.out.println("Time : " + (endT - beginT));
    }
}
