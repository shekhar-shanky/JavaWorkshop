package shanky;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by sshek8 on 2/20/2017.
 * <p>
 * 1. How to find the missing number(s) in integer array of 1 to 100? (solution)
 * ---------------------------------------------------------------------------
 * This is one of the most simple array problems you will see, mostly asked in a telephonic round of Interview.
 * You have given an integer array which contains numbers from 1 to 100 but one number is missing,
 * you need to write a Java program to find that missing number in an array.
 * You cannot use any open source library or Java API method which solves this problem.
 * One trick to solve this problem is to calculate sum of all numbers in the array and compare with expected sum,
 * the difference would be the missing number.
 * <p>
 * Read more: http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-and-answers.html#ixzz4ZCKu9r3p
 */
public class Array1 {
    public static void main(String[] args) {
        int x = 'A';
        System.out.println(x + 1);

        // one missing number
//        printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);
        printMissingNumber_2(new int[]{1, 2, 3, 4, 6}, 6);
//        // two missing number
//        printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);
//        // three missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);
//        // four missing number
//        printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);

    }

    /* Approach One: Bit Set*/
    public static void printMissingNumber(int[] input, int totalCount) {
        int missingNumber = totalCount - input.length;
        BitSet bitSet = new BitSet(missingNumber);
        for (int number : input) {
            bitSet.set(number - 1);
        }
        System.out.printf("%nMissing number in integer array %s, with total number %d is : ", Arrays.toString(input), totalCount);
        int lastMissingIndex = 0;
        for (int i = 0; i < missingNumber; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.print(++lastMissingIndex + " ");
        }
        System.out.println("");
    }

    /* Approach One: Sum of all number i.e. (n(n+1))/2 */
    public static void printMissingNumber_2(int[] input, int totalCount) {
        int sumOfTotalCount = (totalCount * (totalCount + 1) / 2);
        int sumOfInput = 0;
        for (int number : input) {
            sumOfInput += number;
        }
        System.out.printf("%nMissing number in integer array %s, with total number %d is : ", Arrays.toString(input), totalCount);
        System.out.print((sumOfTotalCount - sumOfInput) + "\n");
    }
}
