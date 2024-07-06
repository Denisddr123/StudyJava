package laba11;

import java.io.File;
import java.io.IOException;

public class Example1 {
    public static void main(String[] args) {
        try {
            File folder = new File("storage");
            if (!folder.exists()) {
                if (folder.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            File file1 = new File("storage/MyFile1.txt");
            if (file1.createNewFile()) {
                System.out.println("Создан!!!");
                System.out.println("Полный путь:"+ file1.getAbsolutePath());
            }
            file1 = new File("storage/MyFile2.txt");
            if (file1.createNewFile()) {
                System.out.println("Полный путь 2:"+ file1.getAbsolutePath());
            }
            file1 = new File("Papka1/Papka2/Papka3");
            if (file1.mkdirs()) {
                System.out.println("Полный путь 3:"+ file1.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}