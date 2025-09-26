package example.design_mode.prototype_mode;

import java.time.LocalTime;
import java.util.Objects;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * <p>
 * Last Modified:
 * @date 2025/2/21 12:07
 */
public class A implements Cloneable {
    int x;
    int y;

    public A(int x, int y) throws InterruptedException {
        Thread.sleep(100);
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "A{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return x == a.x && y == a.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public A clone() {
        try {
            A clone = (A) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long pre = System.currentTimeMillis();
        A obj = new A(3, 4);
        System.out.println(System.currentTimeMillis()-pre);
        pre = System.currentTimeMillis();
        A newA = obj.clone();
        System.out.println(System.currentTimeMillis()-pre);
        System.out.println(obj);
        System.out.println(newA);
        System.out.println(obj==newA);
    }

}

