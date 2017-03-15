package day7;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sshek8 on 8/18/2016.
 */
public class CountdownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        System.out.println("Submitting Tasks");
        for (int i = 0; i < 5; i++) {
            executor.execute(new CountdownWorker(countDownLatch));
        }
        executor.shutdown();
        countDownLatch.await();
        System.out.println("All tasks Done !");

    }

}

class CountdownWorker implements Runnable {

    private CountDownLatch countDownLatch;

    public CountdownWorker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " sleeping! ");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + " resumed! ");
        countDownLatch.countDown();
    }
}