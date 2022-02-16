package easy;

/**
 * @author:yuze
 * @description:找到一个整数的补数，整数二进制各位取反
 * @data:2021/10/18
 */
public class FindComplement {

    public static void main(String[] args) {
        int num = 5;//101
        System.out.println(findComplement(num));
    }
    public static int findComplement(int num) {
        //先要找到数字二进制的最高位
        int hightbit = 0;
        for (int i = 1;i<=30;i++){
            if(num >= (1<<i)){
                hightbit = i;
            }
            else
                break;
        }
        int mask = (hightbit == 30?0x7fffffff : (1<<(hightbit+1))-1);//制造掩码
        return num ^ mask;
    }
}
