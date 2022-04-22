package node11;

import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-04-20 22:05
 * @description
 */
public class SynchronizedTest1 {
    synchronized void m1(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 over");
    }

    synchronized void m2(){
        System.out.println("m2 over");
    }


    //一个同步方法可以调用另一个同步方法，一个线程拥有一个对象的锁再次申请时依然会获取对象的锁，synchronized获得的锁是可重入的
    public static void main(String[] args) {
        SynchronizedTest1 test1 = new SynchronizedTest1();
        test1.m1();
    }
}
