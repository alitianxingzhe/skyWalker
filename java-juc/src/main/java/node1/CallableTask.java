package node1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author hy
 * @create 2022-04-02 22:15
 * @description
 */
public class CallableTask implements Callable<String> {
    public String call() throws Exception {
        return "hello thread";
    }

    public static void main(String[] args) {
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<String>(new CallableTask());
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
