package node6;

/**
 * @author hy
 * @create 2022-04-04 10:19
 * @description interrupted和isInterrupted的不同
 */
public class IsInterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                }
            }
        });
        threadA.start();
        //设置中断标志
        threadA.interrupt();
        //获取中断标志
        System.out.println("isInterrupted" + threadA.isInterrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted" + threadA.interrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted" + Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted" + threadA.isInterrupted());
        threadA.join();
        System.out.println("main thread is over");
    }
}
