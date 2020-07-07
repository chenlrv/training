package DataStructures.map;

public interface IMap<K,V> {

    boolean containsKey(K key);

    V get(K key);

    void put(K key, V value);

    void remove(K key);
}
