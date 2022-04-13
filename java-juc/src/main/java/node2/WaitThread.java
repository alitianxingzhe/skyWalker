package node2;

/**
 * @author hy
 * @create 2022-04-02 22:28
 * @description
 */
public class WaitThread {
    public static volatile Object resourceA = new Object();

    public static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程A
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                try {
                    //获取resourceA的监视器锁
                    synchronized (resourceA){
                        System.out.println("threadA get resourceA lock");
                        //获取resourceB的监视器锁
                        synchronized (resourceB){
                            System.out.println("threadA get resourceB lock");

                            //线程A阻塞，释放获取到的resourceA锁
                            System.out.println("threadA release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //创建线程B
        Thread threadB= new Thread(new Runnable() {
            public void run() {
                //休眠1s
                try {
                    Thread.sleep(1000);
                    //获取resourceA的监视器锁
                    synchronized (resourceA){
                        System.out.println("threadB get resourceA lock");
                        System.out.println("threadB try get resourceB lock");
                        //获取resourceB的监视器锁
                        synchronized (resourceB){
                            System.out.println("threadB get resourceB lock");

                            //线程B阻塞，释放获取到的resourceA锁
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //启动线程
        threadA.start();
        threadB.start();
        //等待线程结束
        threadA.join();
        threadB.join();
        System.out.println("main thread over");

    }
}
