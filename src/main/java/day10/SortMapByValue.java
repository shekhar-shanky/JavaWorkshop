package day10;


import java.util.*;

/**
 * Created by sshek8 on 8/26/2016.
 */
public class SortMapByValue {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("java", 20);
        map.put("C++", 45);
        map.put("Java2Novice", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Why this kolavari", 93);
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " ==== " + entry.getValue());
        }

    }
}
