package laba12;

import java.io.*;

public class Example1 {
    public static void main(String[] args) {
        Reader reader;
        Writer writer;
        try {
            File folder = new File("storage");
            if (!folder.exists()) {
                if (folder.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            File file1 = new File("storage/MyFile.txt");
            if (file1.createNewFile()) {
                System.out.println("MyFile.txt Создан!!!");
            }
            file1 = new File("storage/MyFile2.txt");
            if (file1.createNewFile()) {
                System.out.println("MyFile2.txt Создан!!!");
            }
            reader = new FileReader("storage/MyFile.txt");
            writer = new FileWriter("storage/MyFile2.txt", true);
            int oneByte;
            while ((oneByte = reader.read()) !=-1) {
                writer.append((char) oneByte);
                System.out.println("(char) oneByte = " + (char) oneByte);
            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Ошибка!!!!");
        }
    }
}