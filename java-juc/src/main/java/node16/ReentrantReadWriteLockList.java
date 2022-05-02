package node16;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hy
 * @create 2022-04-30 17:58
 * @description
 */
public class ReentrantReadWriteLockList {
    //线程不安全的list
    private ArrayList<String> arrayList = new ArrayList<>();

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final Lock readLock = readWriteLock.readLock();

    private final Lock writeLock = readWriteLock.writeLock();


    //添加元素
    public void add(String s){
        writeLock.lock();
        try {
            arrayList.add(s);
        } finally {
            writeLock.unlock();
        }
    }

    //删除元素
    public void remove(String s){
        writeLock.lock();
        try {
            arrayList.remove(s);
        } finally {
            writeLock.unlock();
        }
    }

    //获取元素
    public String get(int index){
        readLock.lock();
        try {
            return arrayList.get(index);
        } finally {
            readLock.unlock();
        }
    }
}
