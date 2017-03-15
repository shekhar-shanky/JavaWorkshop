package day8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sshek8 on 8/20/2016.
 */
public class ThreeThreadCommunication {

    public static void main(String[] args) throws InterruptedException {

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Lock lock3 = new ReentrantLock();

        Thread t1 = new Thread(new Thread1(lock1, lock2));
        Thread t2 = new Thread(new Thread2(lock2, lock3));
        Thread t3 = new Thread(new Thread3(lock3, lock1));

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");


        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}

class Thread1 implements Runnable {

    Object lock1;
    Object lock2;

    public Thread1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            synchronized (lock1) {
                synchronized (lock2) {
                    lock2.notify();
                    System.out.print(Thread.currentThread().getName() + ":" + i + "\t");
                    i += 3;
                }
                try {
                    lock1.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}

class Thread2 implements Runnable {

    Object lock2;
    Object lock3;

    public Thread2(Object lock2, Object lock3) {
        this.lock2 = lock2;
        this.lock3 = lock3;
    }

    @Override
    public void run() {
        int i = 2;
        while (true) {
            synchronized (lock2) {
                synchronized (lock3) {
                    lock3.notify();
                    System.out.print(Thread.currentThread().getName() + ":" + i + "\t");
                    i += 2;
                }
                try {
                    lock2.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}

class Thread3 implements Runnable {

    Object lock3;
    Object lock1;

    public Thread3(Object lock3, Object lock1) {
        this.lock3 = lock3;
        this.lock1 = lock1;
    }

    @Override
    public void run() {
        int i = 3;
        while (true) {
            synchronized (lock3) {
                synchronized (lock1) {
                    lock1.notify();
                    System.out.println(Thread.currentThread().getName() + ":" + i + "\t");
                    i += 1;
                }
                try {
                    lock3.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}

