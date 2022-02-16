package secondary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:yuze
 * @description:leetcode784 字母大小写全排列
 * @data:2022/1/24
 */
public class LetterCasePermutation {
    static List<String> ans = new ArrayList<String>();
    public static void main(String[] args) {
        String s = "a1b2";
        List<String> strings = letterCasePermutation(s);
        for (String sss:strings) {
            System.out.println(sss);
        }
    }
    public static List<String> letterCasePermutation(String s){
        StringBuilder st = new StringBuilder();
        dfs(s,st,0);
        return ans;
    }
    public static void dfs(String s,StringBuilder st,int index){
        if(index == s.length()){
            ans.add(st.toString());
            return;
        }
        if(Character.isDigit(s.charAt(index))){//当前位置是数字
            st.setCharAt(index,s.charAt(index));
            dfs(s,st,index+1);
        }else if(Character.isLowerCase(s.charAt(index))){//当前位置是小写字母
            st.setCharAt(index,s.charAt(index));
            dfs(s,st,index+1);
            st.setCharAt(index, Character.toUpperCase(s.charAt(index)));//转成大写字母
            dfs(s,st,index+1);
        }else {//当前位置是大写字母
            st.setCharAt(index,s.charAt(index));
            dfs(s,st,index+1);
            st.setCharAt(index, Character.toLowerCase(s.charAt(index)));//转成小写字母
            dfs(s,st,index+1);
        }
    }

}
