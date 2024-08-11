package newLaba12;

import java.util.concurrent.RecursiveTask;

public class SumInt extends RecursiveTask<Integer> {
    int parallel;
    Integer[] data;
    int start, end;

    SumInt(Integer[] vals, int parallels, int s, int e) {
        data = vals;
        parallel = parallels;
        start = s;
        end = e;
    }

    protected Integer compute() {
        int i1=0;
        if (parallel == 1) {
            for (int i = start; i < end; i++) {
                i1 += data[i];
            }
        }else {
            int middle = (start + end) / 2;
            int p = parallel/2;
            SumInt sumInt1 = new SumInt(data, p, start, middle);
            SumInt sumInt2 = new SumInt(data, p, middle, end);
            sumInt1.fork();
            sumInt2.fork();

            i1 = sumInt1.join() + sumInt2.join();
        }
        return i1;
    }
}
