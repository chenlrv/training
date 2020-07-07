package Sandbox.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {

    /**
     * n the above program, we are creating a fixed-size thread pool of 5 worker threads.
     * Then we are submitting 10 jobs to this pool, since the pool size is 5,
     * it will start working on 5 jobs and other jobs will be in wait state, as soon as one of the job is finished,
     * another job from the wait queue will be picked up by worker thread and get’s executed.
     *
     * The output confirms that there are five threads in the pool named from “pool-1-thread-1” to “pool-1-thread-5”
     * and they are responsible to execute the submitted tasks to the pool.
     *
     *
     */
    
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            Runnable task = new Task(i);
            executorService.execute(task);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

    private static class Task implements Runnable {
        private int taskNum;

        public Task(int taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " started. Task number is : " + taskNum);
            processTask();
            System.out.println(Thread.currentThread().getName() + " ended.");
        }

        private void processTask() {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
