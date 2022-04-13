package node4;

/**
 * @author hy
 * @create 2022-04-04 09:27
 * @description
 */
public class SleepInterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread is sleep");
                    Thread.sleep(10000);
                    //Thread.sleep(-1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //启动子线程
        thread.start();
        //主线程休眠
        Thread.sleep(2000);
        //主线程中止子线程
        thread.interrupt();
    }

}
