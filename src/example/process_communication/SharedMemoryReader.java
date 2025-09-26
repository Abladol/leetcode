package example.process_communication;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * <p>
 * Last Modified:
 * @date 2025/2/24 15:13
 */
import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class SharedMemoryReader {
    public static void main(String[] args) throws IOException {
        String fileName = "shared_memory.dat";

        // 打开文件通道
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel channel = file.getChannel();

        // 映射文件到内存
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);

        // 读取数据
        byte data = buffer.get(0);  // 进程2读取数据
        System.out.println("Read data from shared memory: " + data);

        // 关闭文件
        channel.close();
        file.close();
    }
}


