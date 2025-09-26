package example.multi_thread;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 继承Thread实现多线程
 * <p>
 * Last Modified:
 * @date 2025/2/17 14:36
 */
public class MyThread extends Thread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();  // 启动新线程
        myThread.oldId();  // 在新线程执行完之后调用
        //还有一种方法启用新线程
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2:"+Thread.currentThread().getId());
            }
        });
        thread2.start();
    }

    @Override
    public void run() {
        long id = Thread.currentThread().getId();
        System.out.println("new thread:" + id);
    }

    public void oldId() {
        long id = Thread.currentThread().getId();
        System.out.println("old thread:" + id);
    }
}
