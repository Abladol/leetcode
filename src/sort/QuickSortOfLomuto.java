package sort;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 快速排序
 * <p>
 * Last Modified:
 * @date 2025/9/15 15:16
 */
public class QuickSortOfLomuto {

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = sort(arr, l, r);
        quickSort(arr, l, mid - 1);
        quickSort(arr, mid + 1, r);
    }

    //左闭右闭
    public static int sort(int[] arr, int l, int r) {
        int norm = arr[l];
        //左区间的右边界
        int left = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < norm) {
                left++;
                swap(arr, i, left);
            }
        }

        swap(arr, l, left);
        return left;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 2, 5, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // 输出: [0, 2, 3, 4, 5, 7]
    }
}

