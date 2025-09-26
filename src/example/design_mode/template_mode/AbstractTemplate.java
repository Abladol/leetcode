package example.design_mode.template_mode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 抽象模板类
 * <p>
 * Last Modified:
 * @date 2025/2/11 11:10
 */
abstract public class AbstractTemplate implements Method{
    //预先必须实现的步骤，直接设置为私有，子类不可以更改，当然也可是设置为可以更改的公有
    private  void step1(){
        System.out.println("这是第一步，必须实现,子类无法更改");
    }
    public void step2(){
        System.out.println("这是第二步，必须实现，子类可以更改，现在的是抽象类的默认方法");
    }

    public final void run(){
        step1();
        step2();
        step3();
        //这个在抽象类中没写，是因为实现的接口中定义了这个方法，而抽象类可以不实现接口的方法，但是其子类必须实现
        finalStep();
    }



    abstract public void step3();
}

