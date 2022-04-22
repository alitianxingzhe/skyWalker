package node11;

/**
 * @author hy
 * @create 2022-04-19 21:47
 * @description
 */
public class SynchronizedTest {
    private Object object = new Object();

    private int count = 10;

    public void m1(){
        synchronized (object){
            //任何线程都必须先获得object的监视器锁
            System.out.println("thread must get lock object");
        }
    }

    public void m2(){
        synchronized (this){
            count--;
            System.out.println("thread must get lock SynchronizedTest");
        }
    }

    public synchronized void m3(){
        //相当于this 当前实例对象  ==  synchronized (this)
        System.out.println("thread must get lock");
    }

    public static synchronized void m4(){
        //相当于synchronized (SynchronizedTest.class)
        System.out.println("thread must get lock");
        while (true){

        }
    }

    public static void m5(){
        System.out.println("thread try get lock");
        synchronized (SynchronizedTest.class){
            System.out.println("thread must get lock");
        }
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedTest.m4();
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedTest.m5();
            }
        });
        t2.start();
    }

}
