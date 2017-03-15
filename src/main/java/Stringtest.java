import java.util.HashSet;
import java.util.Set;

/**
 * Created by sshek8 on 2/17/2017.
 */
public class Stringtest {

    public static void main(String[] args) {
        String s = new String("ABC");
        System.out.println(Thread.holdsLock(s));


        Set set = new HashSet();
        set.add("ABC");
        set.add(1);

        System.out.println(set.toString());

        for (; ; ) {
            System.out.print("");
        }
    }
}
