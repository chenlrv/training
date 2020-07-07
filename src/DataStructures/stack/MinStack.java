package DataStructures.stack;

public class MinStack implements IStack<Integer> {
    private MinStackNode<Integer> top;
    private int size;
    private static final int MAX_SIZE = 10;

    /* Implementation on min stack, a regular stack with peek, pop, push with O(1)
    and one additional operation of getting the current min in the stack in O(1).
    This is done by adding property of min value for every StackNode (implemented in the new MinStackNode)
    so we know what is the min in every point of the stack
     */

    @Override
    public Integer peek() throws Exception {
        if (size == 0) {
            throw new Exception("Empty stack");
        }
        return top.getValue();
    }

    @Override
    public Integer pop() throws Exception {
        if (size == 0) {
            throw new Exception("Empty stack");
        }

        int value = top.getValue();
        top = top.getPrev();
        size--;
        return value;
    }

    @Override
    public void push(Integer num) throws Exception {
        if (size == MAX_SIZE) {
            throw new Exception("Stack overflow!");
        }

        MinStackNode<Integer> newNode = new MinStackNode<>(num);
        if (size == 0) {
            newNode.setCurrentMin(num);
            top = newNode;
        } else {
            newNode.setPrev(top);
            newNode.setCurrentMin(Math.min(num, min()));
            top = newNode;
        }

        size++;
    }

    public int min() throws Exception {
        if (size == 0) {
            throw new Exception("Empty stack");
        }

        return top.getCurrentMin();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        MinStackNode<Integer> node = top;
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
        MinStack minStack = new MinStack();
        System.out.println(minStack);
        minStack.push(5);
        System.out.println(minStack);
        System.out.println("Current min: " + minStack.min());
        minStack.push(3);
        System.out.println(minStack);
        System.out.println("Current min: " + minStack.min());
        System.out.println("peek: " + minStack.peek());
        minStack.push(4);
        System.out.println(minStack);
        System.out.println("Current min: " + minStack.min());
        minStack.push(1);
        System.out.println(minStack);
        System.out.println("Current min: " + minStack.min());
        minStack.push(2);
        System.out.println(minStack);
        System.out.println("Current min: " + minStack.min());
        minStack.pop();
        System.out.println(minStack);
        System.out.println("Current min: " + minStack.min());
        minStack.pop();
        System.out.println(minStack);
        System.out.println("Current min: " + minStack.min());
        minStack.pop();
        System.out.println(minStack);
        System.out.println("Current min: " + minStack.min());
    }
}
