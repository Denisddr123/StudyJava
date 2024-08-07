package newLaba12;

import java.time.LocalTime;

public class Example1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Напишите программу, которая запускает два потока и выводит на экран их\n" +
                "имена и текущее время в течение 10 секунд.");
        Thread t1 = new Thread(() -> {
            for (int i = 0; i<10; i++) {
                System.out.println(Thread.currentThread().getName() + ": "
                + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i<10; i++) {
                System.out.println(Thread.currentThread().getName() + ": "
                        + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
