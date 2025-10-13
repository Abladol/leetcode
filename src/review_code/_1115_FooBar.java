package review_code;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * <p>
 * Last Modified:
 * @date 2025/9/4 16:07
 */
class _1115_FooBar {

    private int n;
    private volatile boolean flag = true;
    ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();

    public _1115_FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {


        for (int i = 0; i < n; i++) {
            try{
                lock.lock();
                while (!flag) fooCondition.await();
                printFoo.run();
                flag = false;
                barCondition.signal();
            }finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (flag) barCondition.await();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = true;
                fooCondition.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}