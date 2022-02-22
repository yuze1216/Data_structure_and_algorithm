package secondary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:yuze
 * @description:leetcode695. 岛屿的最大面积
 *
 * @data:2022/2/19
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Queue<Integer> queuei = new LinkedList<Integer>();
        queuei.offer(1);
        System.out.println(queuei.poll());
        queuei.poll();
        queuei.offer(2);
        queuei.offer(3);
        System.out.println(queuei.poll());
        queuei.offer(4);

    }
    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max,dfs(grid,i,j));
            }
        }
        return max;
    }
    public static int dfs(int[][] grid,int i,int j){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 1){
            return 0;
        }
        grid[i][j] = 0;
        int ans = 1;
        int[] di = {0,0,1,-1};
        int[] dj = {1,-1,0,0};
        for (int k = 0; k < 4; k++) {
           int next_i = i + di[k];
           int next_j = j+ dj[k];
           ans += dfs(grid,next_i,next_j);
        }
        return ans;
    }
}
