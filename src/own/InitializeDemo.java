package own;

/**
 * @author:yuze
 * @description:类初始化执行顺序
 * @data:2022/1/15
 */
public class InitializeDemo {

    private static int k = 1;
    private static InitializeDemo t1 = new InitializeDemo("t1");//这里第二次new对象，这次进去不再执行static
    private static InitializeDemo t2 = new InitializeDemo("t2");
    private static int i = print("i");
    private static int n = 99;

    {
        print("初始化块");
        j = 100;
    }

    public InitializeDemo(String str) {
        System.out.println((k++) + ":" + str + "   i=" + i + "    n=" + n);
        ++i;
        ++n;

    }

    static {
        print("静态块");
        n = 100;
    }

    private int j = print("j");

    public static int print(String str) {
        System.out.println((k++) + ":" + str + "   i=" + i + "    n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {
        InitializeDemo test = new InitializeDemo("test");
    }
    //第一次new InitializeDemo()会检查类有没有初始化过，没有的话执行静态变量或者代码块从上至下，
}
