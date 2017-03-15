package MyPractice;

import com.google.common.base.Stopwatch;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by sshek8 on 9/9/2016.
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ThreadPool tp1 = new ThreadPool(2);
        Stopwatch started = Stopwatch.createStarted();
        started.start();
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        tp1.enqueue(new Task());
        started.stop();
        System.out.println(started.elapsed(TimeUnit.MILLISECONDS));
        tp1.shutDown();
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            int nextInt = new Random().nextInt(1000);
            System.out.println(threadName + " : Sleep starts for \t" + nextInt + " ms");
            Thread.sleep(nextInt);
            System.out.println(threadName + " : Sleep ends after \t" + nextInt + " ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class ThreadPool {

    private final WorkerThread[] workerThreads;
    private final BlockingQueue<Runnable> taskQueue;
    private boolean shutDown;

    public ThreadPool(int threadCount) {
        this.shutDown = false;
        this.taskQueue = new ArrayBlockingQueue<>(20);
        this.workerThreads = new WorkerThread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            workerThreads[i] = new WorkerThread(taskQueue, this);
            workerThreads[i].setName("Thread-" + i);
            workerThreads[i].start();
        }
    }

    public void enqueue(Runnable task) {
        taskQueue.add(task);
    }

    public void shutDown() {
        shutDown = true;
    }

    public boolean isShutDown() {
        return shutDown;
    }
}

class WorkerThread extends Thread {

    private BlockingQueue<Runnable> taskQueue;
    private ThreadPool threadPool;

    public WorkerThread(BlockingQueue<Runnable> taskQueue, ThreadPool threadPool) {
        this.taskQueue = taskQueue;
        this.threadPool = threadPool;
    }

    public void run() {
        try {
            while (true) {
                Runnable runnable = taskQueue.take();
                runnable.run();
                if (threadPool.isShutDown() && taskQueue.isEmpty()) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted. ");
        }
    }
}
