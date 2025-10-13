package java_base;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * <p>
 * Last Modified:
 * @date 2025/9/29 19:20
 */
public class ThreadJoin {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(1);
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
                System.out.println(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t3 = new Thread(()->{
            try {
                t2.join();
                System.out.println(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        t3.start();
        t2.start();
        t1.start();

    }
}

