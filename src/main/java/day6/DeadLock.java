package day6;

/**
 * Created by sshek8 on 8/17/2016.
 */
public class DeadLock {

    private final Object pen = new Object();
    private final Object paper = new Object();

    public static void main(String[] args) throws InterruptedException {
        final DeadLock deadLock = new DeadLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLock.getPenAndPaper();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLock.getPaperAndPen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();

        t2.start();

    }

    public void getPenAndPaper() throws InterruptedException {
        synchronized (pen) {
            System.out.println("DeadLock.getPenAndPaper: Locked on PEN ");
            System.out.println("DeadLock.getPenAndPaper: Attempting Lock on PAPER ");
            synchronized (paper) {
                System.out.println("DeadLock.getPenAndPaper: Locked on PAPER");
                paper.wait();
                System.out.println("DeadLock.getPenAndPaper: PAPER wait over");
            }
        }
    }


    public void getPaperAndPen() throws InterruptedException {
        synchronized (paper) {
            System.out.println("DeadLock.getPaperAndPen: Locked on PAPER");
            System.out.println("DeadLock.getPaperAndPen: Attempting Lock on PEN ");
            synchronized (pen) {
                System.out.println("DeadLock.getPaperAndPen: Locked on PEN");
                pen.wait();
                System.out.println("DeadLock.getPaperAndPen: PEN wait over");
            }
        }
    }
}
