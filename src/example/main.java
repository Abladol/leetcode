package example;

public class main {
    private int[] timestamps;
    private int[] hits;

    public main() {
        timestamps = new int[300];
        hits = new int[300];
    }

    /**
     * 记录一次敲击事件
     * @param timestamp 当前时间戳（单位：秒）
     */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (timestamps[index] != timestamp) {
            // 当时间戳过期时重置计数
            timestamps[index] = timestamp;
            hits[index] = 1;
        } else {
            // 相同时间戳的重复敲击
            hits[index]++;
        }
    }

    /**
     * 获取过去5分钟（300秒）内的敲击次数
     * @param timestamp 当前时间戳（单位：秒）
     * @return 有效敲击次数
     */
    public int getHits(int timestamp) {
        int total = 0;
        int windowStart = timestamp - 300;
        for (int i = 0; i < 300; i++) {
            // 仅统计在时间窗口内的记录
            if (timestamps[i] > windowStart) {
                total += hits[i];
            }
        }
        return total;
    }
}