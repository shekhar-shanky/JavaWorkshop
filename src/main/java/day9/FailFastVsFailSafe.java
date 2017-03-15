package day9;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created by sshek8 on 8/22/2016.
 */
public class FailFastVsFailSafe {

    public static void main(String[] args) throws InterruptedException {


        System.out.println(A.i);
        System.out.println(A.j);


    }

    private static void failFast() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        final Map<String, String> map2 = new HashMap<>();
        map2.put("I", "ONE");
        map2.put("II", "TWO");
        map2.put("III", "THREE");
        map2.put("IV", "FOUR");
        map2.put("V", "FIVE");
        map2.put("VI", "SIX");
        map2.put("VII", "SEVEN");
        map2.put("VIII", "EIGHT");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<Map.Entry<String, String>> iterator = map2.entrySet().iterator();
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " -> 1. Size " + map2.size());
                while (iterator.hasNext()) {
                    Map.Entry<String, String> next = iterator.next();
                    //iterator.remove();
                    System.out.println(threadName + " -> " + next.getKey() + " : " + next.getValue());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " :> 1. Size " + map2.size());
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    System.out.println(threadName + " :> " + entry.getKey() + " : " + entry.getValue());
                    map2.remove(entry.getKey());
                }
                countDownLatch.countDown();
            }
        });

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();

        countDownLatch.await();
        System.out.println("-------------------");
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            map2.remove(entry.getKey());
        }
    }

    private static void failSafe() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        final Map<String, String> map1 = new ConcurrentHashMap<>();
        map1.put("01", "One");
        map1.put("02", "Two");
        map1.put("03", "Three");
        map1.put("04", "Four");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<Map.Entry<String, String>> iterator1 = map1.entrySet().iterator();

                while (iterator1.hasNext()) {
                    Map.Entry<String, String> next = iterator1.next();
                    System.out.println(Thread.currentThread().getName() + " : " + next.getKey() + " : " + next.getValue());
                    map1.put("05", "Five");
                    if (next.getKey().equals("03")) {
                        iterator1.remove();
                        map1.put("07", "Seven");
                    }
                }

                countDownLatch.countDown();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<Map.Entry<String, String>> iterator1 = map1.entrySet().iterator();

                while (iterator1.hasNext()) {
                    Map.Entry<String, String> next = iterator1.next();
                    System.out.println(Thread.currentThread().getName() + " : " + next.getKey() + " : " + next.getValue());
                    iterator1.remove();
                }

                countDownLatch.countDown();
            }
        });


        t1.start();
        t2.start();

        countDownLatch.await();

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

// private - default - protected - public

class A {
    final static int i = 9;
    final static int j = 8;

    static {
        System.out.println("abc");
        //i = 12;
    }

    int b = 19;

    {
        System.out.println(b);
        b = 15;
    }

    @Override
    public int hashCode() {
        return 9;
    }

    void abc() {

    }


}

class B extends A {


}
