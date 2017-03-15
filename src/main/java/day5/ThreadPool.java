package day5;

import java.util.LinkedList;

/**
 * Created by sshek8 on 8/16/2016.
 */
public class ThreadPool {
    private final WorkerThread[] threads;
    private final LinkedList<Runnable> taskQueue;

    public ThreadPool(int threadCount) {
        taskQueue = new LinkedList<Runnable>();
        threads = new WorkerThread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new WorkerThread(taskQueue);
            threads[i].start();
        }
    }

    public void enqueue(Runnable runnable) {
        synchronized (taskQueue) {
            taskQueue.addLast(runnable);
            taskQueue.notify();
        }
    }

    public String taskQueueDepth() {
        return "Task Queue size : " + taskQueue.size();
    }

}

class WorkerThread extends Thread {

    private final LinkedList<Runnable> taskQueue;

    public WorkerThread(LinkedList<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void run() {
        Runnable runnable;

        while (true) {
            synchronized (taskQueue) {
                if (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                runnable = taskQueue.removeFirst();
            }

            if (runnable != null)
                runnable.run();
            //System.out.println("Task Queue size : " + taskQueue.size());

        }
    }
}
