package own;

/**
 * @author:yuze
 * @description:归并排序
 * @data:2021/8/22
 */
public class GuiBing {

    public static void main(String[] args) {
        int[] arr = {65,34,54,67,1,33,543,674,435,764,31,-1,-5,-678,0,0};
        int[][] arr2 = new int[arr.length][1];
        for (int i = 0; i <arr.length ; i++) {
            arr2[i]  = new int[]{arr[i]};//利用二维数组方式直接将原始的一维数组切分成n个
        }
        for (int i = 0; i <arr.length ; i++) {
            arr2 = mergeAll(arr2);
            if(arr2.length == 1) break;//最终归并成长度为1的数组了说明归并完成了，跳出循环
        }
        for (int x:arr2[0]) {
            System.out.println(x);
        }
    }
    /**
     *
     * 将数组单元两两合并
     * @author yuze
     * @date 2021/8/22 15:33
     * @param [arr]
     * @return int[][]
     */
    public static int[][] mergeAll(int[][] arr){
        int[][] arrnew ;
        if(arr.length%2 == 1){//原始数组长度是奇数,若为奇数，肯定回落下一个数组不能merge，但是不能丢了，要放进新数组里面等待以后的归并
            arrnew = new int[arr.length/2+1][];
            for (int i = 0; i <arrnew.length ; i++) {
                if(i== arrnew.length-1){
                    arrnew[i] = arr[arr.length-1];//这里说的就是长度奇数的情况下不能丢下的那个单独数组
                }else {
                    arrnew[i] = merge(arr[2 * i],arr[2 * i + 1]);
                }
            }
        }else {//数组长度是偶数
            arrnew = new int[arr.length/2][];
            for (int i = 0; i <arrnew.length ; i++) {
                arrnew[i] = merge(arr[2*i],arr[2*i + 1]);
            }
        }
        return arrnew;
    }
    /**
     *
     * 合并两个有序数组
     * @author yuze
     * @date 2021/8/22 15:33
     * @param [x, y]
     * @return int[]
     */
    public static int[] merge(int[] x, int[] y){//合并两个有序数组,这比较简单了
        int[] re = new int[x.length+y.length];
        int curr = 0;//新数组写入位置
        int left = 0;
        int right = 0;
        while (left<x.length && right<y.length){
            if(x[left]<=y[right]){
                re[curr++] = x[left++];
            }else {
                re[curr++] = y[right++];
            }
        }
        while (left<x.length){
            re[curr++] = x[left++];
        }
        while (right<y.length){
            re[curr++] = y[right++];
        }
        return re;
    }
}
