package node9;

/**
 * @author hy
 * @create 2022-04-04 21:56
 * @description threadLocal不支持继承
 */
public class ThreadLocalExtendTest {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //设置线程变量
        threadLocal.set("hello threadLocal");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread:" + threadLocal.get());
            }
        });
        thread.start();

        //主线程输出线程变量
        System.out.println("main:" + threadLocal.get());
    }
}
