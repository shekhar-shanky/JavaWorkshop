package day6;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by sshek8 on 8/17/2016.
 */
public class ThreadCommunicationUsingJoin {

    static ProducerThread t1 = new ProducerThread();
    static ConsumerThread t2 = new ConsumerThread();
    static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();
    }

    static class ProducerThread extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1500);
                    queue.add(new Random().nextInt(100));
                    System.out.println("ProducerThread : >> : " + Thread.currentThread() + " : Adding : " + queue);
//                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ConsumerThread extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                    Integer poll = queue.removeFirst();
                    System.out.println("ConsumerThread : << : " + Thread.currentThread() + " : Receiving : " + poll + " : " + queue);
//                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

