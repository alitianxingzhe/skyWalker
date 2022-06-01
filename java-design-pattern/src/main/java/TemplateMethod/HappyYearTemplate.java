package TemplateMethod;

/**
 * @description:
 * @author: hy (huyong@bsoft.com.cn)
 * @create: 2022/5/12
 * @since juc
 */
public  abstract  class HappyYearTemplate {
    public void happyNewYear(){
        //买票
        buyTickets();
        //坐车回家
        travelHome();
        //欢庆新年
        happy();
    }
    protected abstract void travelHome();

    //提取公共方法到父类中，并避免子类重写
    protected final void happy() {
        System.out.println("欢庆新年");
    }

    //提取公共方法到父类中，并避免子类重写
    protected final void buyTickets() {
        System.out.println("买票");
    }
}

class CarHappyYear extends HappyYearTemplate{
    @Override
    protected void travelHome() {
        System.out.println("坐汽车回家");
    }
}
class AirHappyYear extends HappyYearTemplate{
    @Override
    protected void travelHome() {
        System.out.println("坐飞机回家");
    }

    public static void main(String[] args) {
        //测试
        HappyYearTemplate car = new CarHappyYear();
        HappyYearTemplate air = new AirHappyYear();
        car.happyNewYear();
        air.happyNewYear();
    }
}
