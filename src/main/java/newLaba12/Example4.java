package newLaba12;

import java.util.ArrayList;

public class Example4 {
    public static void main(String[] args) {
        ArrayList<NewThread> arrayList = new ArrayList<>();
        String s;
        for (int i = 0; i < 10; i++) {
            s = "поток-"+i;
            arrayList.add(new NewThread(s, i));
        }

        try {
            for (NewThread newThread: arrayList) {
                newThread.t.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
    }
}

class NewThread implements Runnable {
    Thread t;
    String name;
    int number;
    NewThread(String threadName, int num) {
        name = threadName;
        number = num;
        t = new Thread(this, name);
        t.start();
    }
    public void run() {
        System.out.println("Имя потока: " + name + " номер потока: " + number);
    }
}
