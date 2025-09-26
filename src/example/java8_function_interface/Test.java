package example.java8_function_interface;

import java.util.function.Supplier;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 函数式接口测试案例
 * <p>
 * Last Modified:
 * @date 2025/2/13 21:06
 */
public class Test {
    public static void main(String[] args) {
        Sout sout = () -> System.out.println("函数式接口测试");
        Supplier<String> supplier = () -> "测试2";
        sout.pprint();
        System.out.println(supplier.get());
    }
}

