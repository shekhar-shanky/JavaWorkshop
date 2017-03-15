package day7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by sshek8 on 8/18/2016.
 */
public class CyclicBarrierDemo2 {
    public static void main(String[] args) {
        Runnable barrier1Action = new Runnable() {
            public void run() {
                System.out.println("BarrierAction 1 executed ");
            }
        };
        Runnable barrier2Action = new Runnable() {
            public void run() {
                System.out.println("BarrierAction 2 executed ");
            }
        };

        CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
        CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

        CyclicBarrierRunnable barrierRunnable1 =
                new CyclicBarrierRunnable(barrier1, barrier2);

        CyclicBarrierRunnable barrierRunnable2 =
                new CyclicBarrierRunnable(barrier1, barrier2);

        new Thread(barrierRunnable1).start();
        new Thread(barrierRunnable2).start();
    }
}

class CyclicBarrierRunnable implements Runnable {

    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;

    public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " waiting at barrier 1");
            int await1 = this.barrier1.await();
            System.out.println(threadName + " await1: " + await1);

            Thread.sleep(1000);
            System.out.println(threadName + " waiting at barrier 2");
            int await2 = this.barrier2.await();
            System.out.println(threadName + " await2: " + await2);
            System.out.println(threadName + " done!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
