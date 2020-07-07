package Sandbox;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) throws Exception {
        Callable<Integer> foo = ()-> {
            TimeUnit.SECONDS.sleep(10);
            return 100;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(foo);
        Integer r = future.get();
        System.out.println(r);
    }
}

