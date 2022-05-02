package node21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author hy
 * @create 2022-05-02 10:09
 * @description
 */
public class LocksupportTest2 {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() ->{
            System.out.println("child thread park");
            //挂起当前线程
            LockSupport.park();
            System.out.println("child thread unpark");
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("main thread start");
        LockSupport.unpark(t);
    }
}
