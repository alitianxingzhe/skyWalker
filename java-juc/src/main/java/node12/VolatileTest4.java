package node12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hy
 * @create 2022-04-21 22:11
 * @description volatile 不能保证原子性
 */
public class VolatileTest4 {
    private /*volatile*/ int count = 0;

    public /*synchronized*/ void m(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        VolatileTest4 test4 = new VolatileTest4();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(test4::m,"thread-"+i));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("输出的值为："+test4.count);

    }

}
