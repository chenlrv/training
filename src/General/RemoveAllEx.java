package General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveAllEx {

    private static void removeAll1(List<String> list, String toRemove){
        for (String s : list) {
            if (s.equals(toRemove)) {
                list.remove(toRemove);
            }
        }
    }

    private static void removeAll2(List<String> list, String toRemove){
        int size = list.size();

        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(toRemove)) {
                list.remove(i);
            }
        }
    }

    private static void removeAll3(List<String> list, String toRemove){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(toRemove)) {
                list.remove(i);
            }
        }
    }

    private static void removeAll4(List<String> list, String toRemove){
        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            if (it.next().equals(toRemove)) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "D", "R", "A", "E"));
        removeAll1(list, "A");
        removeAll2(list, "A");
        removeAll3(list, "A");
        removeAll4(list, "A");

        /*
        Question: explain the correctness and efficiency for each remove function
        1. removeAll1:
        - Correctness: Incorrect. There will be "ConcurrentModification" exception!
        - Efficiency: O(N^2) : loop on n values, but inside each iteration,
        the list.remove(toRemove) will go over the n values again in order to find that value!
        making the outer loop redundant actually...
        Read how foreach is implemented behind the scenes!

        2. removeAll2:
        - Correctness: Incorrect. The value for the size of the list is taken in the beginning,
        but meanwhile the list will be shortened when removing values from it, so there will be OutOfBoundsException!
        - Efficiency: O(N)

        3. removeAll3:
        - Correctness: Incorrect. Now the size of the list will be correct in every iteration, but the problem is
        that even after removing letters i is being advanced and will miss letters that should be removed-
        try to run example manually and understand it
        - Efficiency: O(N)

        4. removeAll3:
        - Correctness: Correct. with iterator there is no ConcurrentModification exception!
        - Efficiency: O(N)

         */
    }
}
