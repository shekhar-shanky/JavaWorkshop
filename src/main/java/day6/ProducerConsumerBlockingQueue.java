package day6;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by sshek8 on 8/17/2016.
 */
public class ProducerConsumerBlockingQueue {

    public static void main(String[] args) {
        final Processor3 processor3 = new Processor3();
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                processor3.producer();
            }
        });
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor3.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }

}

class Processor3 {
    private final BlockingQueue<Integer> taskQueue = new ArrayBlockingQueue(10);

    public void producer() {
        while (true) {
            try {
                taskQueue.put(new Random().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void consumer() throws InterruptedException {
        while (true) {
            Integer integer = taskQueue.poll();
            System.out.println("CONSUMER: " + integer + "\t\t" + taskQueue.toString());
            Thread.sleep(100);
        }
    }
}

