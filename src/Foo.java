class Foo {
    private int flag = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            // printFirst.run() outputs "first". Do not change or remove this line
            printFirst.run();
            flag++;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (this) {
            while (flag < 1) {
                this.wait();
            }
            printSecond.run();
            flag++;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (this) {
            while (flag < 2) {
                this.wait();
            }
            printThird.run();
        }
    }
}