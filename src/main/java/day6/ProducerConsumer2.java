package day6;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by sshek8 on 8/17/2016.
 */
public class ProducerConsumer2 {

    public static void main(String[] args) throws InterruptedException {
        final Processor1 processor = new Processor1();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }

}

class Processor1 {
    private final LinkedList<Integer> taskQueue = new LinkedList<>();
    private final Object lock = new Object();

    public void producer() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (taskQueue.size() == 10) {
                    lock.wait();
                }
                taskQueue.add(new Random().nextInt(10));
                lock.notify();
            }
        }
    }


    public void consumer() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (taskQueue.isEmpty()) {
                    lock.wait();
                }
                Integer integer = taskQueue.removeFirst();
                lock.notify();
                System.out.println("CONSUMER: " + integer + "\t\t" + taskQueue.toString());
                //Thread.sleep(100);
            }
        }
    }
}
