package secondary;

/**
 * @author:yuze
 * @description:z字形变换
 * @data:2021/8/18
 */
public class Convert {
    /**
     *
     * 自己用的二维数组，但是输出结果有空格提交报错，没有想到解决方法
     * @author yuze
     * @date 2021/8/18 20:37
     * @param [s, numRows]
     * @return java.lang.String
     */
//    public static String convert2(String s, int numRows) {
//        if(numRows == 1){
//            return s;
//        }
//        char[][] res = new char[numRows][1000];
//        int index = 0;
//        int row = 0;
//        int line = 0;
//        int len = s.length();
//        while (index<len){
//            while (index < len && row < numRows) {
//                res[row][line] = s.charAt(index++);
//                row++;
//            }
//            if(index == len){
//                break;
//            }
//           // line++;
//            row = numRows -2;
//            while (index<len && row >= 0){
//                line++;
//                res[row][line] = s.charAt(index++);
//                row--;
//
//            }
//            row+=2;
//        }
//        String sr = "";
//        for (int i = 0; i <numRows ; i++) {
//            for (int j = 0; j <line+1 ; j++) {//这里j<line++想不明白，如果是line最后就少一列，不知道为什么
//                if(res[i][j] == ' '){
//                    continue;
//                }
//                sr+=res[i][j];
//                //System.out.print(res[i][j]);
//            }
//            //System.out.println();
//        }
//        sr.replaceAll(" ","");
//        return sr;
//    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String convert = convert(s,numRows);
        for (int i = 0; i <convert.length() ; i++) {
            System.out.println(convert.charAt(i));
        }
        System.out.println(convert);

    }
    /**
     *
     * 力扣上其他人用的StringBuilder，这个方法类优化了String类型变量的相加合并
     * @author yuze
     * @date 2021/8/18 20:41
     * @param [s, numRows]
     * @return java.lang.String
     */
    public static String convert(String s, int numRows) {
        if(numRows == 1)
            return s;

        StringBuilder[] res = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++)
            res[i] = new StringBuilder();

        int index = 0;
        int row = 0;
        int len = s.length();
        while(index < len){
            while(index < len && row < numRows){
                char ch = s.charAt(index++);
                res[row].append(ch);
                row++;
            }

            if(index == len)
                break;

            row = numRows - 2;

            while(index < len && row >= 0){
                char ch = s.charAt(index++);
                res[row].append(ch);
                row--;
            }

            row += 2;
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < numRows; i++)
            ans.append(res[i]);

        return ans.toString();
    }
}
