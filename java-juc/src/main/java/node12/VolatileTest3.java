package node12;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hy
 * @create 2022-04-20 23:48
 * @description
 */
public class VolatileTest3 {

    static class Data{
        private int a,b;

        public Data(int a,int b){
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }

    //volatile static Data data;
    volatile static AtomicReference<Data> dataAtomicReference = new AtomicReference<>();


    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            int a = i;
            int b = i;
            Thread write = new Thread(() -> {
                //data = new Data(a,b);
                dataAtomicReference.compareAndSet(null,new Data(a,b));

            });
            Thread read = new Thread(() -> {
                while (dataAtomicReference.get() == null /* data == null */) {
                }
                //int x = data.getA();
                //int y = data.getB();
                int x = dataAtomicReference.get().getA();
                int y = dataAtomicReference.get().getB();
                if (x != y) {
                    System.out.printf("a = %s, b=%s%n", x, y);
                }
            });
            read.start();
            write.start();
            try {
                read.join();
                write.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /*
            a = 126, b=127
            main over
        * */
        System.out.println("main over");
    }
}
