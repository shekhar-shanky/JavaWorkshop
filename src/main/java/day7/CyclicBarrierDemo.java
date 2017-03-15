package day7;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sshek8 on 8/18/2016.
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                int count = 1;
                System.out.println(String.format("Cyclic Barrier finished %d ", count++));
            }
        });
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("Submitting Tasks!");
        for (int i = 0; i < 5; i++) {
            executorService.execute(new CyclicBarrierWorker(cyclicBarrier));
        }
        System.out.println("Tasks Submitted");
        executorService.shutdown();
    }
}

class CyclicBarrierWorker implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierWorker(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();

            // STEP 1 : START
            System.out.println(String.format("%s : Doing Step 1 Work on %s", getFormattedDate(), threadName));
            Thread.sleep(getRandomWaitTime());
            System.out.println(String.format("%s : Doing Step 1 MORE Work on %s", getFormattedDate(), threadName));
            Thread.sleep(getRandomWaitTime());
            System.out.println(String.format("%s : Finished Step 1 Work on %s", getFormattedDate(), threadName));
            // STEP 1 : END

            int await = cyclicBarrier.await();
            System.out.println(String.format("%s : Cyclic Barrier count on %s is %d", getFormattedDate(), threadName, await));
            if (await == 0) {
                cyclicBarrier.reset();
            }

            // STEP 2 : START
            System.out.println(String.format("%s : Doing Step 2 Batch of Work on %s", getFormattedDate(), threadName));
            Thread.sleep(getRandomWaitTime());
            System.out.println(String.format("%s : Doing Step 2 MORE Batch of Work on %s", getFormattedDate(), threadName));
            Thread.sleep(getRandomWaitTime());
            System.out.println(String.format("%s : Finished Step 2 Batch of Work on %s", getFormattedDate(), threadName));
            // STEP 2 : END

            System.out.println(String.format("%s : Cyclic Barrier count end of Step 2 Batch of work on %s is %d", getFormattedDate(), threadName, await));


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    private String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(new Date());
    }

    private int getRandomWaitTime() {
        return new Random().nextInt(10000);
    }
}

