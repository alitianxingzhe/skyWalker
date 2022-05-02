package node17;

import java.util.concurrent.CountDownLatch;

/**
 * @author hy
 * @create 2022-05-02 09:27
 * @description
 */
public class CountDownLatchJoin3 {
    public static void main(String[] args) {
        useJoin();
        useCountDownLatch();
    }

    private static void useCountDownLatch() {
        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 10000; j++) {
                    result += j;
                }
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end latch");


    }

    private static void useJoin() {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
           threads[i] =  new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 10000; j++) {
                    result += j;
                }
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("end join");


    }


}
