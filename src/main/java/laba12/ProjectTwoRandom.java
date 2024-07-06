package laba12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectTwoRandom {
    public static ArrayList<String> arrayList = new ArrayList<>(3);
    public static long[] longs = new long[2];
    public static String fileIn = "storage/projectTwoRandomIn.txt";
    public static String fileOut = "storage/projectTwoRandomOut.txt";
    public static RandomAccessFile randomAccessFileOut;
    public static RandomAccessFile randomAccessFileIn;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;
        long y;
        String s;
        try {
            File file = new File("storage");
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            file = new File(fileIn);
            if (file.delete()) {
                System.out.println("storage/projectTwoRandomIn.txt remove");
            }
            if (file.createNewFile()) {
                System.out.println("projectTwoRandomIn.txt Создан!!!");
            }
            File file2 = new File(fileOut);
            if (file2.delete()) {
                System.out.println("storage/projectTwoRandomOut.txt remove");
            }
            if (file2.createNewFile()) {
                System.out.println("projectTwoRandomOut.txt Создан!!!");
            }
            System.out.println("Введите количество фильмов:");
            count = scanner.nextInt();
            scanner.nextLine();
            randomAccessFileOut = new RandomAccessFile(file, "rw");

            for (int i=0; i<count; i++) {
                System.out.println("Введите название фильма:");
                s = scanner.nextLine();
                randomAccessFileOut.writeUTF(s);
                System.out.println("Введите год выхода:");
                y = scanner.nextLong();
                randomAccessFileOut.writeLong(y);
                scanner.nextLine();
                System.out.println("Введите страну:");
                s = scanner.nextLine();
                randomAccessFileOut.writeUTF(s);
                System.out.println("Введите жанр:");
                s = scanner.nextLine();
                randomAccessFileOut.writeUTF(s);
                System.out.println("Введите кассовы сборы:");
                y = scanner.nextInt();
                randomAccessFileOut.writeLong(y);
                scanner.nextLine();
            }
            /*randomAccessFileOut.writeUTF("Тренер");
            randomAccessFileOut.writeLong(2018);
            randomAccessFileOut.writeUTF("Россия");
            randomAccessFileOut.writeUTF("Драма");
            randomAccessFileOut.writeLong(15764064);

            randomAccessFileOut.writeUTF("Между ангелом и бесом");
            randomAccessFileOut.writeLong(1995);
            randomAccessFileOut.writeUTF("Франция");
            randomAccessFileOut.writeUTF("Комедия");
            randomAccessFileOut.writeLong(1123100130);

            randomAccessFileOut.writeUTF("Беглецы");
            randomAccessFileOut.writeLong(1986);
            randomAccessFileOut.writeUTF("Франция");
            randomAccessFileOut.writeUTF("Комедия");
            randomAccessFileOut.writeLong(23595);

            randomAccessFileOut.writeUTF("Батя");
            randomAccessFileOut.writeLong(2021);
            randomAccessFileOut.writeUTF("Россия");
            randomAccessFileOut.writeUTF("Комедия");
            randomAccessFileOut.writeLong(9267397);*/

            randomAccessFileOut.close();

            randomAccessFileIn = new RandomAccessFile(file, "r");
            randomAccessFileOut = new RandomAccessFile(file2, "rw");
            String str;
            long x=0;
            byte[] bytes = new byte[8];
            int i=0;
            System.out.println("Считаем строки из первого файла");
            while (randomAccessFileIn.length()>(randomAccessFileIn.getFilePointer())) {
                try {
                    str = randomAccessFileIn.readUTF();

                    if (str.isEmpty()) {
                        randomAccessFileIn.seek(x);
                        randomAccessFileIn.read(bytes);
                        longs[i] = ByteBuffer.wrap(bytes).getLong();
                        System.out.println(longs[i]);
                        if (i==1) {
                            writeInFileOut();
                            i=-1;
                        }
                        i++;
                    } else{
                        arrayList.add(str);
                        System.out.println(str);
                    }
                    x = randomAccessFileIn.getFilePointer();
                } catch (IOException e) {
                    randomAccessFileIn.close();
                    randomAccessFileOut.close();
                    System.out.println("Конец файла");
                    break;
                }

            }
            printFileOut();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeInFileOut() throws IOException {
        String str = arrayList.get(1);
        if (str.toLowerCase().matches("россия")) {
            randomAccessFileOut.writeUTF(arrayList.get(0));
            randomAccessFileOut.writeLong(longs[0]);
            randomAccessFileOut.writeUTF(arrayList.get(1));
            randomAccessFileOut.writeUTF(arrayList.get(2));
            randomAccessFileOut.writeLong(longs[1]);
        }
        arrayList.clear();
    }
    public static void printFileOut() throws IOException {
        String str;
        byte[] bytes = new byte[8];
        long x=0;
        int i=0;
        randomAccessFileIn = new RandomAccessFile(fileOut, "r");
        try {
            while (randomAccessFileIn.length()>(randomAccessFileIn.getFilePointer())) {
                str = randomAccessFileIn.readUTF();
                if (str.isEmpty()) {
                    randomAccessFileIn.seek(x);
                    randomAccessFileIn.read(bytes);
                    longs[i]=ByteBuffer.wrap(bytes).getLong();
                    if (i==1) {
                        System.out.println("Название: "+arrayList.get(0)+", год выхода: "+longs[0]+", страна: "
                                +arrayList.get(1)+", жанр: "+arrayList.get(2)+", кассовые сборы: "+longs[1]);
                        i=-1;
                        arrayList.clear();
                    }
                    i++;

                } else arrayList.add(str);
                x = randomAccessFileIn.getFilePointer();
            }
        } catch (IOException e) {
            System.out.println(e);
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                System.out.println(stackTraceElement);
            }
            randomAccessFileIn.close();
        }


    }
}
