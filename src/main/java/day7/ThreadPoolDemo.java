package day7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sshek8 on 8/18/2016.
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService parentThreadPool = Executors.newFixedThreadPool(10);
        ExecutorService childThreadPool = Executors.newFixedThreadPool(10);


    }

}

class Parent implements Runnable {

    @Override
    public void run() {

    }

}

class Child implements Runnable {

    @Override
    public void run() {

    }
}