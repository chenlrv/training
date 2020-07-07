package DataStructures.map.hashMap;

import DataStructures.map.IMap;

public class MyHashMap<K, V> implements IMap<K, V> {
    private HashMapEntry[] table;
    private static final int MAX_SIZE = 100;

    public MyHashMap() {
        table = new HashMapEntry[MAX_SIZE];
    }

    private int simpleHashFunction(K key) {
        return key.toString().length() % table.length;
    }

    @Override
    public boolean containsKey(K key) {
        int index = simpleHashFunction(key);
        HashMapEntry<K, V> head = table[index];

        while (head != null) {
            if (head.getKey().equals(key)) {
                return true;
            }
            head = head.getNext();
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = simpleHashFunction(key);
        HashMapEntry<K, V> head = table[index];

        while (head != null) {
            if (head.getKey().equals(key)) {
                return head.getValue();
            }
            head = head.getNext();
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int index = simpleHashFunction(key);
        HashMapEntry<K, V> head = table[index];

        if (head == null) {
            table[index] = new HashMapEntry<>(key, value);
        } else {
            HashMapEntry<K, V> current = head;

            while (head != null) {
                if (head.getKey().equals(key)) {
                    head.setValue(value);
                    return;
                } else {
                    current = head;
                    head = head.getNext();
                }
            }

            current.setNext(new HashMapEntry<>(key, value));
        }
    }


    @Override
    public void remove(K key) {
        int index = simpleHashFunction(key);
        HashMapEntry<K, V> head = table[index];

        if (head == null) {
            return;
        }

        if (head.getKey().equals(key)) {
            table[index] = head.getNext();
        } else {
            while (head.getNext() != null) {
                if (head.getNext().getKey().equals(key)) {
                    head.setNext(head.getNext().getNext());
                    break;
                }
                head = head.getNext();
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();
        hashMap.put("bobo", 1);
        hashMap.put("cat", 1);
        hashMap.put("dog", 1);
        hashMap.put("hello", 2);

        Integer dog = hashMap.get("dog");
        Integer cat = hashMap.get("cat");
        hashMap.remove("dog");
        System.out.println("done");
    }
}
