package own;

/**
 * @author:yuze
 * @description:唯一数问题
 * @data:2022/1/10
 */
public class UniqueNumber {

    public static void main(String[] args) {
        int a[] = new int[]{3, 4, 6, 5, 5, 6, 4};
        System.out.println(getNum(a));
        int b[] = {3, 8, 4, 6, 5, 5, 6, 4};
        getNums1(b);
        int c[] = {7, 1, 5, 14, 8, 8, 5, 14};
        getNums2(c);
    }
    /**
     *
     * 在n个整数中，仅有1个整数出现1次，其余的整数都出现了偶数次，求这个仅出现1次的整数。要求时空复杂度尽可能低。
     * @author yuze
     * @date 2022/1/10 22:49
     * @param
     * @return
     */
    public static int getNum(int[] a){
        int n = a.length;
        int result = 0;
        for(int i = 0; i < n; i++)
        {
            result ^= a[i];
            //a^b^b=a,
            // 3 ^ 4 ^ 6 ^ 5 ^ 5 ^ 6 ^ 4
            //=3 ^ (4 ^ 4) ^ (5 ^ 5) ^ (6 ^ 6)
            //=3 ^ 0 ^ 0 ^ 0
            //=3
        }
        return result;
    }
    /**
     *
     * 在n个整数中，有1个奇数仅出现一次，有1个偶数仅出现一次，其余的整数都出现了偶数次，求奇数和偶数的值。要求时空复杂度尽可能低。
     * @author yuze
     * @date 2022/1/10 22:49
     * @param
     * @return
     */
    public static void getNums1(int[] a){
        int n = a.length;
        int result1 = 0;
        int result2 = 0;
        for(int i = 0; i < n; i++)
        {//分开奇偶处理就好了
           if(a[i]%2 == 0){//偶数
                result1 ^= a[i];
           }else {//奇数
               result2 ^=a[i];
           }
        }
        System.out.println(result1);
        System.out.println(result2);
    }

    /**
     *
     * 在n个整数中，有2个不同的整数分别出现1次，其余的整数都出现了偶数次，求仅出现1次的2个整数。要求时空复杂度尽可能低。
     * @author yuze
     * @date 2022/1/10 22:49
     * @param
     * @return
     */
    public static void getNums2(int[] a){
        int n = a.length;
        int result = getXOR(a);
        int flag = getFlag(result);
        int ans1=0;
        int ans2=0;
        for (int i = 0; i < n; i++)
        {
            if ((flag & a[i])>0)
            {
                ans1 ^= a[i];
            }
        }

        ans2 = ans1 ^ result;
        System.out.println(ans1);
        System.out.println(ans2);

    }

    public static int getXOR(int[] a){
        int n = a.length;
        int result = 0;
        for(int i = 0; i < n; i++)
        {
            result ^= a[i];
        }
        return result;
    }
    public static int getFlag(int xor){
        int flag = 1;
        while((flag & xor) == 0)
        {
            flag <<= 1;
        }
        return flag;
    }


}
