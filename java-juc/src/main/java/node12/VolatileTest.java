package node12;

import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-04-20 23:31
 * @description
 */
public class VolatileTest {

    private /*volatile*/ boolean running = true;

    public void m(){
        System.out.println("m start");
        while (running){

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        new Thread(test::m,"thread-1").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.running = false;
    }
}
