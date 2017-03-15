package day3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sshek8 on 8/11/2016.
 */
public class ArrayTimeComplexity {

    public static void main(String[] args) throws InterruptedException {
//        byte[] arr = new byte[1000];
//        Arrays.fill(arr, (byte) 5);
        List<Byte> arr = new ArrayList<Byte>();
        for (int i = 0; i < 1000; i++) {
            arr.add(Byte.valueOf(String.valueOf(1)));
        }
        while (true) {
            long timeStart = System.nanoTime();
            byte b1 = arr.get(0);
            long timeEnd = System.nanoTime();
            System.out.println(b1 + " Time Elapsed : [0] " + (timeEnd - timeStart));

            timeStart = System.nanoTime();
            b1 = arr.get(1);
            timeEnd = System.nanoTime();
            System.out.println(b1 + " Time Elapsed : [1] " + (timeEnd - timeStart));

            timeStart = System.nanoTime();
            b1 = arr.get(2);
            timeEnd = System.nanoTime();
            System.out.println(b1 + " Time Elapsed : [2] " + (timeEnd - timeStart));

            timeStart = System.nanoTime();
            b1 = arr.get(3);
            timeEnd = System.nanoTime();
            System.out.println(b1 + " Time Elapsed : [3] " + (timeEnd - timeStart));

            timeStart = System.nanoTime();
            b1 = arr.get(4);
            timeEnd = System.nanoTime();
            System.out.println(b1 + " Time Elapsed : [4] " + (timeEnd - timeStart));


            timeStart = System.nanoTime();
            b1 = arr.get(5);
            timeEnd = System.nanoTime();
            System.out.println(b1 + " Time Elapsed : [5] " + (timeEnd - timeStart));


            timeStart = System.nanoTime();
            b1 = arr.get(6);
            timeEnd = System.nanoTime();
            System.out.println(b1 + " Time Elapsed : [6] " + (timeEnd - timeStart));


            timeStart = System.nanoTime();
            b1 = arr.get(7);
            timeEnd = System.nanoTime();
            System.out.println(b1 + " Time Elapsed : [7] " + (timeEnd - timeStart));


            timeStart = System.nanoTime();
            b1 = arr.get(8);
            timeEnd = System.nanoTime();
            System.out.println(b1 + " Time Elapsed : [8] " + (timeEnd - timeStart));

            timeStart = System.nanoTime();
            b1 = arr.get(9);
            timeEnd = System.nanoTime();
            System.out.println(b1 + " Time Elapsed : [9] " + (timeEnd - timeStart));

            timeStart = System.nanoTime();
            b1 = arr.get(999);
            timeEnd = System.nanoTime();
            System.out.println(b1 + " Time Elapsed : [999] " + (timeEnd - timeStart));


            System.out.println("--------------------------------------------");

            Thread.sleep(3000);
        }
    }
}
