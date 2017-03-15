package day2;

import java.util.Random;

/**
 * Created by sshek8 on 8/10/2016.
 */
public class PermGenException {

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(30000);

        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread());
        Thread thread3 = new Thread(new MyThread());
        Thread thread4 = new Thread(new MyThread());
        Thread thread5 = new Thread(new MyThread());
        Thread thread6 = new Thread(new MyThread());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

    }


}

class MyThread implements Runnable {

    public void run() {
        for (; ; ) {
            String s1 = ("new 1 " + new Random().nextLong()).intern();
            String s2 = ("new 2 " + new Random().nextInt(10000)).intern();
            String s3 = (s1 + s2).intern();
            System.out.println("MyThread.run : " + s3);
            if (4 > 5) {
                break;
            }
        }

    }
}


