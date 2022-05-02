package node15;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hy
 * @create 2022-05-01 16:48
 * @description
 */
public class ReentrantLockTest5 {
    //参数为true表示为公平锁
    private static ReentrantLock lock = new ReentrantLock(true);


    void m1(){
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        ReentrantLockTest5 lockTest5 = new ReentrantLockTest5();
        new Thread(lockTest5::m1,"t1").start();
        new Thread(lockTest5::m1,"t2").start();
    }

}
