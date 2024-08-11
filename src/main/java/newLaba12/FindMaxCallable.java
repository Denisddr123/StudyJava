package newLaba12;

import java.util.concurrent.Callable;

public class FindMaxCallable implements Callable<Integer> {
    Integer[] data;
    int start, end;
    FindMaxCallable(Integer[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }
    public Integer call() {
        Integer max = 0;
        for (int i = start; i < end; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }
}