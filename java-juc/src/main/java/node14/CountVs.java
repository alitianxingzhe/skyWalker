package node14;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author hy
 * @create 2022-04-23 23:46
 * @description
 */
public class CountVs {
    private  static int count = 0;
    private static AtomicLong atomicCount = new AtomicLong();
    private  static LongAdder adderCount = new LongAdder();

    public static void main(String[] args) {
        Object obj = new Object();
        long start = System.currentTimeMillis();
        List<Thread> threadList = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            threadList.add(new Thread(() ->{
                synchronized (obj){
                    for (int j = 0; j < 10000; j++) {
                        count++;
                    }
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
        long end = System.currentTimeMillis();
        System.out.println("synchronized count :" + count +"===耗时：" +(end-start));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //=========
        long start1 = System.currentTimeMillis();
        List<Thread> threadList1 = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            threadList1.add(new Thread(() ->{
                for (int j = 0; j < 10000; j++) {
                    atomicCount.incrementAndGet();
                }

            }));
        }
        for (Thread thread : threadList1) {
            thread.start();
        }
        for (Thread thread : threadList1) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end1 = System.currentTimeMillis();
        System.out.println("AtomicLong count :" + atomicCount.get() +"===耗时：" +(end1-start1));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //=========
        long start2 = System.currentTimeMillis();
        List<Thread> threadList2 = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            threadList2.add(new Thread(() ->{
                for (int j = 0; j < 10000; j++) {
                    adderCount.increment();
                }
            }));
        }
        for (Thread thread : threadList2) {
            thread.start();
        }
        for (Thread thread : threadList2) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end2 = System.currentTimeMillis();
        System.out.println("LongAdder count :" + adderCount.longValue() +"===耗时：" +(end2-start2));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
