package laba12;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Example7 {
    public static void main(String[] args) {
        RandomAccessFile randomAccessFile;
        String str;
        int count, size = 0;
        long len;
        Scanner scanner = new Scanner(System.in);
        try {
            File file = new File("storage");
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            file = new File("storage/stringRand.txt");
            if (file.createNewFile()) {
                System.out.println("stringRand.txt Создан!!!");
            }
            System.out.print("Сколько строк надо записать в файл? \n =>");
            count = scanner.nextInt();
            scanner.nextLine();
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.setLength(0);
            len = randomAccessFile.length();
            System.out.println("Открыт файл размером "+len+ " байт");
            System.out.println("Введите строки:");
            for (int i=0; i<count; i++) {
                str = scanner.nextLine();
                randomAccessFile.writeUTF(str);
                size += str.length();
            }
            len = randomAccessFile.length();
            System.out.println("Размер файла в байтах = "+len +", общее количество символов записанных строк -  "+size);
            randomAccessFile.close();

            randomAccessFile = new RandomAccessFile(file, "r");
            System.out.println("Строки из файла:");
            randomAccessFile.seek(0);
            for (int i =0; i<count; i++) {
                System.out.println("Строка " + i +" начинается с байта "
                                + randomAccessFile.getFilePointer() +" - " + randomAccessFile.readUTF()
                                +" - заканчивается байтом "+ (randomAccessFile.getFilePointer()-1));
            }
            randomAccessFile.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
