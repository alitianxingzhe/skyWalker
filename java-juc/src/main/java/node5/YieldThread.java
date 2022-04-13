package node5;

/**
 * @author hy
 * @create 2022-04-04 09:33
 * @description
 */
public class YieldThread implements Runnable{
    public YieldThread() {
        //创建线程
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //当i=0时，让出cpu执行权，放弃时间片，进行下一轮调度
            if ((i % 5) == 0){
                System.out.println(Thread.currentThread() + "yield cpu ...");
                //Thread.yield();
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + "is over ");
    }

    public static void main(String[] args) {
        new YieldThread();
        new YieldThread();
        new YieldThread();
    }
}
