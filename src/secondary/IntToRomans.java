package secondary;


/**
 * @author:yuze
 * @description:整数转罗马数字
 * @data:2021/8/19
 */
public class IntToRomans {
    /**
     *
     * 贪心算法
     * @author yuze
     * @date 2021/8/19 21:55
     * @param [num]
     * @return java.lang.String
     */
    public static String intToRoman(int num) {
        // 贪婪算法，类似于找零钱
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < 13) {
            if (num >= nums[index]) {
                result.append(romans[index]);
                num -= nums[index];
            } else {
                index ++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(14));
    }
}
