package Sandbox;

public class ExceptionsTest {

    public static void main(String[] args) {
        foo();
        foo2();
    }

    private static void foo() {
        try {
            throw new Exception();

        } catch (Exy e1){
            System.out.println("Caught in exy");
        }catch (Exception e2){
            System.out.println("Caught in exception");
        }
    }

    public static void foo2() {
        try {
            throw new RuntimeException(); //RuntimeException cannot be caught, but finally still runs!

        }finally {
            System.out.println("hi");
        }
    }
}

class Exy extends Exception {

}
