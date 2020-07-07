package General;

import java.util.Iterator;

public class ListWithEvenIt implements Iterable<Integer> {
    private int[] array;

    ListWithEvenIt(int[] array) {
        this.array = array;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new EvenIterator();
    }

    class EvenIterator implements Iterator<Integer> {
        private int currentPos = 0;

        @Override
        public boolean hasNext() {
            while (currentPos < array.length && array[currentPos] % 2 != 0) {
                currentPos++;
            }

            return currentPos < array.length;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return array[currentPos++];
            } else {
                return null;
            }
        }


    }


    public static void main(String[] args) {
        int[] arr = {1,4,5,2,6,7,2};
        ListWithEvenIt l = new ListWithEvenIt(arr);

        for (Iterator<Integer> it = l.iterator(); it.hasNext();){
            System.out.println(it.next());
        }
    }
}

