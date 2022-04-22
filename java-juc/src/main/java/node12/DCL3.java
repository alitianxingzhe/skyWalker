package node12;

import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-04-21 07:08
 * @description
 */
public class DCL3 {
    private DCL3(){
    }

    /**
        使用了synchronized后，需不需要使用volatile呢 ===> 需要，volatile禁止了指令重排
        原因：new DCL3()操作分为三步，1、分配对象内存空间 2、初始化对象 3、设置初始化对象指向分配的内存地址（d ！= null）
        步骤2步骤3如果不用volatile修饰会发生指令重排序，132；
        此时如果多个线程访问，获取d != null,但是d还没有初始化，此时就会有问题
    */
    private volatile static DCL3 d;

    public /*synchronized*/ static DCL3 getInstance(){
        if (d == null){
            //锁细化
            synchronized (DCL3.class){
                if (d != null){
                    //双重检查 因为 synchronized保证了原子性
                    return d;
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                d = new DCL3();
            }
        }
        return d;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                DCL3 instance = DCL3.getInstance();
                System.out.println(instance);
            }).start();
        }
    }
}
