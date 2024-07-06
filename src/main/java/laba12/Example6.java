package laba12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        try {
            File file = new File("storage");
            Scanner scanner = new Scanner(System.in);
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            file = new File("storage/num1Mart.txt");
            if (file.createNewFile()) {
                System.out.println("num1Mart.txt Создан!!!");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            System.out.print("Сколько чисел надо записать в файл? \n => ");
            int count = scanner.nextInt();
            System.out.println("Исходный размер файла в байтах =" + randomAccessFile.length()
                    + ", указатель стоит на " + randomAccessFile.getFilePointer() + "-м байте");
            System.out.println("Введите числа:");
            for (int i = 0; i < count; i++) {
                randomAccessFile.writeInt(scanner.nextInt());
            }
            System.out.println("Исходный размер файла в байтах =" + randomAccessFile.length()
                    + ", указатель стоит на " + randomAccessFile.getFilePointer() + "-м байте");
            System.out.println("Количество байт на 1 число = " + randomAccessFile.length() / count);
            randomAccessFile.close();
            randomAccessFile = new RandomAccessFile(file, "r");
            System.out.println("\n Числа в файле:");
            for (long i = 0; i < count; i++) {
                randomAccessFile.seek(i*4);
                System.out.println("Число" + i + ": " + randomAccessFile.readInt());
            }
            randomAccessFile.seek(randomAccessFile.getFilePointer() - 4);
            System.out.println(" Количество чисел в файле= " + randomAccessFile.length()/4
                    + ", последнее число= " + randomAccessFile.readInt());
            System.out.print("\nВведите число, которое нужно найти в файле => ");
            int x = scanner.nextInt();
            int j = 0, number, y;
            for (long i = 0; i<count; i++) {
                randomAccessFile.seek(i*4);
                number = randomAccessFile.readInt();
                if (number==x) {
                    j++;
                    System.out.print("номер " + i+ ", ");
                }
            }
            System.out.println(" количество искомых чисел = " + j);
            randomAccessFile.close();
            randomAccessFile = new RandomAccessFile(file, "rw");
            for (int k=0; k<count; k++) {
                for (long i=0; i<count-k-1;i++) {
                    randomAccessFile.seek(i*4);
                    x = randomAccessFile.readInt();
                    y = randomAccessFile.readInt();
                    if (x>y) {
                        randomAccessFile.seek(i*4);
                        randomAccessFile.writeInt(y);
                        randomAccessFile.writeInt(x);
                    }
                }

            }
            System.out.println("\n Числа, отсортированные в файле:");
            for (long i=0;i<count; i++) {
                randomAccessFile.seek(i*4);
                System.out.print(" " + randomAccessFile.readInt());
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
