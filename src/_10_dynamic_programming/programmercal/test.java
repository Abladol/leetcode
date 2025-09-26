package _10_dynamic_programming.programmercal;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] size = {2, 2, 2};  // 目标维度

        ArrayList<Object> reshapedArray = reshapeArray(array, size);
        System.out.println("Reshaped array: " + reshapedArray);
    }

    public static ArrayList<Object> reshapeArray(int[] array, int[] size) {
        // 计算元素总数
        int totalElements = calculateTotalElements(size);

        // 确保元素总数匹配
        if (array.length != totalElements) {
            throw new IllegalArgumentException("数组元素总数与目标维度不匹配");
        }

        // 递归生成多维数组
        ArrayList<Object> result = new ArrayList<>();
        reshape(array, size, 0, result);
        return result;
    }

    private static int calculateTotalElements(int[] size) {
        int product = 1;
        for (int dim : size) {
            product *= dim;
        }
        return product;
    }

    private static void reshape(int[] array, int[] size, int index, ArrayList<Object> result) {
        if (index == size.length) {
            // 已经到达最后一层，无需进一步处理
            return;
        }
        int currentDim = size[index];
        ArrayList<Object> currentLayer = new ArrayList<>();

        for (int i = 0; i < currentDim; i++) {
            if (index == size.length - 1) {
                // 最后一层，直接分割数组
                currentLayer.add(Arrays.copyOfRange(array, i * size[size.length - 1], (i + 1) * size[size.length - 1]));
            } else {
                // 继续递归处理下一层
                ArrayList<Object> nextLayer = new ArrayList<>();
                reshape(array, size, index + 1, nextLayer);
                currentLayer.add(nextLayer);
            }
        }

        result.addAll(currentLayer);
    }
}
