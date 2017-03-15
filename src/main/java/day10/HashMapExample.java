package day10;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sshek8 on 8/26/2016.
 */
public class HashMapExample {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 16; i++) {
            map.put("Subrata" + i, i);
        }


    }
}
