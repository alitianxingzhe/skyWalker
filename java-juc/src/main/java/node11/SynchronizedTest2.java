package node11;

import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-04-20 22:20
 * @description 一个同步方法可以调用另一个同步方法
 */
public class SynchronizedTest2 {

    synchronized void m(){
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new SynchronizedTest3().m();
    }
}
class SynchronizedTest3 extends SynchronizedTest2{
    @Override
    synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");

    }
}
