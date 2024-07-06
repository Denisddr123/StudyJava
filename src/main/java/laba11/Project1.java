package laba11;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Project1 {
    public static void main(String[] args) {
        OutputStreamWriter outputStreamWriter;
        DataOutputStream dataOutputStream;
        BufferedWriter bufferedWriter;
        InputStream inputStream;
        OutputStream outputStream;
        String str;
        ArrayList<Double> arrayList;
        int i =0;

        try {
            File folder = new File("storage");
            if (!folder.exists()) {
                if (folder.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            File file1 = new File("storage/Project1.txt");
            if (file1.delete()) {
                System.out.println("Project1.txt remove");
            }
            if (file1.createNewFile()) {
                System.out.println("Project1.txt полный путь: "+ file1.getAbsolutePath());
            }
            File file2 = new File("storage/Project1Out.txt");
            if (file2.delete()) {
                System.out.println("Project1Out.txt remove");
            }
            if (file2.createNewFile()) {
                System.out.println("Project1Out.txt полный путь: "+ file2.getAbsolutePath());
            }
            System.out.println("Заполнение первого файла данными.");
            dataOutputStream = new DataOutputStream(Files.newOutputStream(file1.toPath()));
            dataOutputStream.writeUTF("Before You Start");
            dataOutputStream.writeUTF("Thanks for your interest in submitting a bug. The purpose of this page is to collect data"
                    +"that will be used to evaluate and to fix the problems in the Java Virtual Machine (JVM). This page is designed"
                    +"for reporting bugs associated only with the JVM. If you are experiencing problems not related to the JVM, please file a bug"
                    +"at http://bugreport.java.com/bugreport/ .");

            dataOutputStream.writeDouble(5.5);
            dataOutputStream.writeDouble(-6.4);
            dataOutputStream.writeDouble(7.3);
            dataOutputStream.writeDouble(-8.2);
            dataOutputStream.writeDouble(9.1);
            dataOutputStream.writeDouble(345.331);

            dataOutputStream.flush();
            dataOutputStream.close();

            Path path = Paths.get("storage/Project1.txt");

            inputStream = Files.newInputStream(path);
            outputStream = Files.newOutputStream(file2.toPath());
            outputStreamWriter = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println("Чтение и перенос записей из первого файла во второй согласно условию задания.");

            int z = 0;
            while (true) {
                i++;
                try {
                    str = dataInputStream.readUTF();
                    System.out.println(str);
                    if (i==2) {
                        System.out.println("Запись второй строки первого файла во второй.");
                        writeInFile(bufferedWriter, Collections.singletonList(str));
                    }
                    z = z+str.getBytes().length;
                } catch (IOException e) {
                    dataInputStream.close();
                    arrayList = takeDoubleUseDataInput(file1, z, i-1);
                    arrayList = takeDoubleUseByteBuffer(file1, z, i-1);
                    arrayList = takeDoubleUseCustomCode(file1, z, i-1);
                    System.out.println("Выбор чётных чисел.");
                    checkPositiveValue(arrayList);
                    System.out.println("Запись чётных чисел в файл номер 2.");
                    writeInFile(bufferedWriter, arrayList);
                    bufferedWriter.close();
                    return;
                } catch (Exception e) {
                    throw new RuntimeException("Ошибка");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    public static ArrayList<Double> takeDoubleUseDataInput(File file, int bytes, int i) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(Files.newInputStream(file.toPath()));
        ArrayList<Double> arrayList = new ArrayList<>();
        int y = bytes+i*2;
        double d;
        System.out.println("Пропускаем уже прочитанные байты = "+dataInputStream.skip(y));
        while (true) {
            try {
                d = dataInputStream.readDouble();
                arrayList.add(d);
                System.out.println("Получение числа типа Double чтением потока с помощью метода readDouble() класса DataInputStream = "+d);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return arrayList;
            }
        }
    }

    public static ArrayList<Double> takeDoubleUseByteBuffer(File file, int bytes, int i) throws IOException {
        InputStream inputStream = Files.newInputStream(file.toPath());
        ArrayList<Double> arrayList = new ArrayList<>();
        int y = bytes+i*2;
        byte[] b = new byte[8];
        double d;
        System.out.println("Пропускаем уже прочитанные байты = "+inputStream.skip(y));
        while (true) {
            int count = inputStream.read(b);
            if (count != -1) {
                d = ByteBuffer.wrap(b).getDouble();
                arrayList.add(d);
                System.out.println("Получение числа типа  Double из массива byte[] с помощью обработки byte[] в классе ByteBuffer = "+d);
            } else {
                inputStream.close();
                break;
            }
        }
        return arrayList;

    }

    public static ArrayList<Double> takeDoubleUseCustomCode(File file, int bytes, int i) throws IOException {
        InputStream inputStream = Files.newInputStream(file.toPath());
        ArrayList<Double> arrayList = new ArrayList<>();
        int y = bytes+i*2;
        byte[] b = new byte[8];
        double d;
        System.out.println("Пропускаем уже прочитанные байты = "+inputStream.skip(y));
        while (true) {
            int count = inputStream.read(b);
            if (count != -1) {
                long accum = 0;
                i = 7;
                for ( int shiftBy = 0; shiftBy < 64; shiftBy += 8 ) {
                    accum |= ( (long)( b[i] & 0xff ) ) << shiftBy;
                    i--;
                }
                d = Double.longBitsToDouble(accum);
                arrayList.add(d);
                System.out.println("Получение числа типа Double из массива byte[] с помощью обработки byte[] в цикле = "+d);
            } else {
                inputStream.close();
                break;
            }
        }
        return arrayList;

    }
    public static void checkPositiveValue(ArrayList<Double> arrayList) {
        arrayList.removeIf(aDouble -> aDouble < 0);
    }
    public static <T> void writeInFile(BufferedWriter bufferedWriter, List<T> list) throws IOException {
        Iterator<T> iterator = list.iterator();
        String str;
        while (iterator.hasNext()) {
            str=iterator.next().toString();
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
}
