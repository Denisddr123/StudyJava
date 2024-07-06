package laba11;

import java.io.*;
import java.nio.file.Files;

public class x {
    public static void main(String[] args) {
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;

        try {
            File file1 = new File("storage/Project1.txt");
            if (file1.delete()) {
                System.out.println("file remove");
            }
            if (file1.createNewFile()) {
                System.out.println("Полный путь:"+ file1.getAbsolutePath());
            }
            File file2 = new File("storage/Project1Out.txt");
            if (file2.createNewFile()) {
                System.out.println("Полный путь:"+ file2.getAbsolutePath());
            }

            outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(file1.toPath()));
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("Thanks for your interest in submitting a bug\n");
            bufferedWriter.write("Before You Start\n");
            bufferedWriter.write("5.5");
            bufferedWriter.newLine();
            bufferedWriter.write("-5.56");
            bufferedWriter.newLine();
            bufferedWriter.write("98.09");
            bufferedWriter.newLine();
            bufferedWriter.write("-54.3");
            bufferedWriter.newLine();
            bufferedWriter.write("1.1");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
