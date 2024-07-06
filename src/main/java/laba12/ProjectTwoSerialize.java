package laba12;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class ProjectTwoSerialize {
    public static String fileIn = "storage/projectTwoSerializeIn.txt";
    public static String fileOut = "storage/projectTwoSerializeOut.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ObjectOutputStream outputStream;
        ObjectInputStream objectInputStream;
        Film film, film1;
        String title;
        String country;
        String genre;
        long year;
        long cast;
        int count;
        try {
            File file = new File("storage");
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("storage создана!!!");
                }
            }
            file = new File(fileIn);
            if (file.delete()) {
                System.out.println(fileIn+" remove");
            }
            if (file.createNewFile()) {
                System.out.println(fileIn+" Создан!!!");
            }
            File file2 = new File(fileOut);
            if (file2.delete()) {
                System.out.println(fileOut+" remove");
            }
            if (file2.createNewFile()) {
                System.out.println(fileOut+" Создан!!!");
            }
            System.out.println("Введите количество фильмов:");
            outputStream = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            count = scanner.nextInt();
            scanner.nextLine();

            /*film = new Film("Тренер", "Россия", "Драма", 2018, 15764064);
            outputStream.writeObject(film);
            film = new Film("Между ангелом и бесом", "Франция", "Комедия", 1995, 1123100130);
            outputStream.writeObject(film);
            film = new Film("Беглецы", "Франция", "Комедия", 1986, 23595);
            outputStream.writeObject(film);
            film = new Film("Батя", "Россия", "Комедия", 2021, 9267397);
            outputStream.writeObject(film);*/
            for (int i =0; i<count; i++) {
                System.out.println("Введите название фильма:");
                title = scanner.nextLine();
                System.out.println("Введите год выхода:");
                year = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Введите страну:");
                country = scanner.nextLine();
                System.out.println("Введите жанр:");
                genre = scanner.nextLine();
                System.out.println("Введите кассовы сборы:");
                cast = scanner.nextInt();
                scanner.nextLine();
                film = new Film(title, country, genre, year, cast);
                outputStream.writeObject(film);
            }
            outputStream.flush();
            outputStream.close();
            objectInputStream = new ObjectInputStream(Files.newInputStream(file.toPath()));
            outputStream = new ObjectOutputStream(Files.newOutputStream(file2.toPath()));
            System.out.println("Чтение первого файла и запись во второй");
            String s;
            while (true) {
                try {
                    film = (Film) objectInputStream.readObject();
                    s = film.country.toLowerCase();
                    if (s.matches("россия")) {
                        film1 = new Film(film.title, film.country, film.genre, film.year, film.cast);
                        outputStream.writeObject(film1);
                    }
                    System.out.println("Название: "+film.title+", год выхода: "+film.year+", страна: "
                            +film.country+", жанр: "+film.genre+", кассовые сборы: "+film.cast);
                } catch (IOException e) {
                    System.out.println("Конец файла");
                    objectInputStream.close();
                    outputStream.flush();
                    outputStream.close();
                    break;
                }
            }
            objectInputStream = new ObjectInputStream(Files.newInputStream(file2.toPath()));
            System.out.println("Чтение вторго файла");
            while (true) {
                try {
                    film = (Film) objectInputStream.readObject();
                    System.out.println("Название: "+film.title+", год выхода: "+film.year+", страна: "
                            +film.country+", жанр: "+film.genre+", кассовые сборы: "+film.cast);
                } catch (IOException e) {
                    System.out.println("Конец файла");
                    objectInputStream.close();
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Film implements Serializable {
    String title;
    String country;
    String genre;
    long year;
    long cast;
    public Film(String title, String country, String genre,  long year, long cast) {
        this.title = title;
        this.country = country;
        this.genre = genre;
        this.year = year;
        this.cast = cast;
    }
}
