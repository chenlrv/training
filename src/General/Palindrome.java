package General;

public class Palindrome {

    private static boolean checkIfPalindromeIterative(String str) {
        char[] chars = str.toCharArray();
        int mid = chars.length / 2;
        for (int i = 0; i < mid; i++) {
            char first = chars[i];
            char second = chars[chars.length - 1 - i];
            if (first != second) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfPalindromeRecursive(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() <= 1) {
            return true;
        }

        if (!str.substring(0, 1).equals(str.substring(str.length() - 1))) {
            return false;
        }

        return checkIfPalindromeRecursive(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        String s1 = "abba";
        String s2 = "abcba";
        String s3 = "badb";
        System.out.println(checkIfPalindromeIterative(s1));
        System.out.println(checkIfPalindromeIterative(s2));
        System.out.println(checkIfPalindromeIterative(s3));
        System.out.println(checkIfPalindromeRecursive(s1));
        System.out.println(checkIfPalindromeRecursive(s2));
        System.out.println(checkIfPalindromeRecursive(s3));
    }
}
