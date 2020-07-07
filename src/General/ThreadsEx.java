package General;


class ThreadsExample implements Runnable {
    private static int counter = 0;

    @Override
    public void run() {

        for (int i = 0 ; i < 9; i++){
            counter++; /*this it not atomic operation, in this operation there are 3 operation that are hiding:
                                reading the current value of counter, adding plus 1 to it and then assignment
                                to counter again
                                */

        }

    }
}
public class ThreadsEx {

    public static void main(String[] args) {
        ThreadsExample te = new ThreadsExample();
        Thread thread1 = new Thread(te);
        Thread thread2 = new Thread(te);

        thread1.start();
        thread2.start();
    }
}

/* Questions:
1. What is the minimum possible value for counter and what is the maximum possible value?
Because there is no synchronization between the threads
(volatile keyword on counter wouldn't help here anyways, because it can replace using synchronization only
when one thread is writing values and the other is only reading and not writing also..), there are many different
options for the final value of the counter.
However, we can know the exact values of the minimum and maximum values that are possible.
First, let's remind few concepts regrading multithreading -
1. when threads are not synchronized and they access a common resource (counter in this case) concurrently,
2 types of problems might occur - threads interference and memory inconsistency (more about that in the Word summary)
without synchronization,
2 threads that are accessing the same resource (counter) and performs action which is not atomic -
may have thread interference problem (one thread's change may override other thread's change),
and memory inconsistency problem - running on 2 different cores, each one is saving the counter value in a different cache,
so they can't see the changes that the other thread performed to the counter, since it wasn't flushed to the main memory.
The OS determines when to flush the writes from cache to main memory (RAM)and it is unpredictable.
Now let's understand the solution.

minimum = 2 :
Let's look at the following scenario.
Thread1 first read value of counter from main memory to it's cache. now it's 0 in it's cache.
Thread2 first read value of counter from main memory to it's cache. now it's 0 in it's cache.
Thread1 increment the counter until 9 (the value is saved in it's cache) and then OS updates main memory that counter is 9.
Meanwhile, Thread 2 increment the counter to 1 and then OS updates main memory that counter is 1.
So, all progress of Thread1 is "gone".
Thread1 reads that value from RAM and put it in it's cache. now it's 1 in it's cache.
Then Thread 2 increments until 10 (the value is saved in it's cache) and OS updates main memory that counter is 10.
But Thread1 still has the value of 1 and increments it and OS updates main memory that counter is 2.

maximum = 20 :
This scenario is the ideal scenario, where the threads act exactly as if they were synchronized.
Thread1 increment counter to 1, then Thread2 increment counter to 2, .. etc.
Every change that one thread did to counter is visible to the other thread.
Every thread increments the counter 10 times, so the maximum value is 20.


2. How many threads can run in pc? what is the limitation?
The limitation at the end is the memory of the pc, because each process has threads (at least 1)
and every different process holds different memory space.
If for example, a pc has 2 cores, then a process can run 2 of its threads completely parallel,
1 thread run on each core. If we run 4 threads on pc with 2 cores,
2 threads on each core, then it will be simultaneously, not parallel, means that there will be only 1 thread
on each core that runs at a time, and the OS will switch between them very quickly in order that both
will proceed.
3. how are threads run, when each thread run? if there is only one core who decides which thread runs now?
the OS decides which thread run according to defined policies - FIFO, Round Robin etc.
the OS perform context switch between threads in case they run simultaneously, not parallel.
 */
