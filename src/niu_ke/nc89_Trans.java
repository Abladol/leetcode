package niu_ke;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 对于一个长度为 n 字符串，我们需要对它做一些变形。
 * 首先这个字符串中包含着一些空格，就像"Hello World"一样，然后我们要做的是把这个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。
 * 比如"Hello World"变形后就变成了"wORLD hELLO"。
 * <p>
 * Last Modified:
 * @date 2025/10/14 16:58
 */
public class nc89_Trans {
    public String trans(String s, int n) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                temp.append(' ');
                sb.insert(0,temp);
                temp.delete(0, temp.length());
            } else {
                char c = s.charAt(i);
                if (c - 'a' < 0) {
                    temp.append(Character.toLowerCase(c));
                } else {
                    temp.append(Character.toUpperCase(c));
                }
            }
        }
        temp.append(' ');
        sb.insert(0,temp);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        nc89_Trans trans = new nc89_Trans();
        System.out.println(trans.trans("This is a sample", 16));
    }
}

