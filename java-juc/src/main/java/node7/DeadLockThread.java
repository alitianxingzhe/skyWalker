package node7;

/**
 * @author hy
 * @create 2022-04-04 10:42
 * @description
 */
public class DeadLockThread {
    //创建资源
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println(Thread.currentThread() + "get resourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "wait get resourceB");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread() + "get resourceB");
                    }

                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB){
                    System.out.println(Thread.currentThread() + "get resourceB");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "wait get resourceA");
                    synchronized (resourceA){
                        System.out.println(Thread.currentThread() + "get resourceA");
                    }

                }
            }
        });
        //破坏死锁，获取资源有序
        //Thread threadB = new Thread(new Runnable() {
        //    @Override
        //    public void run() {
        //        synchronized (resourceA){
        //            System.out.println(Thread.currentThread() + "get resourceA");
        //            try {
        //                Thread.sleep(1000);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //            System.out.println(Thread.currentThread() + "wait get resourceB");
        //            synchronized (resourceB){
        //                System.out.println(Thread.currentThread() + "get resourceB");
        //            }
        //
        //        }
        //    }
        //});

        threadA.start();
        threadB.start();
    }

}
