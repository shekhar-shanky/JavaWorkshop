package day6;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by sshek8 on 8/17/2016.
 */
public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> integers = new LinkedList<>();
        Thread producer = new Thread(new Producer(integers));
        Thread consumer = new Thread(new Consumer(integers));
        producer.start();
        consumer.start();
//        producer.join();
//        consumer.join();
    }
}

class Consumer implements Runnable {

    LinkedList<Integer> linkedList;

    public Consumer(LinkedList<Integer> linkedList) {
        this.linkedList = linkedList;
    }

    public void run() {
        while (true) {
            synchronized (linkedList) {
                if (linkedList.isEmpty()) {
                    try {
                        linkedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer integer = linkedList.removeFirst();
                linkedList.notify();
                System.out.println("CONSUMER : " + integer + " : Task Queue size is " + linkedList.size());
            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}


class Producer implements Runnable {

    LinkedList<Integer> linkedList;

    public Producer(LinkedList<Integer> linkedList) {
        this.linkedList = linkedList;
    }

    public void run() {
        while (true) {
            synchronized (linkedList) {
                if (linkedList.size() == 10) {
                    try {
                        linkedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer integer = new Integer(new Random().nextInt(100));
                linkedList.add(integer);
                linkedList.notify();
                System.out.println("PRODUCER : " + integer + " : Task Queue size is " + linkedList.size());
            }
        }
    }
}

