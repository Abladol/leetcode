package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: Hoare分区快排
 * <p>
 * Last Modified:
 * @date 2025/9/17 14:45
 */
public class QuickSortOfHoare {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 7, 33, 4, 7, 23, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = partition(arr, l, r);
        quickSort(arr, l, mid - 1);
        quickSort(arr, mid + 1, r);

    }

    private static int partition(int[] arr, int l, int r) {
        int normIndex = new Random().nextInt(r - l + 1) + l;
        swap(arr, l, normIndex);
        int norm = arr[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && arr[j] >= norm) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= norm) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = norm;
        return i;
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


}

