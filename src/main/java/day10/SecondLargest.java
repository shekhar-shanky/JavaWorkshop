package day10;

/**
 * Created by sshek8 on 8/29/2016.
 */
public class SecondLargest {

    public static void main(String[] args) {
        int[] array = new int[]{11, 23, 45, -0, 888, 876, 871, 1, 4, 56};

        int max, secondMax, size = array.length;

        max = secondMax = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {

            if (array[i] > max) {
                secondMax = max;
                max = array[i];
            }

            /* If arr[i] is in between first and second
               then update second  */
            else if (array[i] > secondMax && array[i] != max)
                secondMax = array[i];

        }
        System.out.println("Max: " + max + "\nSecond Max: " + secondMax);
    }
}
