package node6;

/**
 * @author hy
 * @create 2022-04-04 10:01
 * @description 使用interrupted优雅退出线程
 */
public class InterruptThread {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //线程退出条件 1==1可以替换
                    while (!Thread.currentThread().isInterrupted() && 1 == 1){
                        //do work
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    //thread was interrupted or wait
                }
            }
        });
    }
}
