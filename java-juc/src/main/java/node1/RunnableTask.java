package node1;

/**
 * @author hy
 * @create 2022-04-02 22:12
 * @description
 */
public class RunnableTask implements Runnable{
    public void run() {
        //任务
        System.out.println("runnable thread is run");
    }

    public static void main(String[] args) {
        RunnableTask runnableTask = new RunnableTask();
        new Thread(runnableTask).start();
        new Thread(runnableTask).start();
    }
}
