package _04_string.programmercal;

import java.util.Scanner;

public class _05_RightHandedString {
    public static String RightHandedString(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        sb.insert(0, sb.substring(s.length() - k, s.length()).toCharArray());
        sb.delete(s.length(), sb.length());
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String s = scanner.next();
        System.out.println(RightHandedString(s, k));
    }
}
