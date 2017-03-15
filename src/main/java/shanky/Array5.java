package shanky;

/**
 * Created by sshek8 on 2/26/2017.
 */
public class Array5 {

    public static void main(String[] args) {
        findPairs(new int[]{1, 2, 3, 4, 10, -5}, 5);
    }

    private static void findPairs(int[] input, int sum) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if (input[i] + input[j] == sum) {
                    System.out.println("pair :" + input[i] + " , " + input[j]);
                }
            }
        }
    }
}
