package laba11;

import java.io.*;

public class Example7 {
    public static void main(String[] args) {
        BufferedReader reader;
        BufferedWriter writer;
        int lineCount = 0;
        String str;
        try {
            File folder = new File("storage");
            if (!folder.exists()) {
                if (folder.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            reader = new BufferedReader(new FileReader("storage/MyFile.txt"), 1024);
            writer = new BufferedWriter(new FileWriter("storage/MyFile1.txt"), 1024);

            while ((str = reader.readLine()) !=null) {
                lineCount++;
                System.out.println(lineCount+": " + str);
                writer.write(str);
                writer.newLine();
            }
            reader.close();
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Ошибка!!!!");
        }
    }
}
