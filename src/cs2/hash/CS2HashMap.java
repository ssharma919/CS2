package cs2.hash;

import java.util.*;

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
        int bucket = Math.abs(key.hashCode() % list.size());
        return list.get(bucket).get(key);
    }

    public V put(K key, V value) {
        int bucket = Math.abs(key.hashCode() % list.size());
        V val = list.get(bucket).get(key);
        list.get(bucket).put(key, value);
        return val;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            Set<K> set = list.get(i).keySet();
            for (K key : set) {
                str += key + " -> " + list.get(i).get(key) + "; ";
            }
        }
        return str;
    }

    public boolean containsKey(K key) {
        int bucket = Math.abs(key.hashCode() % list.size());
        return list.get(bucket).containsKey(key);
    }

    public boolean containsValue(V val) {
        for (int i = 0; i < size; i++) {
            if (list.get(i).containsValue(val)) return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (int i = 0; i < size; i++) {
            set.addAll(list.get(i).keySet());
        }
        return set;
    }

    public V remove(K key) {
        int bucket = Math.abs(key.hashCode() % list.size());
        return list.get(bucket).remove(key);
    }

    public Collection<V> values() {
        Collection<V> col = new HashSet<V>();
        for (int i = 0; i < size; i++) {
            col.addAll(list.get(i).values());
        }
        return col;
    }
}
