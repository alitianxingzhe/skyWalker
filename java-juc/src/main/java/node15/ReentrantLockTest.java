package node15;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hy
 * @create 2022-05-01 10:47
 * @description
 */
public class ReentrantLockTest {
    private ReentrantLock lock = new ReentrantLock();

    void m1(){
        lock.lock();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("m1 ===>>>" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }

    void m2(){
        lock.lock();
        try {
            System.out.println("m2 start");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //使用ReentrantLock来实现和synchronized一样的功能
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        new Thread(reentrantLockTest::m1,"t1").start();
        new Thread(reentrantLockTest::m2,"t2").start();
    }
}
