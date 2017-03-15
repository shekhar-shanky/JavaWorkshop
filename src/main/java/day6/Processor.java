package day6;

/**
 * Created by sshek8 on 8/17/2016.
 */
public class Processor {

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
    }
}
