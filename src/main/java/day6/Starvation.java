package day6;

import java.util.Random;

/**
 * Created by sshek8 on 8/17/2016.
 */
public class Starvation {

    public static void main(String[] args) {

        Runnable target = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getPriority());
            }
        };

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(target);
            t.setPriority(new Random().nextInt(10) + 1);
            t.setName("Thread-" + i);
            t.start();
        }


    }
}
