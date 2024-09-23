package timus.task_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class Parity {
    private static Answer[] arr;
    public static void main(String[] args) throws IOException {
        arr = new Answer[5000];
        ArrayList<Integer> result = new ArrayList<>();
        boolean collision;
        int length, quantityOfAnswer, readAnswer, storedAnswer, i, z;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/timus/1"));
        StreamTokenizer in = new StreamTokenizer(bufferedReader);
        in.nextToken();
        length = (int) in.nval;
        while (length != -1) {
            in.nextToken();
            quantityOfAnswer = (int) in.nval;
        for (int j=0; j<quantityOfAnswer; j++) {
            arr[j] = new Answer();
        }
            collision = false;
            readAnswer = storedAnswer = 0;
            if (quantityOfAnswer != 0) {
                do {
                    in.nextToken();
                    arr[storedAnswer].from = (int) in.nval;
                    in.nextToken();
                    arr[storedAnswer].to = (int) in.nval;
                    in.nextToken();
                    arr[storedAnswer].parity = in.sval.equals("odd");
                    i = storedAnswer-1;
                    while (i>=0 && arr[i].from >= arr[storedAnswer].from) i--;
                    i++;
                    while (i != storedAnswer && arr[i].from == arr[storedAnswer].from) {
                        if (arr[i].to > arr[storedAnswer].to) change(i, storedAnswer);
                        if (arr[i].to == arr[storedAnswer].to) {
                            collision = arr[i].parity != arr[storedAnswer].parity;
                            storedAnswer--; i=storedAnswer;
                        } else {
                            arr[storedAnswer].from = arr[i].to+1;
                            arr[storedAnswer].parity = arr[i].parity ^ arr[storedAnswer].parity;
                        }
                        while (i<storedAnswer && arr[i].from < arr[storedAnswer].from) i++;
                    }
                    while (i != storedAnswer) {
                        change(i, storedAnswer);
                        i++;
                    }
                    storedAnswer++; readAnswer++;
                } while (readAnswer != quantityOfAnswer && !collision);
            }
            if (collision) {
                result.add(readAnswer-1);
                z = quantityOfAnswer-readAnswer;
                while (z > 0) {
                    in.nextToken();
                    in.nextToken();
                    in.nextToken();
                    z--;
                }
            } else result.add(readAnswer);;

            in.nextToken();
            length = (int) in.nval;
        }
        result.forEach(System.out::println);
    }

    static void change(int a, int a2) {
        Answer answer = arr[a2];
        arr[a2] = arr[a];
        arr[a] = answer;
    }
}

class Answer {
    int from;
    int to;
    boolean parity;
}
