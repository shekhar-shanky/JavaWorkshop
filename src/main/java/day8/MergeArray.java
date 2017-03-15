package day8;

import java.util.Arrays;

/**
 * Created by sshek8 on 8/21/2016.
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] a = new int[]{11, 12, 13, 14, 15};
        int[] b = new int[]{6, 7, 8, 9, 10};
        int[] merge = merge(a, b);
        System.out.println(Arrays.toString(merge));
    }

    public static int[] merge(int[] a, int[] b) {

        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            System.out.println();
            System.out.println("a[" + i + "]:" + a[i] + "  b[" + j + "]:" + b[j]);
            if (a[i] < b[j]) {
                System.out.println("i:" + i + " j:" + j + " k:" + k);
                answer[k++] = a[i++];
                System.out.println(">>>> i:" + i + " j:" + j + " k:" + k);
            } else {
                System.out.println("i:" + i + " j:" + j + " k:" + k);
                answer[k++] = b[j++];
                System.out.println(">>>> i:" + i + " j:" + j + " k:" + k);
            }
        }
        System.out.println("A: ----------------------------------------------------------");
        while (i < a.length) {
            System.out.println();
            System.out.println("a[" + i + "]:" + a[i]);
            System.out.println("i:" + i + " j:" + j + " k:" + k);
            answer[k++] = a[i++];
            System.out.println(">>>> i:" + i + " j:" + j + " k:" + k);
        }
        System.out.println(" B: ----------------------------------------------------------");

        while (j < b.length) {
            System.out.println("b[" + i + "]:" + b[j]);
            System.out.println("i:" + i + " j:" + j + " k:" + k);
            answer[k++] = b[j++];
            System.out.println(">>>> i:" + i + " j:" + j + " k:" + k);
        }
        System.out.println(" C: -----------------------------------------------------------");
        return answer;
    }
}
