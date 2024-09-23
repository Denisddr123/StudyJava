package timus.task_1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Excursion {
    static StringBuilder str;
    static int countV = 0;
    static ArrayList<String> result;
    static BufferedReader reader;
    static final int maxValue = 3000000;

    public static void main(String[] args) throws IOException {
        int countL, vFirst, vSecond, distance, zz, zz0, xx, yy, token;
        result = new ArrayList<>();
        int begin_index, z, k;

        reader = new BufferedReader(new InputStreamReader(System.in));
        //reader = new BufferedReader(new FileReader("src/main/java/timus/111"));
        StreamTokenizer in = new StreamTokenizer(reader);

        int[][] a = new int[100][100], a2 = new int[100][100];

        in.nextToken();
        token = (int) in.nval;

        while (token !=-1) {
            countV = token;
            in.nextToken();
            token = (int) in.nval;
            countL = token;

            for (int i = 0; i<countV; i++) {
                for (int j=0; j<countV; j++) {
                    a[i][j] = a2[i][j] = maxValue;
                }
            }

            for (int i = 0; i<countL; i++) {
                in.nextToken();
                vFirst = (int) (in.nval-1);
                in.nextToken();
                vSecond = (int) (in.nval-1);
                in.nextToken();
                distance = (int) (in.nval);
                if (distance < a[vFirst][vSecond]) {
                    a[vFirst][vSecond] = a[vSecond][vFirst] = distance;
                }
            }
            zz = maxValue;
            xx = yy = 0;

            for (begin_index = 0; begin_index < countV; begin_index++) {
                a2[begin_index][begin_index] = 0;
                for (z = 0; z < begin_index; z++) {
                    for (k = 0; k < begin_index; k++) {
                        if (z != k) {
                            zz0 = a2[z][k] + a[begin_index][z] + a[begin_index][k];
                            if (zz0 < zz) {
                                zz = zz0;
                                xx = begin_index;
                                yy = z;
                            }
                        }
                    }
                }
                for (z = 0; z<begin_index; z++) {
                    a2[begin_index][z] = maxValue;
                    for (k=0; k<begin_index; k++) {
                        if (a2[begin_index][z] > a2[z][k] + a[k][begin_index]) {
                            a2[begin_index][z] = a2[z][k] + a[k][begin_index];
                        }
                        a2[z][begin_index] = a2[begin_index][z];
                    }
                }
                for (z=0; z<begin_index; z++) {
                    for (k=0; k<begin_index; k++) {
                        if (a2[z][k] > a2[z][begin_index] + a2[begin_index][k]) {
                            a2[z][k] = a2[z][begin_index] + a2[begin_index][k];
                        }
                    }
                }

            }
            a[xx][yy] = a[yy][xx] = maxValue;
            for (k=0; k<100; k++) {
                a2[k] = Arrays.copyOf(a[k], 100);
            }

            for (begin_index=0; begin_index<countV; begin_index++) {
                a2[begin_index][begin_index] = 0;
            }
            for (begin_index=0; begin_index<countV; begin_index++) {
                for (z=0; z<countV; z++) {
                    for (k=0; k<countV; k++) {
                        if (a2[z][k] > a2[z][begin_index] + a2[begin_index][k]) {
                            a2[z][k] = a2[z][begin_index] + a2[begin_index][k];
                        }
                    }
                }
            }
            str = new StringBuilder();
            if (zz == maxValue) {
                str.append("No solution.");
            } else {
                    while (xx != yy) {
                        str.append(yy+1).append(" ");
                        for (begin_index =0; begin_index<countV; begin_index++) {
                            if (a2[yy][xx] == a2[begin_index][xx] + a[yy][begin_index]) {
                                yy=begin_index;
                                break;
                            }
                        }
                    }
                str.append(xx+1);
                }
            result.add(str.toString());
            in.nextToken();
            token = (int) in.nval;
        }
        reader.close();

        for (String string : result) {
            System.out.println(string);
        }
    }
}

