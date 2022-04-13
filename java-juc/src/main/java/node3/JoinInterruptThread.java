package node3;

/**
 * @author hy
 * @create 2022-04-03 16:36
 * @description
 */
public class JoinInterruptThread {

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadA begin run");
                for (;;){

                }
            }
        });
        //获取主线程
        final Thread mainThread = Thread.currentThread();
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //中断主线程
                mainThread.interrupt();
            }
        });
        //启动子线程
        threadA.start();
        threadB.start();
        try {
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
