package newLaba12;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Example5_2 {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 10000;
        long beginT, endT;
        Integer[] integers = new Integer[size];
        for (int i = 0; i < size; i++) {
            integers[i] = random.nextInt();
        }
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            int x = forkJoinPool.getParallelism();
            Integer result;
            FindMaxInt findMaxInt = new FindMaxInt(integers, x, 0, size-1);
            beginT = System.nanoTime();
            result = forkJoinPool.invoke(findMaxInt);
            endT = System.nanoTime();

            System.out.println("result = " + result);
            System.out.println("Time : " + (endT - beginT));
        } catch (SecurityException e) {
            System.out.println("e = " + e);
        }
    }
}
