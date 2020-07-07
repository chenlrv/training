package CrackTheCode;

public class CharArrayWithoutDuplicates {


    static char[] compressArray(char[] array) {
        char[] arrayWithoutDuplicates = new char[array.length];
        int j = 0;
        if (array.length < 2) {
            return array;
        }


        char currentChar = array[0];
        arrayWithoutDuplicates[j++] = currentChar;
        for (int i = 1; i < array.length; i++) {

            if (array[i] != currentChar) {
                arrayWithoutDuplicates[j++] = array[i];
                currentChar = array[i];
            }
        }

        arrayWithoutDuplicates[j] = '\0';
        System.out.println(arrayWithoutDuplicates.length);
        return arrayWithoutDuplicates;
    }

    static void compressArrayInPlace(char[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int currentCharIndex = 0;
        int checkerIndex = 1;
        boolean isCharDuplicated = false;

        while (checkerIndex < array.length) {
            char c1 = array[currentCharIndex];
            char c2 = array[checkerIndex];

            if (c1 == c2) {
                isCharDuplicated = true;
                checkerIndex++;
            } else {
                currentCharIndex++;
                if (isCharDuplicated) {
                    array[currentCharIndex] = array[checkerIndex];
                    isCharDuplicated = false;
                } else {
                    checkerIndex++;
                }
            }
        }
        while (currentCharIndex < array.length - 1){
            array[++currentCharIndex] = '\0';
        }

    }


    public static void main(String[] args) {

        char[] arr = {'c', 'c', 'c', 'c'};
//        System.out.println(compressArray(arr));

        String s = "c";

        System.out.println(s.substring(1).length()==0);
        compressArrayInPlace(arr);
        System.out.println(arr);

    }
}
