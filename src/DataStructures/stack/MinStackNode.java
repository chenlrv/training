package DataStructures.stack;

public class MinStackNode<Integer> {

    private int value;
    private MinStackNode<Integer> prev;
    private int currentMin;

    public MinStackNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MinStackNode<Integer> getPrev() {
        return prev;
    }

    public void setPrev(MinStackNode<Integer> prev) {
        this.prev = prev;
    }

    public int getCurrentMin() {
        return currentMin;
    }

    public void setCurrentMin(int currentMin) {
        this.currentMin = currentMin;
    }
}
