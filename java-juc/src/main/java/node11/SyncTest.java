package node11;

import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-04-21 23:14
 * @description
 */
public class SyncTest {

    private static String s1  = "hello";
    private static String s2  = "hello";

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (s1){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("s1");
                }
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //s1 和 s2 是同一把锁
        new Thread(()->{
            System.out.println("s2 start");
            synchronized (s2){
                System.out.println("s2");
            }
        }).start();
    }

}
