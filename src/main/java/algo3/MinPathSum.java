package algo3;

/**
 * Created by paramin on 9/12/17.
 */
public class MinPathSum {

    static int rowVal = Integer.MAX_VALUE;
    static int colVal = Integer.MAX_VALUE;


    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length <= 0) return 0;
        int cache[][] = new int[grid.length][grid[0].length];
        return minPathSumHelper(0,0,cache,grid, rowVal, colVal);
    }
    public static int minPathSumHelper(int m, int n, int[][] cache, int[][] grid,int rowVal, int colVal){
        if(m == grid.length-1 && n == grid[0].length-1) return grid[m][n];

        if(cache[m][n] != 0) return cache[m][n];


        if(m < grid.length - 1) rowVal = minPathSumHelper(m+1, n, cache, grid, rowVal, colVal);
        if(n < grid[0].length - 1) colVal = minPathSumHelper(m, n+1, cache, grid, rowVal, colVal);

        cache[m][n] = Math.min(rowVal, colVal) + grid[m][n];
        return cache[m][n];

    }

    public static void main(String[] args) {
        int[][] ques = new int[][]{
                {1,1,1},
                {0,1,1},
                {1,1,1}
        };
        System.out.println(minPathSum(ques));
    }


}
