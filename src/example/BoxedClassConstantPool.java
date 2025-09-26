package example;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:常量池
 * <p>
 * Last Modified:
 * @date 2025/2/19 13:08
 */
public class BoxedClassConstantPool {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(100);  // 使用缓存
        Integer b = Integer.valueOf(100);
        System.out.println(a == b); // 输出 true
    }
}

