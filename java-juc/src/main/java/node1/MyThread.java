package node1;

/**
 * @author hy
 * @create 2022-04-02 22:06
 * @description
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        //任务
        System.out.println("extends thread is run");
    }


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
