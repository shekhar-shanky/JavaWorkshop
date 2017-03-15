package day5;

/**
 * Created by sshek8 on 8/16/2016.
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        final ThreadPool threadPool = new ThreadPool(5);
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " printing " + threadPool.taskQueueDepth());
            }
        };
        while (true) {
            threadPool.enqueue(runnable);
//            Thread.sleep(1);
        }
    }
}
