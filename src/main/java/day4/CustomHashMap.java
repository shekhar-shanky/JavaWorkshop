package day4;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by sshek8 on 8/15/2016.
 */
public class CustomHashMap<K extends CharSequence, V extends Number> implements Serializable {

    HashMap<K, V> map;

    public CustomHashMap() {
        map = new HashMap();
    }

    public void add(K key, V value) {
        map.put(key, value);
    }

    public V getValue(K key) {
        return map.get(key);
    }
}
