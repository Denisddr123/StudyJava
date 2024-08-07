package newLaba12;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.Random;

public class Example5 {
    public static void main(String[] args) {
        Random random = new Random(10000);
        int size = 10000;
        Integer[] integers = new Integer[size];
        for (int i = 0; i < size; i++) {
            integers[i] = random.nextInt();
        }
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            int x = forkJoinPool.getParallelism();
            int y = size/x;
            ArrayList<FindMaxInt> arrayList = new ArrayList<>();

            for (int i = 0; i < x; i++) {
                arrayList.add(new FindMaxInt(integers, i*y, (i+1)*y));
            }
            forkJoinPool.invokeAll(arrayList);
        }
    }
}

public class FindMaxInt extends RecursiveTask<Integer> {
    final int seqThresHold = 1000;
    Integer[] data;
    int start, end;

    FindMaxInt(Integer[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    protected Integer compute() {
        Integer x, max = 0;
        int i1;

        if ((end - start) < seqThresHold) {
            for (int i = start; i < end; i++) {
                i1 = data[i] > max ? max = data[i] : 0;
            }
        } else {
            int middle = (start + end) / 2;
            FindMaxInt findMaxInt1 = new FindMaxInt(data, start, middle);
            FindMaxInt findMaxIn21 = new FindMaxInt(data, middle, end);
            x = findMaxInt1.invoke();
            max = findMaxIn21.invoke();

            i1 = max < x ? max = x : 0;
        }
        return max;
    }
}
