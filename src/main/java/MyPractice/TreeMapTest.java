package MyPractice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sshek8 on 9/8/2016.
 */
public class TreeMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put(null, "A");
        map.put("B", "C");
        map.put(null, "E");

        System.out.println(map);

        List<String> random = new ArrayList<>();
        random.add("Shashank");
        random.add("Sun");


        try {
            for (int i = 0; i < random.size() + 1; i++) {
                System.out.println(random.get(i));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Bhai! Exception aa geyo");
        }
    }
}
