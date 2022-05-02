package node15;

import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-05-01 10:41
 * @description
 */
public class ReentrantLockSync {

    synchronized void print(){
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 5){
                print2();
            }
        }
    }

    synchronized void print2(){
        System.out.println("print2 is start");
    }

    public static void main(String[] args) {
        //回顾synchronized基础知识 可重入锁，锁对象
        ReentrantLockSync sync = new ReentrantLockSync();
        new Thread(sync::print,"t1").start();
        new Thread(sync::print2,"t2").start();
    }
}
