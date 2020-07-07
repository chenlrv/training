package DataStructures.list.singlyLinkedList;

public class Questions<T> {

    private static <T> void reverseSinglyLinkedList(SinglyLinkedList<T> list) {
        SinglyNode<T> head = list.getHead();
        if (head == null || head.getNext() == null) {
            return;
        }
        SinglyNode<T> previous = null;
        SinglyNode<T> next = head.getNext();

        while (next != null) {
            head.setNext(previous);
            previous = head;
            head = next;
            next = next.getNext();
        }
        head.setNext(previous);
        list.setHead(head);

    }

    private static <T> void rotateListByN(SinglyLinkedList<T> list, int n) {
        SinglyNode<T> head = list.getHead();
        SinglyNode<T> runner = list.getHead();

        if (head == null || head.getNext() == null) { //empty list or list with only 1 element
            return;
        }

        while (n > 0) {
            runner = runner.getNext();
            if (runner == null){ //handle the case when n > size of the list, doing full cycles.
                runner = head;
            }
            n--;
        }

        while (runner.getNext()!= null) {
            head = head.getNext();
            runner = runner.getNext();
        }

        SinglyNode<T> newHead = head.getNext();
        head.setNext(null);
        runner.setNext(list.getHead());
        list.setHead(newHead);
    }


    public static <T> void main(String[] args) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        System.out.println(list1.toString());
        rotateListByN(list1, 5);
        reverseSinglyLinkedList(list1);
        System.out.println(list1.toString());


    }
}
