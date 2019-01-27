package exercise;

/**
 * Created by iniyan.paramasivam on 10/23/18.
 */
class Solution {

    public int minPathSum(int[][] grid) {

        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(i==0 && j==0) {
                    result[i][j] = grid[i][j];
                } else{
                    int rowSum = Integer.MAX_VALUE;
                    int colSum = Integer.MAX_VALUE;

                    if(i > 0)
                        rowSum = result[i-1][j];
                    if(j > 0)
                        colSum = result[i][j-1];

                    result[i][j] =  Math.min(rowSum, colSum) + grid[i][j];
                }
            }
        }
        return result[m-1][n-1];
    }
}