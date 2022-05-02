package node17;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-04-30 18:11
 * @description CountDownLatch的使用
 * CountDownLatch对比join区别
 * 1、调用子线程的join方法后，该线程会一直阻塞到子线程执行完毕；
 * CountDownLatch可以在子线程中任何时候让await方法结束，不一定等到线程结束
 * 2、CountDownLatch让我们对线程有着更好的控制。
 */
public class CountDownLatchJoin {
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {
        Thread t1 = new Thread( () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("t1 is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        });
        Thread t2 = new Thread( () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        });
        t1.start();
        t2.start();
        System.out.println("wait all child thread over");
        //等待所有子线程执行完毕
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all child thread over");
    }
}
