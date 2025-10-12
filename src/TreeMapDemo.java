import java.util.Map;
import java.util.TreeMap;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: treemap的demo
 * <p>
 * Last Modified:
 * @date 2025/9/26 20:45
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        Map<String,String> treeMap = new TreeMap<>();
        for (int i = 25; i > 0; i--) {
            treeMap.put(Integer.toString(i),Character.toString('a'+i));
        }
        treeMap.forEach((k,v)->{
            System.out.println(k+v);
        });
    }
}

