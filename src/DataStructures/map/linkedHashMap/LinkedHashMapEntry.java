package DataStructures.map.linkedHashMap;

import DataStructures.map.hashMap.HashMapEntry;

public class LinkedHashMapEntry<K,V> extends HashMapEntry<K,V> {
    private LinkedHashMapEntry<K,V> next;
    // for doubly linked list in insertion order
    private LinkedHashMapEntry<K,V> inOrderPrev;
    private LinkedHashMapEntry<K,V> inOrderNext;


    public LinkedHashMapEntry(K key, V value) {
        super(key, value);
    }


    @Override
    public LinkedHashMapEntry<K, V> getNext() {
        return next;
    }

    public void setNext(LinkedHashMapEntry<K, V> next) {
        this.next = next;
    }

    public LinkedHashMapEntry<K, V> getInOrderPrev() {
        return inOrderPrev;
    }

    public void setInOrderPrev(LinkedHashMapEntry<K, V> inOrderPrev) {
        this.inOrderPrev = inOrderPrev;
    }

    public LinkedHashMapEntry<K, V> getInOrderNext() {
        return inOrderNext;
    }

    public void setInOrderNext(LinkedHashMapEntry<K, V> inOrderNext) {
        this.inOrderNext = inOrderNext;
    }
}
