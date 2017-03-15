package MyPractice;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by sshek8 on 9/8/2016.
 */
public class UseOfWaitAndNotify {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Thread t1 = new Thread(new ProducerThread(linkedList));
        Thread t2 = new Thread(new ConsumerThread(linkedList));
        t1.start();
        t2.start();
    }
}


class ProducerThread implements Runnable {

    LinkedList<String> taskQueue;

    public ProducerThread(LinkedList<String> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (taskQueue) {
                    if (taskQueue.size() == 10) {
                        taskQueue.wait();
                    }
                    taskQueue.addFirst("Shashank - " + new Random().nextInt(1000));
                    taskQueue.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class ConsumerThread implements Runnable {

    LinkedList<String> taskQueue;

    public ConsumerThread(LinkedList<String> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (taskQueue) {
                    if (taskQueue.isEmpty()) {
                        taskQueue.wait();
                    }
                    String removeFirst = taskQueue.removeFirst();
                    taskQueue.notify();
                    System.out.printf("Queue Size %d \t Task Removed : %s\n", taskQueue.size(), removeFirst);
                    Thread.sleep(1);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}