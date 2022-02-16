package secondary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author:yuze
 * @description:找出第 K 大的异或坐标值
 * @data:2022/1/6
 */
public class KthLargestValue {

    public static void main(String[] args) {
        int[][] matrix = new int[2][2];
        int k =1;
        matrix[0][0] = 5;
        matrix[0][1] = 2;
        matrix[1][0] = 1;
        matrix[1][1] = 6;
        System.out.println(kthLargestValue(matrix,k));

    }
    public static int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr = new int[m+1][n+1];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
               arr[i][j] = arr[i - 1][j] ^ arr[i][j - 1] ^ arr[i - 1][j - 1] ^ matrix[i - 1][j - 1];
               list.add(arr[i][j]);
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        return list.get(k-1);
    }
}
