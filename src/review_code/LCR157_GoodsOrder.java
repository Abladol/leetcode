package review_code;

import javax.management.MBeanAttributeInfo;
import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 套餐内商品的排列顺序,某店铺将用于组成套餐的商品记作字符串 goods，其中 goods[i] 表示对应商品。请返回该套餐内所含商品的 全部排列方式 。
 * 返回结果 无顺序要求，但不能含有重复的元素。
 * <p>
 * Last Modified:
 * @date 2025/10/13 20:34
 */
public class LCR157_GoodsOrder {
    private boolean[] visited;
    private StringBuilder temp = new StringBuilder();
    private Set<String> res = new HashSet<>();

    public String[] goodsOrder(String goods) {
        visited = new boolean[goods.length()];
        char[] chs = goods.toCharArray();
        Arrays.sort(chs);
        retrace(new String(chs));
        String[] result = new String[res.size()];
        return res.toArray(new String[0]);
    }

    public void retrace(String goods) {
        if (temp.length() == goods.length()) {
            res.add(temp.toString());
            return;
        }
        for (int i = 0; i < goods.length(); i++) {
            if (!visited[i]) {
                temp.append(goods.charAt(i));
                visited[i] = true;
                retrace(goods);
                temp.deleteCharAt(temp.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        LCR157_GoodsOrder goodsOrder = new LCR157_GoodsOrder();
        String[] goods = goodsOrder.goodsOrder("aab");
        System.out.println(Arrays.toString(goods));

    }
}

