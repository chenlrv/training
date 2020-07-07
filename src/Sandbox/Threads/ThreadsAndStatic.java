package Sandbox.Threads;

public class ThreadsAndStatic {

    static synchronized void doLongTask(){
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " still here...");
        }
    }

    synchronized void doShortTask(){
        System.out.println(Thread.currentThread().getName() + " doing short task!");
    }

    public static void main(String[] args) {
        ThreadsAndStatic obj = new ThreadsAndStatic();
        (new Thread(new LongTaskThread(obj))).start();
        (new Thread(new ShortTaskThread(obj))).start();
    }

    private static class LongTaskThread implements Runnable{
        ThreadsAndStatic object;

        LongTaskThread(ThreadsAndStatic object) {
            this.object = object;
        }

        @Override
        public void run() {
            doLongTask();
        }
    }

    private static class ShortTaskThread implements Runnable{
        ThreadsAndStatic object;

        ShortTaskThread(ThreadsAndStatic object) {
            this.object = object;
        }

        @Override
        public void run() {
            object.doShortTask();
        }
    }
}
