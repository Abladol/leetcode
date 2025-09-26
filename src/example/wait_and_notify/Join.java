package example.wait_and_notify;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: wait和notify的使用
 * <p>
 * Last Modified:
 * @date 2025/2/16 14:58
 */
public class Join {
    public static void main(String[] args) {
        Thread t1= new Thread(()->{
            System.out.println("t1 is run");
        });
        Thread t2= new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2 is run");
        });
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t3 is run");
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

