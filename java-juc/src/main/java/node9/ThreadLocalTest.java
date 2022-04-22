package node9;

/**
 * @author hy
 * @create 2022-04-04 18:21
 * @description
 */
public class ThreadLocalTest {
    //创建ThreadLocal变量
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    //static String threadLocal;

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("threadA local variable");
                //threadA:threadA local variable
                System.out.println("threadA" + ":" + threadLocal.get());
                //清除threadLocal变量
                //threadLocal.remove();
                //System.out.println("threadA remove after:" + threadLocal.get());
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadB---" + ":" + threadLocal.get());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadLocal.set("threadB local variable");

                //threadB:threadB local variable
                System.out.println("threadB" + ":" + threadLocal.get());
                //清除threadLocal变量
                //threadLocal.remove();
                //System.out.println("threadB remove after:" + threadLocal.get());
            }
        });

        threadA.start();
        threadB.start();
    }
}
