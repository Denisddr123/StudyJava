package laba11;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Example10 {
    public static void main(String[] args) {
        BufferedReader reader;
        PrintWriter writer;
        int lineCount = 0;
        String str;
        try {
            File folder = new File("storage");
            if (!folder.exists()) {
                if (folder.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get("storage/MyFile.txt")),"cp1251"));
            writer = new PrintWriter("storage/MyFile1.txt","cp1251");

            while ((str = reader.readLine()) !=null) {
                lineCount++;
                System.out.println(lineCount+": " + str);
                writer.println(lineCount+":: "+str);
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
