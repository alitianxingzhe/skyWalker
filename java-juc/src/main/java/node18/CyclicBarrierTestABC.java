package node18;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hy
 * @create 2022-04-30 18:59
 * @description 多个线程执行任务，任务由阶段A、B、C组成
 * 所有线程执行完A后才能执行B，然后才能执行C
 */
public class CyclicBarrierTestABC {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args)  throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "start A");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "start B");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "start C");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "start A");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "start B");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "start C");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.shutdown();


    }



}
