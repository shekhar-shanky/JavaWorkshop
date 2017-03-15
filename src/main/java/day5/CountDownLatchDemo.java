package day5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by sshek8 on 8/16/2016.
 */
public class CountDownLatchDemo {

    private final static int taskCount = 5;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(taskCount);
        System.out.println("Spawing Threads Started : ");
        for (int i = 0; i < taskCount; i++) {
            new Thread(new Worker(countDownLatch, "Thread-" + i)).start();
        }
        System.out.println("Spawing Threads Completed: ");

        countDownLatch.await();

        System.out.println("All theads finished . . .");
    }
}

class Worker implements Runnable {
    private CountDownLatch countDownLatch;
    private String threadName;

    public Worker(CountDownLatch countDownLatch, String threadName) {
        this.countDownLatch = countDownLatch;
        this.threadName = threadName;
    }

    public void run() {
        System.out.println("Stating . . . " + threadName);
        try {
            Thread.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task Done . . . " + threadName);
        System.out.println("Calling countDown() . . . " + threadName);
        countDownLatch.countDown();

    }
}
