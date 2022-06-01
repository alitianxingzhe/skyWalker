package TemplateMethod;

/**
 * @description:
 * @author: hy (huyong@bsoft.com.cn)
 * @create: 2022/5/12
 * @since
 * 需求： 实现买票回家过年的逻辑
 * 问题： 回家不是坐车而是飞机，高铁呢
 * DRY原则：DRY（Don't Repeat Yourself，不要复制自己）
 */
public class HappyYear {

    public void happyNewYear(){
        //买票
        System.out.println("买票");

        //坐车回家
        System.out.println("坐车回家");

        //欢庆新年
        System.out.println("欢庆新年");
    }

    public void happyNewYear1(){
        //买票
        System.out.println("买票");

        //坐车回家
        System.out.println("坐高铁回家");

        //欢庆新年
        System.out.println("欢庆新年");
    }

    public void happyNewYear2(){
        //买票
        System.out.println("买票");

        //坐车回家
        System.out.println("坐飞机回家");

        //欢庆新年
        System.out.println("欢庆新年");
    }
}
