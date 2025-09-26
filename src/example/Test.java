package example;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * <p>
 * Last Modified:
 * @date 2025/2/24 19:51
 */
public class Test {
    private static final Object lock = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 is waiting...");
                    lock.wait();  // 释放锁并等待通知
                    System.out.println("Thread 1 resumed.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 is notifying...");
                lock2.notifyAll();  // 唤醒正在等待的线程
            }
        });

        t1.start();
        Thread.sleep(1000);  // 确保 t1 线程先开始等待
        t2.start();
    }
}

