package example.design_mode.prototype_mode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * <p>
 * Last Modified:
 * @date 2025/2/21 15:51
 */
public class Example {
    public static void main(String[] args) {
        System.out.println(testMethod());
    }

    public static String testMethod() {
        try {
            System.out.println("In try block");
            return "Returned from try";
        } catch (Exception e) {
            System.out.println("In catch block");
            return "Returned from catch";
        } finally {
            System.out.println("In finally block");
            return "shuih";
        }
    }
}

