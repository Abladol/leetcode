package example.thread_communication;

import java.time.LocalTime;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.CyclicBarrier;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 屏障的演示
 * <p>
 * Last Modified:
 * @date 2025/2/28 13:41
 */

public class BarrierExample {

    // 创建一个屏障，屏障等待的线程数是3
    private static CyclicBarrier barrier = new CyclicBarrier(3, () -> {
        // 当所有线程到达屏障时，执行的操作
        System.out.println("所有线程都到达了屏障，继续执行后续操作...");
    });

    public static void main(String[] args) {
        // 启动3个线程
        for (int i = 0; i < 3; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("线程 " + threadId + " 开始工作...时间是："+ LocalTime.now());
                    Thread.sleep((int)(Math.random()*10000)); // 模拟工作
                    System.out.println("线程 " + threadId + " 到达屏障,时间是："+LocalTime.now());
                    barrier.await(); // 等待其他线程到达屏障
                    System.out.println("线程 " + threadId + " 继续执行...时间是"+LocalTime.now());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}


