package laba11;

import java.io.*;

public class Example6 {
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
