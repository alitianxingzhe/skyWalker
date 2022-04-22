package node11;

import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-04-20 07:49
 * @description  对写加锁 读不加锁 ； 写不加锁会引发脏读问题
 */
public class Amount {

    private String name;

    private String money;


    //读数据不加锁
    public String read(String name){
        return this.money;
    }

    //写入数据 加锁
    public void pay(String name, String money){
        this.name = name;
        this.money = money;
    }


    public static void main(String[] args) {
        Amount amount = new Amount();
        Thread thread = new Thread(() -> amount.pay("hy", "100"));
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(amount.read("hy"));

    }
}
