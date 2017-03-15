package day9;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sshek8 on 8/24/2016.
 */
public class Thread2 extends Thread {


    AtomicInteger atomic;

    int counter;

    public Thread2(AtomicInteger atomic, int counter) {
        this.atomic = atomic;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            if (atomic.get() % 3 == 2) {

                atomic.incrementAndGet();

                System.out.println("" + Thread.currentThread() + "" + counter);
                counter++;
            }
        }
    }
}
