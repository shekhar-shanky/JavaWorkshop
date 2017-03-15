package day10;

import java.util.*;

/**
 * Created by sshek8 on 8/26/2016.
 */
public class SortedMapByValue {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortMapByValue(Map<K, V> inputMap) {

        List<Map.Entry<K, V>> list = new LinkedList<>(inputMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();


        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
