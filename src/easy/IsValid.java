package easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author:yuze
 * @description:力扣-20，有效的括号
 * @data:2021/8/23
 */
public class IsValid {
    /**
     *
     * 这种方法只考虑到了输入为： ({[]})这样的中心向两边对称的情况的显然不对，
     * 题目还有这种输入情况:(){}[]
     * @author yuze
     * @date 2021/8/23 19:07
     * @param [args]
     * @return void
     */
//    public static boolean isValid(String s) {
//        if (s.length()%2==1){
//            return false;
//        }
//        Map<Character,Character> map = new HashMap<Character,Character>(){
//            {
//                put('(',')');
//                put('[',']');
//                put('{','}');
//            }
//        };
//        int left = s.length()/2-1,right = s.length()/2;
//        while (left>=0&&right<=s.length()-1){
//            if(s.charAt(right) == map.get(s.charAt(left))){
//                left--;
//                right++;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i <n ; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(stack.isEmpty() || stack.peek() != map.get(ch)){//peek方法返回栈顶元素，但不在栈中删除
                    return false;
                }
                stack.pop();//pop返回栈顶元素，并且在栈中删除该元素
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}
