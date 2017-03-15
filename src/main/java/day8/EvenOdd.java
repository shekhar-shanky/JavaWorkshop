package day8;

import java.io.FileNotFoundException;

/**
 * Created by sshek8 on 8/19/2016.
 */
public class EvenOdd {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        final int MAX = 100;
        Thread odd = new Thread(new Odd(lock, MAX));
        Thread even = new Thread(new Even(lock, MAX));
        odd.start();
        even.start();
        odd.join();
        even.join();

    }

}

class Odd implements Runnable {

    private Object lock;
    private int max;

    public Odd(Object lock, int max) {
        this.lock = lock;
        this.max = max;
    }

    @Override
    public void run() {
        int num = 1;
        try {
            synchronized (lock) {
                while (num <= max) {
                    if (num % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " : " + num + " : ODD");
                        lock.notify();
                        lock.wait();
                    } else {
                        lock.wait();
                    }
                    num += 2;
                }
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Even implements Runnable {

    private Object lock;
    private int max;

    public Even(Object lock, int max) {
        this.lock = lock;
        this.max = max;
    }

    @Override
    public void run() {
        int num = 2;
        try {
            synchronized (lock) {
                while (num <= max) {
                    if (num % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " : " + num + " : EVEN ");
                        lock.notify();
                        lock.wait();
                    } else {
                        lock.wait();
                    }
                    num += 2;
                }
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class A {
    public void sum(int a) throws Exception {

    }
}

class B extends A {
    public void sum(int a) throws FileNotFoundException {

    }
}