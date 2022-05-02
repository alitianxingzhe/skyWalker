package node16;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hy
 * @create 2022-05-02 09:15
 * @description
 */
public class ReentrantReadWriteLockTest {
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static int value;
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    static void write(Lock lock,int v){
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("write over!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    static void read(Lock lock){
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over!" + value);
            //模拟读取操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Runnable read  = () -> read(readLock);
        Runnable write  = () -> write(writeLock,new Random().nextInt());
        for (int i = 0; i < 20; i++) {
            //读锁不堵塞
            new Thread(read).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(write).start();
        }

    }


}
