package laba11;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Example3 {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            File folder = new File("storage");
            if (!folder.exists()) {
                if (folder.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            inputStream = Files.newInputStream(Paths.get("storage/MyFile.txt"));
            readAllByByte(inputStream);
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ignore) {
                    /*NOP*/
                }
            }
        }
    }
    public static void readAllByByte(InputStream inputStream) throws IOException {
        byte [] bytes = new byte[5];
        while (true) {
            int count = inputStream.read(bytes);
            if (count != -1) {
                System.out.println(""+ count+", buff = "+ Arrays.toString(bytes)+", str = "+new String(bytes, 0, count));
            } else {
                break;
            }
        }
    }
}



















