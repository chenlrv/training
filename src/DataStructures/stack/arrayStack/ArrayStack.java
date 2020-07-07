package DataStructures.stack.arrayStack;

import DataStructures.stack.IStack;

public class ArrayStack<Item> implements IStack<Item> {
    private int top;
    private int size;
    private Item[] stack;

    public ArrayStack(int size) {
        this.size = size;
        top = -1;
        stack = (Item[]) new Object[size];
    }

    @Override
    public Item peek() throws Exception {
        if (top == -1){
            throw new Exception("Empty stack");
        }
        return stack[top];
    }

    @Override
    public Item pop() throws Exception {
        if (top == -1){
            throw new Exception("Empty stack");
        }
        return stack[top--];
    }

    @Override
    public void push(Item item) throws Exception {
        if (top == size - 1){
            throw new Exception("Stack overflow!");
        }
        stack[++top] = item;
    }
}
