package node9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hy
 * @create 2022-04-17 13:40
 * @description 父线程收集子线程的值
 */
public class ThreadLocalValueTest {
    static ThreadLocal<List<Integer>> listThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    List<Integer> integerList = listThreadLocal.get();
                    if (integerList == null){
                        integerList = new ArrayList<>();
                    }
                    integerList.add(1);
                    listThreadLocal.set(integerList);
                    System.out.println("child:"+listThreadLocal.get());
                }
            });
            thread.start();
        }
        System.out.println("main"+ listThreadLocal.get());
    }
}
