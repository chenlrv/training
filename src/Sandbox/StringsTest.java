package Sandbox;


public class StringsTest {

    public static void main(String[] args) {
        String s1 = "hi";
        String s2 = "hi";
        String s3 = new String("hi");
        String s4 = new String("hi");

        System.out.println(s1 == s2); // true
        System.out.println(s1.equals(s2)); // true
        System.out.println(s3 == s4); // false
        System.out.println(s3.equals(s4)); // true

        System.out.println("finish");
    }
}
