package node4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hy
 * @create 2022-04-04 09:21
 * @description
 */
public class SleepThread {
    //创建一个独占锁
    private final static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadA is in sleep");
                    Thread.sleep(10000);
                    System.out.println("threadA is in wakeup");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadB is in sleep");
                    Thread.sleep(10000);
                    System.out.println("threadB is in wakeup");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
