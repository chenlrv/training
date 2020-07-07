package DataStructures.list.singlyLinkedList;

public class SinglyNode<T> {
    private T value;
    private SinglyNode<T> next;

    public SinglyNode(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SinglyNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyNode<T> next) {
        this.next = next;
    }
}
