package DataStructures.list;

public interface IList<T> {
    void add(T value); //add to the end

    void add(T value, int index) throws Exception;

    T get(int index) throws Exception;

    void set(T value, int index) throws Exception;

    void remove(); //remove from the end

    void remove(T value); //remove by value

    void remove(int index) throws Exception;

    int size();

    boolean isEmpty();
}
