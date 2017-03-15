package day9;

/**
 * Created by sshek8 on 8/23/2016.
 */
public class CountDownLatchDemo2 {

    public static void main(String[] args) throws InterruptedException {
        final CustomCountDownLatch customCountDownLatch = new CustomCountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 sleeping ");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                customCountDownLatch.countDown();
                customCountDownLatch.countDown();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 sleeping ");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                customCountDownLatch.countDown();
            }
        });


        t1.start();
        t2.start();
        customCountDownLatch.await();
//        customCountDownLatch.await();
//        customCountDownLatch.await();
        System.out.println("Completed");
    }
}
