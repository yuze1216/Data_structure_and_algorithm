package secondary;

import java.util.Arrays;

/**
 * @author:yuze
 * @description:leetcode1686. 石子游戏 VI
 * Alice 和 Bob 轮流玩一个游戏，Alice 先手。
 *
 * 一堆石子里总共有 n 个石子，轮到某个玩家时，他可以 移出 一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准 。双方都知道对方的评判标准。
 *
 * 给你两个长度为 n 的整数数组 aliceValues 和 bobValues 。aliceValues[i] 和 bobValues[i] 分别表示 Alice 和 Bob 认为第 i 个石子的价值。
 *
 * 所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略 进行游戏。
 *
 * 输入：aliceValues = [1,3], bobValues = [2,1]
 * 输出：1
 * 解释：
 * 如果 Alice 拿石子 1 （下标从 0开始），那么 Alice 可以得到 3 分。
 * Bob 只能选择石子 0 ，得到 2 分。
 * Alice 获胜。
 * @data:2022/2/18
 */
public class StoneGameVI {
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,1};
        System.out.println(stoneGameVI(a,b));
    }
    public static int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int alen = aliceValues.length;
        int blen = bobValues.length;
        Arrays.sort(aliceValues);
        Arrays.sort(bobValues);
        int n = alen + blen;
        int x = 0;
        int i = alen - 1;
        int asum = 0;
        int bsum = 0;
        while (x < alen){
            if(aliceValues[i] >= bobValues[i]){
                asum += aliceValues[i];
                if(i > 0){
                    i--;
                }
            }else {
                bsum +=bobValues[i];
                if(i > 0){
                    i--;
                }
            }
            x++;
        }
        if(asum > bsum){
            return 1;
        }else if(asum == bsum){
            return 0;
        }else {
            return -1;
        }

    }
}
