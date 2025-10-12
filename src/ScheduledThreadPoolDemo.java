import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: ScheduledThreadPool
 * <p>
 * Last Modified:
 * @date 2025/9/27 19:58
 */
public class ScheduledThreadPoolDemo {


    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10, new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r,"test-"+threadNumber.addAndGet(1));
                t.setDaemon(false);
                return t;
            }
        });

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        executor.scheduleAtFixedRate(task,1,1, TimeUnit.SECONDS);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

