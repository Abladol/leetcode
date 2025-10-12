import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: arraylist.of的注意：这是一个浅拷贝
 * <p>
 * Last Modified:
 * @date 2025/9/26 20:32
 */
public class ArrayListOfDemo {
    public static void main(String[] args) {
        String[] list1 = new String[10];
        for (int i = 0; i < 10; i++) {
            list1[i]=" "+i;
        }

        List<String> list2 = Arrays.asList(list1);
        System.out.println("list2"+ list2);
        System.out.println("list1"+ Arrays.toString(list1));

        list1[0] = "123";
        System.out.println("list2"+ list2);
        System.out.println("list1"+ Arrays.toString(list1));

    }
}

