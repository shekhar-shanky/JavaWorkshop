package day8;

import java.util.Arrays;

/**
 * Created by sshek8 on 8/21/2016.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 45, 67, 78, 88, 2, 5, 999};
        System.out.println(Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right;
        if (arr.length % 2 == 0) {
            right = new int[mid];
        } else {
            right = new int[mid + 1];
        }

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        int x = 0;
        for (int i = mid; i < arr.length; i++) {
            if (x < right.length) {
                right[x] = arr[i];
                x++;
            }
        }

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    public static int[] merge(int[] a, int[] b) {

        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                answer[k++] = a[i++];
            } else {
                answer[k++] = b[j++];
            }
        }
        while (i < a.length) {
            answer[k++] = a[i++];
        }

        while (j < b.length) {
            answer[k++] = b[j++];
        }
        return answer;
    }
}
