package node9;

/**
 * @author hy
 * @create 2022-04-04 18:21
 * @description
 */
public class ThreadLocalTest {
    //创建ThreadLocal变量
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static void print(String str){
        //打印当前线程本地内存中threadLocal变量的值
        System.out.println(str + ":" + threadLocal.get());
        //清除threadLocal变量
        //threadLocal.remove();
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("threadA local variable");
                print("threadA");
                System.out.println("threadA remove after:" + threadLocal.get());
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("threadB local variable");
                print("threadB");
                System.out.println("threadB remove after:" + threadLocal.get());
            }
        });

        threadA.start();
        threadB.start();
    }
}
