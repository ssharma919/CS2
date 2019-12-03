package cs2.hash;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class CS2HashMap<K extends Comparable<K>, V> {
    private ArrayList<TreeMap<K, V>> list;
    private int size;

    public CS2HashMap(int s) {
        list = new ArrayList<>();
        size = s;
        for (int i = 0; i < size; i++) list.add(new TreeMap<K, V>());
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int bucket = key.hashCode()%list.size();
        return list.get(bucket).get(key);
    }

    public V put (K key, V value) {
        int bucket = key.hashCode()%list.size();
        V val = list.get(bucket).get(key);
        list.get(bucket).put(key, value);
        return val;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            Set<K> set = list.get(i).keySet();
            for (K key: set) {
                str += key + " -> " + list.get(i).get(key) + "; ";
            }
        }
        return str;
    }
}
