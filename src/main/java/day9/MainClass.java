package day9;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sshek8 on 8/24/2016.
 */
public class MainClass {


    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger(1);


        int counter = 0;

        Thread1 t1 = new Thread1(atomic, counter);
        t1.start();

        Thread2 t2 = new Thread2(atomic, counter);
        t2.start();

        Thread3 t3 = new Thread3(atomic, counter);
        t3.start();
    }


}

