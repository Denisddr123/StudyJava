package laba11;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Example5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла => ");
        String fname = scanner.nextLine(), str;
        try {
            File folder = new File("storage");
            if (!folder.exists()) {
                if (folder.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            File file = new File("storage/"+fname);
            if (file.createNewFile()) {
                System.out.println("Файл создан, полный путь - "+ file.getAbsolutePath());
            }
            System.out.println("Введите количество строк для записи в файл");
            int n = scanner.nextInt();
            DataOutputStream dataOutputStream = new DataOutputStream(Files.newOutputStream(file.toPath()));
            scanner.nextLine();
            for (int i=0; i<n; i++) {
                System.out.print("Введите строку для записи в файл ");
                str = scanner.nextLine();
                dataOutputStream.writeUTF(str);
            }
            dataOutputStream.flush();
            dataOutputStream.close();
            DataInputStream dataInputStream = new DataInputStream(Files.newInputStream(file.toPath()));
            while (true) {
                System.out.println(dataInputStream.readUTF());
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}
