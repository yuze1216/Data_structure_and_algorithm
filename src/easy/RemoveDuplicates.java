package easy;

/**
 * @author:yuze
 * @description:删除字符产中的所有相邻重复项
 * @data:2021/8/21
 */
public class RemoveDuplicates {

    public static String removeDuplicates(String s) {
        char[] x= s.toCharArray();
        StringBuilder str = new StringBuilder();
        for(int i =0;i<x.length;i++){
            if(str.length()==0){
                str.append(x[i]);
            }else{
                if(str.charAt(str.length()-1) == x[i]){
                    str.deleteCharAt(str.length()-1);
                }else{
                    str.append(x[i]);
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(removeDuplicates(s));
    }
}
