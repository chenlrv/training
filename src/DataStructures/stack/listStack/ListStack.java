package DataStructures.stack.listStack;

import DataStructures.stack.IStack;

import java.util.List;

public class ListStack<T> implements IStack<T> {
    private StackNode<T> top;
    private int size;
    private static final int MAX_SIZE = 10;

    @Override
    public T peek() throws Exception {
        if (size == 0) {
            throw new Exception("Empty stack");
        }

        return top.getValue();
    }

    @Override
    public T pop() throws Exception {
        if (size == 0) {
            throw new Exception("Empty stack");
        }
        T value = top.getValue();
        top = top.getPrev();
        size--;
        return value;
    }

    @Override
    public void push(T t) throws Exception {
        if (size == MAX_SIZE) {
            throw new Exception("Stack overflow!");
        }

        StackNode<T> newNode = new StackNode<>(t);
        if (size == 0) {
            top = newNode;
        } else {
            newNode.setPrev(top);
            top = newNode;
        }

        size++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        StackNode<T> node = top;
        while (node != null) {
            stringBuilder.append(node.getValue());
            stringBuilder.append(",");
            node = node.getPrev();
        }
        stringBuilder.append("]");
        if (stringBuilder.length() > 2) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        ListStack<Integer> integerListStack = new ListStack<>();
        System.out.println(integerListStack);
        integerListStack.push(1);
        integerListStack.push(2);
        System.out.println(integerListStack);
        System.out.println("peek: " + integerListStack.peek());
        integerListStack.push(5);
        System.out.println(integerListStack);
        integerListStack.pop();
        System.out.println(integerListStack);
        integerListStack.pop();
        System.out.println(integerListStack);
        integerListStack.pop();
        System.out.println(integerListStack);
    }
}
