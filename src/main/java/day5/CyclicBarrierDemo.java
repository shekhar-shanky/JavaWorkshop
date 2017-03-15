package day5;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by sshek8 on 8/16/2016.
 */
public class CyclicBarrierDemo {
    private final static int taskCount = 5;

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(taskCount);
        System.out.println("Spawing Threads Started : ");
        for (int i = 0; i < taskCount; i++) {
            new Thread(new WorkerCB(cyclicBarrier, "Thread-" + i)).start();
        }

        cyclicBarrier.await();

        System.out.println("All theads finished . . .");
    }
}

class WorkerCB implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private String threadName;

    public WorkerCB(CyclicBarrier cyclicBarrier, String threadName) {
        this.cyclicBarrier = cyclicBarrier;
        this.threadName = threadName;
    }

    public void run() {
        System.out.println("Stating . . . " + threadName);
        try {
            Thread.sleep(new Random().nextInt(30));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task Done . . . " + threadName);
        System.out.println("Calling countDown() . . . " + threadName);
//        cyclicBarrier.();

    }
}
