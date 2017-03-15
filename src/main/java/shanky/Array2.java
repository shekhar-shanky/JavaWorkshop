package shanky;

/**
 * Created by sshek8 on 2/22/2017.
 * <p>
 * How to find duplicate number on Integer array in Java?
 * ------------------------------------------------------
 */
public class Array2 {


    public static void main(String[] args) {
        findDuplicateNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8});
    }

    public static void findDuplicateNumber(int[] input) {
        int n = input.length - 1;
        int sumTotal = n * (n + 1) / 2;
        int sum = 0;
        for (int i : input) {
            sum += i;
        }
        System.out.println("Duplicate Number is " + (sum - sumTotal));
    }
}
