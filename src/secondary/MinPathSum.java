package secondary;

/**
 * @author:yuze
 * @description:64,最小路径和问题
 * @data:2022/1/17
 */
public class MinPathSum {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) {
//        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
//        System.out.println(sum(arr));
        MinPathSum oom = new MinPathSum();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }

//        List<MinPathSum> list = new ArrayList<MinPathSum>();
//        while (true){
//            list.add(new MinPathSum());
//        }
    }
    public static int sum(int[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[rows-1][columns-1];
    }
    public static int sum2(int[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int sum = grid[0][0];
        int down=0,right=0;
        int rows = grid.length, columns = grid[0].length;
//        int[][] dp = new int[rows][columns];
//        dp[0][0] = grid[0][0];
        while ( (down+1)<rows && (right+1)<columns ){
            if(sum+grid[down+1][right]<=sum+grid[down][right+1]);
        }
        return sum;
    }


}
