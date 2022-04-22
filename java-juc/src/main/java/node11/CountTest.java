package node11;

/**
 * @author hy
 * @create 2022-04-20 07:19
 * @description
 */
public class CountTest implements Runnable{
    volatile int count = 10;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);

    }


    public static void main(String[] args) {

        for(int i=0; i<5; i++) {
            CountTest t = new CountTest();
            new Thread(t, "THREAD" + i).start();
        }
    }
}
