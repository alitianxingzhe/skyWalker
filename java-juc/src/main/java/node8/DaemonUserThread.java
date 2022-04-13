package node8;

/**
 * @author hy
 * @create 2022-04-04 10:54
 * @description
 */
public class DaemonUserThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){

                }
            }
        });
        thread.setDaemon(true);
        //启动子线程
        thread.start();
        System.out.println("main thread is over");
    }
}
