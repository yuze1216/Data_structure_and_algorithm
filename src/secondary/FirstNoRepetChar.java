package secondary;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author:yuze
 * @description:第一个不重复的字符
 * @data:2022/2/22
 */
public class FirstNoRepetChar {
    public static void main(String[] args) {
        //System.out.println(firstUniqChar("llEeFFtcode"));
        Map<String, String> books = new HashMap<>();
        books.put("bob", "books");
        books.put("c", "concurrent");
        books.put("a", "a lock");
        System.out.println(books);
        Map<String, String> book2 = new TreeMap<>();
        book2.put("bob", "books");
        book2.put("c", "concurrent");
        book2.put("a", "a lock");
        System.out.println(book2);

    }
    public static String firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap(){};
        for(int i = 0 ; i< s.length() ;i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                char x = Character.toLowerCase(c);
                map.put(x,map.getOrDefault(x,0)+1);
            }else {
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }

        for(int i = 0 ; i< s.length() ;i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                char x = Character.toLowerCase(c);
                if(map.get(x) == 1){
                    return String.valueOf(s.charAt(i));
                }
            }else {
                if(map.get(c) == 1){
                    return String.valueOf(s.charAt(i));
                }
            }

        }
        return "";
    }
}
