package General;

public class FindSecondMin {
    /* Requirements: implement a function that get's an array of integers, and returns the second minimum.
    For example: [6,8,3,1,4] -> 3 (1 is the minimum)
    For cases like [3] or [4,4,4] where there is no second minimum, the function should return null.
    The Time Complexity should be O(n) and it should be done in only one iteration on the array!!
    P.S the solution can be generalized to FindXthMin, for example FindFourthMin etc by
    using an array that holds all the mins, for example, for FindFourthMin we will hold an array of size 4
    that hold the mins and through the iteration on the array we will update the mins to find the fourth min,
    similar to what I did here, but since in this case I needed the second min so I used variables and not array.
     */

    private static Integer findSecondMin(int[] arr) {
        if (arr.length <= 1) {
            return null;
        }

        Integer secondMin = null;
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            if (current < min) {
                secondMin = min;
                min = current;
            } else if (current > min && (secondMin == null || current < secondMin)) {
                secondMin = current;
            }
        }

        return secondMin;

    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 3, 1};
        System.out.println(findSecondMin(arr));
    }
}
