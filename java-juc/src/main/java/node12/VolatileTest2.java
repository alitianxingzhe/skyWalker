package node12;

import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-04-20 23:44
 * @description VolatileTest修饰引用数据类型
 */
public class VolatileTest2 {
    private boolean running = true;

    //volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
    volatile static VolatileTest2 TEST = new VolatileTest2();


    void m(){
        System.out.println("m start");
        while (running){

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new Thread(TEST::m,"thread").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TEST.running = false;
    }

}
