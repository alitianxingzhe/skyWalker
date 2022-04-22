package node12;

import java.util.concurrent.TimeUnit;

/**
 * @author hy
 * @create 2022-04-21 22:22
 * @description volatile修饰引用数据类型
 */
public class VolatileTest5 {
    volatile Data data;

    public static void main(String[] args) {
        //修饰引用数据类型 测试线程可见性
        VolatileTest5 test5 = new VolatileTest5();
        test5.data = new Data();
        test5.data.set(2,1);
        try {
            //让前一步的操作写回到主内存
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() ->{
            test5.data = new Data();
            test5.data.set(6,5);
        }).start();
        System.out.println("name"+ test5.data.name);
        System.out.println("passwd"+ test5.data.passwd);
    }





}

class Data{
    int name;
    int passwd;

    public void set(int name,int passwd){
        this.name = name;
        this.passwd = passwd;
    }
}
