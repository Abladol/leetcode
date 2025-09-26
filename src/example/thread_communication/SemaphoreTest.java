package example.thread_communication;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:信号量的一个测试
 * <p>
 * Last Modified:
 * @date 2025/2/28 12:20
 */
public class SemaphoreTest {
    //    private Semaphore semaphore = new Semaphore();
    private volatile static AtomicInteger num = new AtomicInteger(0);
    private static Semaphore semaphore = new Semaphore(3);


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                boolean b = semaphore.tryAcquire();
                if(b) {
                    num.addAndGet(1);
                    System.out.println("线程" + num.get());
                }
            }).start();
//            semaphore.release();
        }
    }
}

