package example.multi_thread;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * <p>
 * Last Modified:
 * @date 2025/2/17 15:08
 */
public class MyCallable implements Callable {
        @Override
    public Object call() throws Exception {
        return Thread.currentThread().getId();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> task = new FutureTask<>(myCallable);
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("old:"+Thread.currentThread().getId());
        System.out.println("thread:"+task.get());
    }
}

