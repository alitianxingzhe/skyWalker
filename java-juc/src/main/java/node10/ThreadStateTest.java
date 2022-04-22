package node10;

import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-04-19 21:30
 * @description
 */
public class ThreadStateTest {

    //该线程一直等待
    static class Waiting implements Runnable{
        @Override
        public void run() {
            while (true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //该线程加锁后 不会释放锁
    static class Blocked implements Runnable{
        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class TimeWaiting implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // jps 获取进程ID ; jstack 进程ID 获取线程状态
        new Thread(new TimeWaiting(),"TimeWaiting").start(); //TIMED_WAITING (sleeping)
        new Thread(new Waiting(),"Waiting").start();//WAITING (on object monitor)
        new Thread(new Blocked(),"Blocked-1").start();//TIMED_WAITING (sleeping)
        new Thread(new Blocked(),"Blocked-2").start();//BLOCKED (on object monitor)


    }

}
