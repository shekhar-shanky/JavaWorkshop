package day9;

/**
 * Created by sshek8 on 8/23/2016.
 */
public class CustomCountDownLatch {

    private int count;

    public CustomCountDownLatch(int count) {
        this.count = count;
    }

    public synchronized void countDown() {
        count--;
        if (count == 0) {
            notify();
        }
    }

    public synchronized void await() throws InterruptedException {
        if (count > 0) { // use While for Spurious check
            wait();
        }
    }

}
