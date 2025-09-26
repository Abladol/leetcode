package example.process_communication;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * <p>
 * Last Modified:
 * @date 2025/2/24 14:57
 */
import java.io.*;

public class PipeCommunicationExample {

    public static void main(String[] args) throws IOException {
        // 创建管道输入输出流
        PipedInputStream parentInput = new PipedInputStream();
        PipedOutputStream parentOutput = new PipedOutputStream();

        // 将父进程的输出流与输入流连接
        parentInput.connect(parentOutput);

        // 启动子进程线程
        Thread childProcess = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 子进程从父进程的管道中读取数据
                    BufferedReader reader = new BufferedReader(new InputStreamReader(parentInput));
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("子进程接收到数据: " + message);
                    }
                    reader.close();
                    parentInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        childProcess.start();

        // 父进程向管道写入数据
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(parentOutput))) {
            writer.write("Hello from the parent process!\n");
            writer.write("This is another message from parent.\n");
            writer.flush();  // 确保数据写入管道
        }

        // 关闭父进程的写入端
        parentOutput.close();

        try {
            // 等待子进程执行完毕
            childProcess.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

