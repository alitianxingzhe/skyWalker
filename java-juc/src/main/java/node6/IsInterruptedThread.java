package node6;

/**
 * @author hy
 * @create 2022-04-04 10:34
 * @description
 */
public class IsInterruptedThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //中断标志为true时退出循环，并清除中断标志
                while (!Thread.currentThread().interrupted()){

                }
                System.out.println("thread is interrupted:"+Thread.currentThread().isInterrupted());
            }
        });
        thread.start();
        thread.interrupt();
        thread.join();
        System.out.println("main thread is over");
    }
}
