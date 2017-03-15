package shanky;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

enum MapType {
    HASH_MAP, LINKED_HASH_MAP, TREE_MAP
}

/**
 * Created by sshek8 on 2/26/2017.
 */
public class TestMap {
    public static void main(String[] args) {
        testHashMap();
        testTreeMap();
        testLinkedHashMap();
    }

    private static void testTreeMap() {
        Map<Person, String> map = getMap(MapType.TREE_MAP);
        System.out.println(map);
    }

    private static void testHashMap() {
        Map<Person, String> map = getMap(MapType.HASH_MAP);
        System.out.println(map);
    }

    private static void testLinkedHashMap() {
        Map<Person, String> map = getMap(MapType.LINKED_HASH_MAP);
        System.out.println(map);
    }


    private static Map<Person, String> getMap(MapType mapType) {
        Map<Person, String> map;
        switch (mapType) {
            case HASH_MAP:
                map = new HashMap<>();
                break;
            case LINKED_HASH_MAP:
                map = new LinkedHashMap<>();
                break;
            case TREE_MAP:
                map = new TreeMap<>();
                break;
            default:
                map = null;
        }
        map.put(new Person("A"), "ABCD");
        map.put(new Person("B"), "PQRS");
        map.put(new Person("C"), "XYX");
        map.put(new Person("D"), "LMN");
        return map;
    }


}

class Person implements Comparable {

    private final String key;

    public Person(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public String toString() {
        return key;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || !(o instanceof Person)) {
            throw new RuntimeException("Object not compatible to compare");
        }
        Person that = (Person) o;
        return this.key.compareTo(that.toString());
    }
}