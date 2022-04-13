package node8;

/**
 * @author hy
 * @create 2022-04-04 10:53
 * @description
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });
        //设置线程为守护线程
        thread.setDaemon(true);
        thread.start();
    }
}
