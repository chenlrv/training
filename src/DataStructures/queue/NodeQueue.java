package DataStructures.queue;

public class NodeQueue<T> {
    private Node<T> start;
    private Node<T> end;
    private int size;

    public NodeQueue() {
        start = null;
        end = start;
        size = 0;
    }

    public void enqueue(T value) {
        Node<T> node = new Node<>(value);
        if (size == 0) {
            end = node;
            start = end;
        } else {
            end.setNext(node);
            end = node;
        }

        size += 1;
    }

    public T dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("Can't dequeue from empty queue");
        }
        T value = start.getValue();
        start = start.getNext();
        if (size == 1) {
            end = start;
        }
        size -= 1;
        return value;
    }

    public T peek() throws Exception {
        if (size == 0) {
            throw new Exception("Queue is empty");
        }

        return start.getValue();
    }
}
