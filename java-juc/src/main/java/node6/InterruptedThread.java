package node6;

/**
 * @author hy
 * @create 2022-04-04 10:06
 * @description
 */
public class InterruptedThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //如果当前线程中断则退出循环
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread() + "hello");
                }
            }
        });
        thread.start();
        //主线程休眠
        Thread.sleep(1000);
        //中断子线程
        System.out.println("main thread interrupt thread");
        thread.interrupt();
        //等待子线程执行完毕
        thread.join();
        System.out.println("main thread is over");
    }
}
