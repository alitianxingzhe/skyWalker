package node15;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hy
 * @create 2022-05-01 11:00
 * @description 验证tryLock方法
 * 使用tryLock进行尝试锁定，不管锁定与否，方法都将继续执行
 * 也可以指定tryLock的时间，由于tryLock(time)抛出异常，所以要注意unclock的处理，必须放到finally中
 */
public class ReentrantLockTest3 {
    private Lock lock = new ReentrantLock();

    void m1(){
        try {
            lock.lock();
            for (int i = 0; i < 5 ; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("m1 ===>>>" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    void m2(){
        boolean locked = false;
        locked = lock.tryLock();
        System.out.println("尝试加锁" + locked);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (locked){
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest3 reentrantLockTest3 = new ReentrantLockTest3();

        new Thread(reentrantLockTest3::m1,"t1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(reentrantLockTest3::m2,"t2").start();

    }
}
