package node10;

/**
 * @author hy
 * @create 2022-04-19 21:22
 * @description
 */
public class ThreadState {
    public static Object object = new Object();

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    System.out.println("runable:"+Thread.currentThread().getState());
                    try {
                        object.wait();
                        System.out.println("wait:"+Thread.currentThread().getState());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.out.println("new:" + thread.getState());
        thread.start();
        System.out.println("start:" + thread.getState());

        System.out.println("main over");


    }
}
