package day3;

/**
 * Created by sshek8 on 8/11/2016.
 */
public class OverloadingTest {

    public static void main(String[] args) {
        add(1, 2);
        add(new Integer(1), new Integer(2));
        add(Integer.valueOf(1), Integer.valueOf(2));
        add(Integer.valueOf(1).intValue(), Integer.valueOf(2).intValue());
        add((int) 1.0, (int) 2.0);
    }

    public static void add(int a, int b) {
        System.out.println("OverloadingTest.add (int) " + (a + b));
    }

    public static void add(Integer a, Integer b) {
        System.out.println("OverloadingTest.add (Integer) " + (a + b));
    }

    public static void add(long a, long b) {
        System.out.println("OverloadingTest.add (Long) " + (a + b));
    }
}
