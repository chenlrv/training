package Sandbox.Threads;


public class Starvation {

    public static void main(String[] args) {
        Task t = new Task();
        (new Thread(new LongThread(t))).start();
        (new Thread(new QuickThread(t))).start();
    }
}

class Task {

    public synchronized void longTask() {
        int i = 0;
        while (i < 1000) {
            System.out.println("Still working...");
            i++;
        }
    }

    public synchronized void shortTask() {
        System.out.println("I am a short task!");
    }
}

class LongThread implements Runnable {
    private Task t;

    public LongThread(Task t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.longTask();
    }
}

class QuickThread implements Runnable {
    private Task t;

    public QuickThread(Task t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.shortTask();
    }
}

