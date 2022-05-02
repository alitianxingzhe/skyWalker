package node15;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hy
 * @create 2022-05-01 10:54
 * @description 验证ReentrantLock是可重入的
 */
public class ReentrantLockTest2 {
    private Lock lock = new ReentrantLock();

    void m1(){
        try {
            lock.lock();
            for (int i = 0; i < 5 ; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("m1 ===>>>" + i);
                m2();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2(){
        try {
            lock.lock();
            System.out.println("m2 start");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest2 lockTest2 = new ReentrantLockTest2();
        new Thread(lockTest2::m1,"t1").start();
        new Thread(lockTest2::m2,"t2").start();
    }
}
