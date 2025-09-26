package example.multi_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * <p>
 * Last Modified:
 * @date 2025/2/17 14:54
 */
public class Executor {
    public static void main(String[] args) throws InterruptedException {
        //创建的是单线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1:" + Thread.currentThread().getId());
            }
        });
        executorService.shutdown();//关闭


        //创建多线程,里面有三个线程
        ExecutorService executorService2 = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> runnableList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            runnableList.add(new Callable() {
                @Override
                public Object call() throws Exception {
                    System.out.println("thread:" + Thread.currentThread().getId());
                    return Thread.currentThread().getId();
                }
            });
        }
        executorService2.invokeAll(runnableList);
    }
}

