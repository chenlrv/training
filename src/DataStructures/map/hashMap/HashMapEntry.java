package DataStructures.map.hashMap;

public class HashMapEntry<K,V> {
    private K key;
    private V value;
    private HashMapEntry<K,V> next;

    public HashMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashMapEntry<K, V> getNext() {
        return next;
    }

    public void setNext(HashMapEntry<K, V> next) {
        this.next = next;
    }
}
