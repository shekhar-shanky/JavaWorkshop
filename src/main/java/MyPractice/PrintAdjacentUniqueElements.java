package MyPractice;

/**
 * Created by sshek8 on 9/14/2016.
 */
public class PrintAdjacentUniqueElements {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 1, 1, 3, 3, 3, 3, 4, 4, 4, 4, 5, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 9};
        for (int i = 0; i < array.length; i++) {
            if (i + 1 == array.length) {
                System.out.print(array[i]);
            } else if (array[i] != array[i + 1]) {
                System.out.print(array[i]);
            }
        }
    }

}
