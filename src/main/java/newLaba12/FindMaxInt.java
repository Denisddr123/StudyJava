package newLaba12;

import java.util.concurrent.RecursiveTask;

public class FindMaxInt extends RecursiveTask<Integer> {
    final int seqThresHold = 10001;
    int parallel;
    Integer[] data;
    int start, end;

    FindMaxInt(Integer[] vals, int parallels, int s, int e) {
        data = vals;
        parallel = parallels;
        start = s;
        end = e;
    }

    protected Integer compute() {
        Integer x, max = 0;
        int i1;
        if (parallel == 1) {
            if ((end - start) < seqThresHold) {
                for (int i = start; i < end; i++) {
                    i1 = data[i] > max ? max = data[i] : 0;
                }
            } else {
                int middle = (start + end) / 2;
                FindMaxInt findMaxInt1 = new FindMaxInt(data, parallel, start, middle);
                FindMaxInt findMaxInt2 = new FindMaxInt(data, parallel, middle, end);
                findMaxInt1.fork();
                findMaxInt2.fork();
                x = findMaxInt1.join();
                max = findMaxInt2.join();

                i1 = max < x ? max = x : 0;
            }
        } else {
            int middle = (start + end) / 2;
            int p = parallel/2;
            FindMaxInt findMaxInt1 = new FindMaxInt(data, p, start, middle);
            FindMaxInt findMaxInt2 = new FindMaxInt(data, p, middle, end);
            findMaxInt1.fork();
            findMaxInt2.fork();
            x = findMaxInt1.join();
            max = findMaxInt2.join();
            i1 = max < x ? max = x : 0;
        }


        return max;
    }
}
