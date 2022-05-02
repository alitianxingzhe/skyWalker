package node15;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hy
 * @create 2022-05-01 16:25
 * @description
 */
public class ReentrantLockTest4 {
    private Lock lock = new ReentrantLock();

    void m1(){
        try {
            lock.lock();
            System.out.println("t1 start");
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            System.out.println("t1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2(){
        try {
            lock.lockInterruptibly();
            System.out.println("t2 start");
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            System.out.println("t2 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest4 lockTest4 = new ReentrantLockTest4();
        new Thread(lockTest4::m1,"t1").start();
        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread(lockTest4::m2, "t2");
        t2.start();
        TimeUnit.SECONDS.sleep(2);
        t2.interrupt();
    }
}
