package DataStructures.list.singlyLinkedList;

import DataStructures.list.IList;

public class SinglyLinkedList<T> implements IList<T> {
    private SinglyNode<T> start;
    private SinglyNode<T> end;
    private int size;

    public SinglyLinkedList() {
    }

    @Override
    public void add(T value) {
        SinglyNode<T> newNode = new SinglyNode<>(value);

        if (end == null) {
            end = newNode;
            start = end;
        } else {
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
        SinglyNode<T> newNode = new SinglyNode<>(value);

        if (index == 0) {
            if (start == null) {
                start = newNode;
                end = start;
            } else {
                newNode.setNext(start);
                start = newNode;
            }
        } else if (index == size) {
            end.setNext(newNode);
            end = newNode;
        } else {
            SinglyNode<T> node = start;

            for (int i = 0; i < index - 1; i++) {
                node = node.getNext();
            }
            SinglyNode<T> next = node.getNext();
            node.setNext(newNode);
            newNode.setNext(next);
        }
        size++;

    }

    @Override
    public T get(int index) throws Exception {
        if (index >= size || index < 0) {
            throw new Exception("Out of bounds");
        }

        SinglyNode<T> node = start;
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

        SinglyNode<T> node = start;

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
                SinglyNode<T> node = start;

                while (node.getNext() != null && node.getNext().getNext() != null) {
                    node = node.getNext();
                }

                node.setNext(null);
                end = node;
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
                SinglyNode<T> node = start;
                if (node.getValue().equals(value)) {
                    start = start.getNext();
                } else {
                    while (node.getNext() != null && !node.getNext().getValue().equals(value)) {
                        node = node.getNext();
                    }

                    SinglyNode<T> nodeToRemove = node.getNext();
                    if (nodeToRemove == null) {
                        return;
                    } else {
                        node.setNext(nodeToRemove.getNext());
                    }
                }
                size--;
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
        } else {
            SinglyNode<T> node = start;

            for (int i = 0; i < index - 1; i++) {
                node = node.getNext();
            }

            SinglyNode<T> nodeToRemove = node.getNext();
            node.setNext(nodeToRemove.getNext());
            if (node.getNext() == null) {
                end = node;
            }

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
        SinglyNode<T> node = start;

        for (int i = 0; i < size; i++) {
            stringBuilder.append(node.getValue());
            stringBuilder.append(",");
            node = node.getNext();
        }
        stringBuilder.append("}");
        if (stringBuilder.length() > 3) stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        return stringBuilder.toString();
    }

    public SinglyNode<T> getHead(){
        return start;
    }

    public void setHead(SinglyNode<T> newHead){
        start = newHead;
    }

    private static class PowerWrapper {
        int power = 0;
    }


    private static double getListValue(SinglyNode<Integer> node, PowerWrapper p) {
        if (node.getNext() == null) {
            p.power = 0;
            return node.getValue();
        }
        double currentNum = getListValue(node.getNext(), p);
        p.power += 1;
        return currentNum + node.getValue() * Math.pow(10, p.power);
    }

    public static void main(String[] args) throws Exception {
//        SinglyNode<Integer> a = new SinglyNode<>(6);
//        SinglyNode<Integer> b = new SinglyNode<>(1);
//        SinglyNode<Integer> c = new SinglyNode<>(7);
//        a.setNext(b);
//        b.setNext(c);
//
//        System.out.println(getListValue(a, new PowerWrapper()));
        SinglyLinkedList<Integer> integerSinglyLinkedList = new SinglyLinkedList<>();
        System.out.println(integerSinglyLinkedList.toString());
        integerSinglyLinkedList.add(5);
        System.out.println(integerSinglyLinkedList.toString());
        integerSinglyLinkedList.add(2, 0);
        System.out.println(integerSinglyLinkedList.toString());
        integerSinglyLinkedList.add(3, 2);
        System.out.println(integerSinglyLinkedList.toString());
        integerSinglyLinkedList.remove();
        System.out.println(integerSinglyLinkedList.toString());
        integerSinglyLinkedList.remove(Integer.valueOf(2));
        System.out.println(integerSinglyLinkedList.toString());
        integerSinglyLinkedList.add(6, 1);
        System.out.println(integerSinglyLinkedList.toString());
    }
}
