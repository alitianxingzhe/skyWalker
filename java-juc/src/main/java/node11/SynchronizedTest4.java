package node11;

import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-04-20 22:27
 * @description
 */
public class SynchronizedTest4 implements Runnable{
    private  int count = 0;

    @Override
    public void run() {
        synchronized (this){
            while (true){
                count++;
                System.out.println(Thread.currentThread().getName() + " count = " + count);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count % 5 == 0){
                    count = count /0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedTest4 test4 = new SynchronizedTest4();
        new Thread(test4,"Thread-1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(test4,"Thread-2").start();
    }
}
