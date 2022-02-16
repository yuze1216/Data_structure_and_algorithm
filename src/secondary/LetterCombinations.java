package secondary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author:yuze
 * 力扣 17题
 * @description:电话号码的全部字母组合,
 * @data:2021/8/23
 */
public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length()==0){
            return list;
        }
        Map<Character,String> map = new HashMap<Character,String>(){
            {
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }
        };
        back(list,map,digits,new StringBuffer(),0);
        return list;
    }

    public static void back(List<String> list,Map<Character,String> map,String digits,StringBuffer combination,int index){
        if(index == digits.length()){//递归出口，index最大取值是digits.length()-1，所以等于digits.length()的时候就是结束的时候了
            list.add(combination.toString());
        }
        else {
            char digit = digits.charAt(index);//2  //3
            String letters = map.get(digit);//abc  //def
            int lettersCount = letters.length();//3  //3
            for (int i = 0; i <lettersCount ; i++) {
                combination.append(letters.charAt(i)); //a  //d
                back(list,map,digits,combination,index+1);
                combination.deleteCharAt(index);//删掉最后一个字符，开始下一次循环
            }
        }

    }

    public static void main(String[] args) {
        String digits = "23";//长度0<=digits<=4，数字在2-9不包括1
        System.out.println(letterCombinations(digits));
    }
}
