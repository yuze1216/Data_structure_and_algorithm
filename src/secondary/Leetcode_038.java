package secondary;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author:yuze
 * @description:每日温度
 * @data:2022/1/9
 */
public class Leetcode_038 {

    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len ; i++) {
            if(deque.isEmpty() || temperatures[deque.peek()] >= temperatures[i]){
                deque.push(i);
            }else if(!deque.isEmpty() && temperatures[deque.peek()] < temperatures[i]){
                while (!deque.isEmpty() && temperatures[deque.peek()] < temperatures[i]){
                    ans[deque.peek()] = i-deque.pop();
                }
                deque.push(i);
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.println(ans[i]);
        }

    }
}
//    int n = temperatures.length;
//        if(n == 1) return new int[]{0};
//                int[] res = new int[n];
//                Deque<Integer> st = new ArrayDeque<>();
//        for(int i = 0; i < n; ++i){
//        if(st.isEmpty() || temperatures[st.peek()] >= temperatures[i]) st.push(i);
//        else if(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
//        while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
//        res[st.peek()] = i - st.pop();
//        }
//        st.push(i);
//        }
//        }
//        return res;
