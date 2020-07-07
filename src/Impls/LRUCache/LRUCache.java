package Impls.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    /* LRU cache = least recently used cache.
    It support operations of get(key) and put(key, value) in O(1).
    It is implemented using a hashmap and a doubly linked list which contains the nodes.
    Each new entry is added to the end of the linked list, therefore, the list is sorted by use order -
    the most recently used node is at the end, and at the beginning is the node that
    wasn't used for the longest.
    Whenever the cache is full and a put operation is required, then the node that wasn't used for the longest
    will be removed from the cache, and the new node will be added to the end.
     */

    private Map<K, LRUEntry<K, V>> map;
    private LRUEntry<K, V> start;
    private LRUEntry<K, V> end;
    private static final int MAX_SIZE = 3;


    public LRUCache() {
        map = new HashMap<>();
    }

    public void put(K key, V value) {
        //evacuate space if needed for put operation
        if (map.size() == MAX_SIZE) {
            map.remove(start.getKey());
            LRUEntry<K, V> newStart = start.getNext();
            newStart.setPrev(null);
            start = newStart;
        }

        LRUEntry<K, V> entry = map.get(key);
        if (entry != null) {
            if (start == entry && end == entry) {
                start = end = null;
            } else if (start == entry) {
                LRUEntry<K, V> newStart = entry.getNext();
                newStart.setPrev(null);
                start = newStart;
            } else if (end == entry) {
                LRUEntry<K, V> newEnd = end.getPrev();
                newEnd.setNext(null);
                end = newEnd;
            }
        }

        LRUEntry<K, V> newEntry = new LRUEntry<>(key, value);
        if (end == null) {
            end = newEntry;
            start = end;
        } else {
            newEntry.setPrev(end);
            end.setNext(newEntry);
            end = newEntry;
        }
        map.put(key, newEntry);
    }

    public V get(K key) {
        LRUEntry<K, V> entry = map.get(key);
        if (entry != null) {
            if (start == entry && end == entry) {
                start = end = null;
            } else if (start == entry) {
                LRUEntry<K, V> newStart = entry.getNext();
                newStart.setPrev(null);
                start = newStart;
            } else if (end == entry) {
                LRUEntry<K, V> newEnd = end.getPrev();
                newEnd.setNext(null);
                end = newEnd;
            }
            if (end == null) {
                entry.setNext(null);
                entry.setPrev(null);
                end = entry;
                start = end;
            } else {
                entry.setPrev(end);
                entry.setNext(null);
                end.setNext(entry);
                end = entry;
            }
            map.put(key, entry);
            return entry.getValue();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>();
        cache.put("a", 1); // [a,1]
        cache.put("b",2); // [a,1],[b,2]
        cache.put("c",3); // [a,1],[b,2],[c,3]
        cache.put("a",4); // [b,2],[c,3],[a,4]
        cache.put("c",5); // [a,4],[c,5]
        Integer a = cache.get("a"); // [c,5],[a,4]
        System.out.println("Done");


    }
}
