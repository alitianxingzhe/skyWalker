package node11;

/**
 * @author hy
 * @create 2022-04-20 22:38
 * @description
 */
public class CountTest2 implements Runnable{
    private /*volatile*/ int count = 10000;


    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        CountTest2 test2 = new CountTest2();

        //volatile保证线程的可见性，但不能保证原子性
        //synchronized即保证了原子性也保证了可见性
        for (int i = 0; i < 10000; i++) {
            new Thread(test2,"Thread" + i).start();
        }
    }
}
