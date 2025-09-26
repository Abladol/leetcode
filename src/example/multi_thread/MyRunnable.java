package example.multi_thread;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * <p>
 * Last Modified:
 * @date 2025/2/17 14:47
 */
public class MyRunnable implements Runnable{
    public void oldId(){
        System.out.println("old id:"+Thread.currentThread().getId());
    }
    @Override
    public void run() {
        System.out.println("new id :"+Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.oldId();
        Thread thread = new Thread(myRunnable);
        thread.start();
        //还有一种方法启用新线程
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2:"+Thread.currentThread().getId());
            }
        });
        thread2.start();
    }
}

