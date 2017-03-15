package day10;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sshek8 on 8/26/2016.
 */
public class SortedMapByValueTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "ABC");
        map.put(2, "ZDC");
        map.put(3, "KLJH");

        Map<Integer, String> sortedMapByValue = SortedMapByValue.sortMapByValue(map);

        for (Map.Entry<Integer, String> entry : sortedMapByValue.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
