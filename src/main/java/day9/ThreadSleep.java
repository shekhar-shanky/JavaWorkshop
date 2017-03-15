package day9;

/**
 * Created by sshek8 on 8/22/2016.
 */
public class ThreadSleep {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        long start = System.currentTimeMillis();
                        Thread.sleep(2000);
                        long end = System.currentTimeMillis();
                        long elapsed = end - start;
                        System.out.printf("Time Elapsed (Using currentTimeMillis): %10s ms \n", elapsed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        long start = System.nanoTime();
                        Thread.sleep(2000);
                        long end = System.nanoTime();
                        long elapsed = end - start;
                        System.out.printf("Time Elapsed (Using nanoTime()): %17s ms \n", +elapsed / 1_000_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        t1.start();
        t2.start();
    }

}
