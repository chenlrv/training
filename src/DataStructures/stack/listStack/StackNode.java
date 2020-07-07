package DataStructures.stack.listStack;

public class StackNode<T> {
    private T value;
    private StackNode<T> prev;

    public StackNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public StackNode<T> getPrev() {
        return prev;
    }

    public void setPrev(StackNode<T> prev) {
        this.prev = prev;
    }
}
