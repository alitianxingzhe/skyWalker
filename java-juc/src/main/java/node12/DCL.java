package node12;

/**
 * @author hy
 * @create 2022-04-21 07:01
 * @description 饿汉
 */
public class DCL {
    private DCL() {

    }

    private final static DCL dcl = new DCL();

    public static DCL getInstanse() {
        return dcl;
    }

    public static void main(String[] args) {
        DCL instanse1 = DCL.getInstanse();
        DCL instanse2 = DCL.getInstanse();
        System.out.println(instanse1 == instanse2);
    }
}
