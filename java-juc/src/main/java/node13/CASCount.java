package node13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hy
 * @create 2022-04-22 13:11
 * @description
 */
public class CASCount {
    private AtomicInteger atomicCount = new AtomicInteger();

    private int count = 0;

    //非线程安全
    private void countAdd(){
        count++;
    }

    //CAS操作
    private void countSafeAdd(){
        //while (true) {
        //    int i = atomicCount.get();
        //    boolean b = atomicCount.compareAndSet(i, ++i);
        //    if (b){
        //        break;
        //    }
        //}
        atomicCount.incrementAndGet();
    }

    public static void main(String[] args) {
        CASCount casCount = new CASCount();
        List<Thread> threadList = new ArrayList<>(600);
        for (int i = 0; i < 100; i++) {
            threadList.add(new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    casCount.countAdd();
                    casCount.countSafeAdd();
                }
            }));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("no safe:" + casCount.count);
        System.out.println("safe:" + casCount.atomicCount.get());
    }
}
