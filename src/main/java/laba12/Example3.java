package laba12;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Example3 {
    public static void main(String[] args) {
        try {
            File folder = new File("storage");
            if (!folder.exists()) {
                if (folder.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            InputStream inputStream = Files.newInputStream(Paths.get("storage/MyFile.txt"));
            Reader reader = new InputStreamReader(inputStream);
            readAllByByte(reader);
            System.out.println("\n\n\n");
            inputStream.close();
            reader.close();
            inputStream = new URL("http://google.com").openStream();
            reader = new InputStreamReader(inputStream);
            readAllByByte(reader);
            System.out.println("\n\n\n");
            inputStream.close();
            reader.close();
            inputStream = new ByteArrayInputStream(new byte[]{7, 9, 3, 7, 4});
            reader = new InputStreamReader(inputStream);
            readAllByByte(reader);
            System.out.println("\n\n\n");
            inputStream.close();
            reader.close();

        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
    public static void readAllByByte(Reader reader) throws IOException {
        while (true) {
            int oneByte = reader.read();
            if (oneByte != -1) {
                System.out.println((char) oneByte);
            } else {
                System.out.println("\n"+"конец");
                break;
            }
        }
    }
}
