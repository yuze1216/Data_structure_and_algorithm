package secondary;

/**
 * @author:yuze
 * @description:压缩字符串
 * @data:2021/8/21
 */
public class Compress {
    public static int compress(char[] chars) {
        int curr = 0;//记录写入新字符开始的位置

        for (int i = 0; i <chars.length ; ) {
            int start = i;
            chars[curr] = chars[i];

            while (i+1 < chars.length && chars[i+1] == chars[i]){
                i++;
            }

            if(i - start +1 ==1 /* i == start */){
                i++;
                curr++;
            }else {
                String len = Integer.toString(i - start +1);

                for (int j = 0; j <len.length() ; j++) {
                    curr++;
                    chars[curr] = len.charAt(j);
                }
                curr++;
                i++;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        char[] chars = {'a','b','a','a'};
        System.out.println(compress(chars));
    }
}
