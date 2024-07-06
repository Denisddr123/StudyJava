package laba11;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            File file1 = new File("storage/numIsh.txt");
            if (file1.createNewFile()) {
                System.out.println("file1.getAbsolutePath() = " + file1.getAbsolutePath());
            }
            dataOutputStream = new DataOutputStream(Files.newOutputStream(Paths.get(file1.getAbsolutePath())));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Сколько вещественных чисел записать в файл?");
            int count = scanner.nextInt();
            System.out.println("Введите числа:");
            for (int i = 0; i < count; i++)
                dataOutputStream.writeFloat(scanner.nextFloat());
            dataOutputStream.flush();
            dataOutputStream.close();
            File file2 = new File("storage/numRez.txt");
            if (file2.createNewFile()) {
                System.out.println("file2.getAbsolutePath() = " + file1.getAbsolutePath());
            }
            dataInputStream = new DataInputStream(Files.newInputStream(Paths.get(file1.getAbsolutePath())));
            dataOutputStream = new DataOutputStream(Files.newOutputStream(Paths.get(file2.getAbsolutePath())));
            try {
                while (true) {
                    float number = dataInputStream.readFloat();
                    dataOutputStream.writeFloat(number);
                    System.out.println("Число " + (float) number);
                }
            } catch (EOFException ignored) {}
            dataOutputStream.flush();
            dataOutputStream.close();
            dataInputStream.close();

        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException ignore) {
                    /*NOP*/
                }
            }
        }
    }
}



















