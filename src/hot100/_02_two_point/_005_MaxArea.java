package hot100._02_two_point;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。  找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。  返回容器可以储存的最大水量。  说明：你不能倾斜容器。
 * <p>
 * Last Modified:
 * @date 2024/12/11 15:17
 */
public class _005_MaxArea {
    /**
     * 双指针法：
     * 木桶效应：会存在一个短板，需要做的就是更换这个短板也就是找到一个距离最近的长一点的板子，但这并不能保证容积一定会变大，还需要比较
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxRes = 0;
        while (left < right) {
            int v = (right - left) * Math.min(height[left], height[right]);
            maxRes = v > maxRes ? v : maxRes;
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxRes;
    }

    public static void main(String[] args) {
        _005_MaxArea maxArea = new _005_MaxArea();
        System.out.println(maxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

