package node15;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hy
 * @create 2022-04-25 07:37
 * @description
 */
public class ReentrantLockList {
    //线程不安全的list
    private ArrayList<String> arrayList = new ArrayList<>();

    //独占锁
    private volatile ReentrantLock reentrantLock = new ReentrantLock();

    //添加元素方法
    public void add(String e){
        reentrantLock.lock();
        try {
            arrayList.add(e);
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }

    //删除元素
    public void remove(String e){
        reentrantLock.lock();
        try {
            arrayList.remove(e);
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }

    //获取元素
    public String get(int index){
        reentrantLock.lock();
        try {
            return arrayList.get(index);
        }finally {
            reentrantLock.unlock();
        }
    }

}
