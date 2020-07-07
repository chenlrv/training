package Sandbox;

public class Freestyle {

    /* Given an array, find the index of the element where the sum of all the elements to the right of it,
    is the same as the sum of all the elements to the left of it.
    For example: [1,1,0,3,2,4,1] : the element is 2, index 4 - because the sum of right elements = left elements = 5
    Solution:
    Creating sum array from start: [1,2,2,5,7,11,12]
    Creating sum array from end: [12,11,10,10,7,5,1]
    We can see that in both arrays, 7 is in the same index.
    The sum equality element it the index that has the same value in both arrays. (the same sum from both sides!)
    Time Complexity: O(n)
    Space complexity: O(n)
     */
    private static int findSumEqualityElement(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return -1; // no such element
        }
        int[] sumArrayFromStart = new int[array.length];
        int[] sumArrayFromEnd = new int[array.length];

        sumArrayFromStart[0] = array[0];
        sumArrayFromEnd[array.length - 1] = array[array.length - 1];

        for (int i = 1, j = array.length - 2; i < array.length && j >= 0; i++, j--) {
            sumArrayFromStart[i] = array[i] + sumArrayFromStart[i - 1];
            sumArrayFromEnd[j] = array[j] + sumArrayFromEnd[j + 1];
        }

        for (int i = 0; i < array.length; i++) {
            if (sumArrayFromStart[i] == sumArrayFromEnd[i]) {
                return i;
            }
        }

        return -1; // no such element
    }

    /* Solution in Time Complexity of O(n) and Space Complexity O(1) */
    private static int findSumEqualityElementBetter(int[] array) {
        if (array.length <= 2) {
            return -1; // no such element
        }

        int arraySum = 0,  leftSum = 0, rightSum;
        for (int value : array) {
            arraySum += value;
        }

        for (int i = 1; i < array.length; i++) {
            leftSum = leftSum + array[i-1];
            rightSum = arraySum - array[i] - leftSum;

            if (leftSum == rightSum){
                return i;
            }
        }

        return -1; // no such element;
    }

    public static void main(String[] args) {
        int[] array1 = {1,1,0,3,2,4,1};
        int sumEqualityElement = findSumEqualityElementBetter(array1);

        int[] array2 = {1,2,2,1};
        int noSumEqualityElement = findSumEqualityElementBetter(array2);
    }
}
