package node2;

/**
 * @author hy
 * @create 2022-04-03 08:21
 * @description
 */
public class WaitTimeOutThread {
    public static volatile Object resource = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resource){
                        System.out.println("threadA get resource lock");
                        resource.wait(5000);
                        //resource.wait(0);
                        //resource.wait(-1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
    }
}
