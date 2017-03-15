package day10;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by sshek8 on 8/26/2016.
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeSet map = new TreeSet();
        map.add("one");
        map.add("two");
        map.add("three");
        map.add("four");
        map.add("one");
        Iterator it = map.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
