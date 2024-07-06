package laba11;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Example2 {
    public static void main(String[] args) {
        try {
            File folder = new File("storage");
            if (!folder.exists()) {
                if (folder.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            File file = new File("storage/MyFile.txt");
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Создан!!!");
                }
                try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file.toPath())) {
                    bufferedWriter.write("Before You Start\n" +
                            "Thanks for your interest in submitting a bug. The purpose of this" +
                            "page is to collect data that will be used to evaluate and to fix the" +
                            "problems in the Java Virtual Machine (JVM). This page is designed for reporting" +
                            "bugs associated only with the JVM. If you are experiencing problems not related" +
                            "to the JVM, please file a bug at http://bugreport.java.com/bugreport/ .\n" +
                            "What best describes your use of Java ?\n" +
                            "Before submitting a bug, we would like to know if you are a developer or an end user" +
                            "of an application/applet written using Java technology. Please provide us with the" +
                            "necessary information to better understand the problem.");
                }

            }
            InputStream inputStream = Files.newInputStream(Paths.get("storage/MyFile.txt"));
            readAllByByte(inputStream);
            System.out.println("\n\n\n");
            inputStream.close();
            inputStream = new URL("http://google.com").openStream();
            readAllByByte(inputStream);
            System.out.println("\n\n\n");
            inputStream.close();
            inputStream = new ByteArrayInputStream(new byte[] {7,9,3,7,4});
            readAllByByte(inputStream);
            System.out.println("\n\n\n");
            inputStream.close();

        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
    public static void readAllByByte(InputStream inputStream) throws IOException {
        while (true) {
            int oneByte = inputStream.read();
            if (oneByte != -1) {
                System.out.println((char) oneByte);
            } else {
                System.out.println("\n"+"end");
                break;
            }
        }
    }
}



















