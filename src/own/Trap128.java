package own;

/**
 * @author:yuze
 * @description:128陷阱
 * @data:2022/1/15
 */
public class Trap128 {
    public static void main(String[] args) {
        int a1 = 10;
        int b1= 20;
        Integer a = 200;
        Integer b = 10;
        Integer c = 128;
        Integer d = 128;
//        System.out.println(a==b);
//        System.out.println(c==d);
//        Integer e = new Integer(a);
//        System.out.println(a==e);
        test1(a,b);
        System.out.println(a);
        System.out.println(b);

    }
    public static void test1(Integer a,Integer b){
        Integer c = a;
        a=b;
        b=c;
    }
}
