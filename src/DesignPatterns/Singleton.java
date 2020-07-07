package DesignPatterns;

public class Singleton {
    private static Singleton singelton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singelton == null) {
            synchronized (Singleton.class) {
                if (singelton == null) {
                    singelton = new Singleton();
                }
            }
        }
        return singelton;
    }
}
