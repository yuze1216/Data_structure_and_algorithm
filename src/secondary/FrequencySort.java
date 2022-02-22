package secondary;

import java.util.*;

/**
 * @author:yuze
 * @description:根据字符出现频率排序
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 * @data:2022/2/19
 */
public class FrequencySort {
    public static void main(String[] args) {
        String s = "free";
        System.out.println(frequencySort(s));
    }
    public static String   frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int frequency  = map.getOrDefault(c, 0) + 1;//getOrDefault获取指定key的value，没有的话赋值defaultValue
            map.put(c,frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
//        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


}
