package day3;

import java.util.Hashtable;

/**
 * Created by sshek8 on 8/12/2016.
 */
public class SyncNull {

    public static void main(String[] args) {

        Hashtable map = new Hashtable();
        map.put(null, null);


        Object obj = null;


        synchronized (obj) {
            System.out.println("Something");
        }
    }
}
