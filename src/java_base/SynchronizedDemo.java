package java_base;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: synchronized的例子
 * <p>
 * Last Modified:
 * @date 2025/9/27 18:54
 */
public class SynchronizedDemo {

    public synchronized static void print1() throws InterruptedException {
        System.out.println("锁住的静态方法");
        Thread.sleep(1000);
    }

    public synchronized  void print2() throws InterruptedException {
        System.out.println("锁住的普通方法1");
        Thread.sleep(1000);
    }

    public synchronized void print3(){
        System.out.println("锁住的普通方法2");
    }

    public void print4(){
        System.out.println("没有被锁住的普通方法");
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                20,60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(20));

        SynchronizedDemo demo = new SynchronizedDemo();
        FutureTask<Void> task1 = new FutureTask<>(()->{
            for (int i = 0; i < 10; i++) {
                SynchronizedDemo.print1();
            }
            return null;
        });

        FutureTask<Void> task2 = new FutureTask<>(()->{
            for (int i = 0; i < 10; i++) {
                demo.print2();
            }
            return null;
        });

        FutureTask<Void> task3 = new FutureTask<>(()->{
            for (int i = 0; i < 10; i++) {
                demo.print3();
            }
            return null;
        });

        FutureTask<Void> task4 = new FutureTask<>(()->{
            for (int i = 0; i < 10; i++) {
                demo.print4();
            }
            return null;
        });

        executor.submit(task1);
//        executor.submit(task2);
        executor.submit(task3);
//        executor.submit(task4);
    }
}

