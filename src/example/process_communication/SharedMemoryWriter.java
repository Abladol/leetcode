package example.process_communication;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * <p>
 * Last Modified:
 * @date 2025/2/24 15:11
 */
import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class SharedMemoryWriter {
    public static void main(String[] args) throws IOException {
        String fileName = "shared_memory.dat";

        // 创建文件通道
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel channel = file.getChannel();

        // 映射文件到内存
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);

        // 写入数据
        buffer.put(0, (byte) 43);  // 进程1写入数据

        System.out.println("Data written to shared memory");

        // 关闭文件
        channel.close();
        file.close();
    }
}

