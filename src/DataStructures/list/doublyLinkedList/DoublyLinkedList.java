package DataStructures.list.doublyLinkedList;

import DataStructures.list.IList;

public class DoublyLinkedList<T> implements IList<T> {
    private DoublyNode<T> start;
    private DoublyNode<T> end;
    private int size;

    public DoublyLinkedList() {
    }

    @Override
    public void add(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);

        if (end == null) {
            end = newNode;
            start = newNode;
        } else {
            newNode.setPrev(end);
            end.setNext(newNode);
            end = newNode;
        }
        size++;
    }

    @Override
    public void add(T value, int index) throws Exception {
        if (index > size || index < 0) {
            throw new Exception("Out of bounds");
        }

        DoublyNode<T> newNode = new DoublyNode<>(value);

        if (index == 0) {
            if (start == null) {
                start = newNode;
                end = start;
            } else {
                start.setPrev(newNode);
                newNode.setNext(start);
                start = newNode;
            }
        } else if (index == size) {
            end.setNext(newNode);
            newNode.setPrev(end);
            end = newNode;
        } else {
            DoublyNode<T> node = start;

            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }

            DoublyNode<T> prev = node.getPrev();
            prev.setNext(newNode);
            newNode.setPrev(prev);
            newNode.setNext(node);
            node.setPrev(newNode);
        }
        size++;
    }

    @Override
    public T get(int index) throws Exception {
        if (index >= size || index < 0) {
            throw new Exception("Out of bounds");
        }

        DoublyNode<T> node = start;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node.getValue();
    }

    @Override
    public void set(T value, int index) throws Exception {
        if (index >= size || index < 0) {
            throw new Exception("Out of bounds");
        }

        DoublyNode<T> node = start;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        node.setValue(value);
    }

    @Override
    public void remove() {
        if (size > 0) {
            if (size == 1) {
                start = end = null;
            } else {
                DoublyNode<T> newEnd = end.getPrev();
                newEnd.setNext(null);
                end = newEnd;
            }
            size--;
        }
    }

    @Override
    public void remove(T value) {
        if (size > 0) {
            if (size == 1) {
                if (start.getValue().equals(value)) {
                    start = end = null;
                    size--;
                }
            } else {
                DoublyNode<T> node = start;

                for (int i = 0; i < size; i++) {
                    if (node.getValue().equals(value)) {
                        if (i == 0) {
                            start = start.getNext();
                            start.setPrev(null);
                        } else if (i == size - 1) {
                            end = end.getPrev();
                            end.setNext(null);
                        } else {
                            DoublyNode<T> prev = node.getPrev();
                            DoublyNode<T> next = node.getNext();
                            prev.setNext(next);
                            next.setPrev(prev);
                        }

                        size--;
                        break;
                    }
                    node = node.getNext();
                }
            }
        }
    }

    @Override
    public void remove(int index) throws Exception {
        if (index >= size || index < 0) {
            throw new Exception("Out of bounds");
        }

        if (size == 1) {
            start = end = null;
        } else if (index == 0) {
            start = start.getNext();
            start.setPrev(null);
        } else if (index == size - 1) {
            end = end.getPrev();
            end.setNext(null);
        } else {
            DoublyNode<T> node = start;

            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }

            DoublyNode<T> prev = node.getPrev();
            DoublyNode<T> next = node.getNext();
            prev.setNext(next);
            next.setPrev(prev);
        }

        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        DoublyNode<T> node = start;

        for (int i = 0; i < size; i++) {
            stringBuilder.append(node.getValue());
            stringBuilder.append(",");
            node = node.getNext();
        }
        stringBuilder.append("}");
        if (stringBuilder.length() > 3) stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        System.out.println(integerDoublyLinkedList.toString());
        integerDoublyLinkedList.add(5);
        System.out.println(integerDoublyLinkedList.toString());
        integerDoublyLinkedList.add(2, 0);
        System.out.println(integerDoublyLinkedList.toString());
        integerDoublyLinkedList.add(3, 2);
        System.out.println(integerDoublyLinkedList.toString());
        integerDoublyLinkedList.remove();
        System.out.println(integerDoublyLinkedList.toString());
        integerDoublyLinkedList.remove(Integer.valueOf(2));
        System.out.println(integerDoublyLinkedList.toString());
    }
}
