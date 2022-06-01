package TemplateMethod;

/**
 * @author hy
 * @create 2022-05-03 00:58
 * @description
 */
public class Main {
    public static void main(String[] args) {
        F f = new S();
        f.m();
    }
}

abstract class F{
    void m(){
        op1();
        op2();
    }
    protected abstract void op2();
    protected abstract void op1();
}

class S extends F{

    @Override
    protected void op2() {
        System.out.println("op2");
    }

    @Override
    protected void op1() {
        System.out.println("op1");
    }
}