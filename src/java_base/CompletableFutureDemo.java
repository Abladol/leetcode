package java_base;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: CompletableFuture的示例
 * <p>
 * Last Modified:
 * @date 2025/9/26 16:37
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException {


        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("test1");
            return "test1";
        }, executor);

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("test2");
            return "test2";
        }, executor);

        CompletableFuture<String> cf3 = cf1.thenCombine(cf2, (result1, result2) -> {
            String combined = result1 + " and " + result2 + " done, test3";
            System.out.println("【test3】合并完成：" + combined);
            return combined;
        });

        cf3.join();

    }
}

