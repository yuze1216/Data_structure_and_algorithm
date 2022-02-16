package secondary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author:yuze
 * @description:给定一个数组，输出它的所有全排列,leetcode46题,用的回溯法
 * @data:2022/1/24
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> a:permute) {
            System.out.println(a);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> out = new ArrayList<Integer>();
        for (int num:nums) {
            out.add(num);
        }
        int n = nums.length;
        back(n,res,out,0);
        return res;
    }
    public static void back(int n ,List<List<Integer>> res ,List<Integer> out ,int first){
        if(first == n){
            res.add(new ArrayList<>(out));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(out,first,i);
            back(n,res,out,first+1);
            Collections.swap(out,first,i);
        }
    }
}
