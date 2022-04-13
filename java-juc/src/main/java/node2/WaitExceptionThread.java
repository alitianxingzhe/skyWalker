package node2;

/**
 * @author hy
 * @create 2022-04-02 22:46
 * @description
 */
public class WaitExceptionThread {
    public static volatile Object resource = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("---begin---");
                    //阻塞当前线程
                    synchronized (resource){
                        resource.wait();
                    }
                    System.out.println("---end---");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        Thread.sleep(1000);
        System.out.println("---begin threadA");
        threadA.interrupt();
        System.out.println("---end threadA");
    }
}
