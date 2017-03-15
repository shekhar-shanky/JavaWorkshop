package day5;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sshek8 on 8/16/2016.
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        A target = new A();
        Thread t1 = new Thread(target);
        t1.start();
        Thread t2 = new Thread(target);
        t2.start();

    }

}

class A implements Runnable {
    private AtomicInteger count = new AtomicInteger();

    public void run() {
        while (true)
            try {
                Thread.sleep(1000);
                count.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " : " + count.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
