package node11;

import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-04-20 08:00
 * @description 同步方法和非同步方法是否能一起调用
 */
public class MethodUseTest {

    synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end...");

    }

    void m2(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end...");
    }


    public static void main(String[] args) {
        MethodUseTest methodUseTest = new MethodUseTest();

        new Thread(methodUseTest::m1,"t1").start();
        new Thread(methodUseTest::m2,"t2").start();


    }
}
