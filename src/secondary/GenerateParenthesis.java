package secondary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:yuze
 * @description:括号生成，leetcode 22
 * @data:2022/1/22
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        back(ans,cur,0,0,n);
        return ans;
    }
    public  static void back(List<String> ans,StringBuilder cur,int left,int right,int n){
        if(cur.length() == 2 * n){
            ans.add(cur.toString());
            return;
        }
        if(left < n){
            cur.append("(");
            back(ans,cur,left+1,right,n);
            //System.out.println(cur.deleteCharAt(cur.length() - 1));
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(')');
            back(ans, cur, left, right + 1, n);
            //System.out.println(cur.deleteCharAt(cur.length() - 1));
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
