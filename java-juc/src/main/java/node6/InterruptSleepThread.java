package node6;

/**
 * @author hy
 * @create 2022-04-04 10:13
 * @description
 */
public class InterruptSleepThread {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA  = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadA begin sleep for 200s");
                    Thread.sleep(200000);
                    System.out.println("threadA wakeup");
                } catch (InterruptedException e) {
                    System.out.println("threadA is interrupted while sleep");
                    return;
                }
                System.out.println("threadA leaving normally");
            }
        });
        threadA.start();
        //休眠主线程，确保子线程进入休眠状态
        Thread.sleep(1000);
        //中止子线程，让子线程返回
        threadA.interrupt();
        //等待子线程执行完毕
        threadA.join();
        System.out.println("main thread is over");
    }
}
