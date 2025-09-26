package example.design_mode.template_mode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 具体实现方法
 * <p>
 * Last Modified:
 * @date 2025/2/11 11:13
 */
public class MethodImpl extends AbstractTemplate{

    @Override
    public void step3() {
        System.out.println("子类自定义的步骤3");
    }

    @Override
    public void step2() {
        System.out.println("这是子类修改后的步骤2");
    }

    public static void main(String[] args) {
        MethodImpl method = new MethodImpl();
        method.run();
    }

    @Override
    public void finalStep() {
        System.out.println("接口中定义的，抽象类没有实现，子类必须实现的最后步骤");
    }
}

