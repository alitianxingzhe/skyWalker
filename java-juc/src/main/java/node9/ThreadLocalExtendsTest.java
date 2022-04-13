package node9;

/**
 * @author hy
 * @create 2022-04-04 22:06
 * @description 父线程参数传递给子线程
 */
public class ThreadLocalExtendsTest {
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

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
