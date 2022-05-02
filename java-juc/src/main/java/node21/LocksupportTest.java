package node21;

import java.util.concurrent.locks.LockSupport;

/**
 * @author hy
 * @create 2022-05-02 10:00
 * @description
 */
public class LocksupportTest {

    static void noLicense(){
        System.out.println("begin park");
        LockSupport.park();
        System.out.println("end park");
    }

    static void haveLicense(){
        System.out.println("begin park");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end park");
    }

    public static void main(String[] args) {
        //noLicense();
        haveLicense();
    }
}
