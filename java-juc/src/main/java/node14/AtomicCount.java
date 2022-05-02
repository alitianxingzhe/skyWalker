package node14;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author hy
 * @create 2022-04-23 23:06
 * @description atomic统计
 */
public class AtomicCount {
    private static AtomicLong atomicLong = new AtomicLong();

    //创建数据源
    private static Integer[] arrayOne = new Integer[]{0,1,2,3,0,5,6,7,0,9,0};
    private static Integer[] arrayTwo = new Integer[]{10,1,0,3,0,0,6,7,0,9,0};

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int size = arrayOne.length;
            for (int i = 0; i < size; i++) {
                if (arrayOne[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            int size = arrayTwo.length;
            for (int i = 0; i < size; i++) {
                if (arrayTwo[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("count :" + atomicLong.get());
    }



}
