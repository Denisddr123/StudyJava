package newLaba12;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.Random;

public class Example5 {
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
            int y = size/x, max=0, z;
            ArrayList<FindMaxCallable> arrayList = new ArrayList<>();
            ArrayList<Future<Integer>> futures;

            for (int i = 0; i < x; i++) {
                arrayList.add(new FindMaxCallable(integers, i*y, (i+1)*y));
            }

            beginT = System.nanoTime();
            futures = (ArrayList<Future<Integer>>) forkJoinPool.invokeAll(arrayList);
            endT = System.nanoTime();
            try {
                for (Future<Integer> o : futures) {
                    z = o.get();
                    if (z>max) max = z;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("max = " + max);
            System.out.println("Time : " + (endT - beginT));
        } catch (SecurityException e) {
            System.out.println("e = " + e);
        }
    }
}
