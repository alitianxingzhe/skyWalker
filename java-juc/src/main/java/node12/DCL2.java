package node12;

/**
 * @author hy
 * @create 2022-04-21 07:03
 * @description
 */
public class DCL2 {
    private DCL2(){
    }

    private static DCL2 d;

    //加锁即可解决线程安全问题
    public /*synchronized*/ static DCL2 getInstance(){
        if (d == null){
            d = new DCL2();
        }
        return d;
    }


    public static void main(String[] args) {
        DCL2 instance = DCL2.getInstance();
        DCL2 instance1 = DCL2.getInstance();
        System.out.println(instance == instance1);
    }
}
