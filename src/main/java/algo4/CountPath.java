package algo4;

import java.util.LinkedList;
import java.util.List;

public class CountPath {

    static int[] rowArr = new int[]{0, -1, 0, 1};
    static int[] colArr = new int[]{-1, 0, 1, 0};
    static int count = 0;
    static  List<Integer> paths = new LinkedList<>();

    public static boolean isValidPath(int[][] grid, int row, int col, boolean[][] visited){

        if(row < 0 || row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
            return false;

        if(grid[row][col] == -1 || visited[row][col]) return false;

        return true;
    }

    public static void dfs(int[][]grid, int row, int col, boolean[][] visited){

        if(grid[row][col] == 2) {
            //TODO: count zeros on path. If it s equal to original zero counts, increase the result count.
            System.out.println(paths);
            count++;
            return;
        }

        //4 directions.
        for(int i=0;i<4;i++){
            int newRow = row + rowArr[i];
            int newCol = col + colArr[i];
            if(isValidPath(grid, newRow, newCol, visited)){
                paths.add(grid[newRow][newCol]);
                visited[newRow][newCol] = true;
//                System.out.println("row:" + "\t" + row + " col:" + "\t" + col);
                dfs(grid,newRow, newCol, visited);
                visited[newRow][newCol] = false;
                if(paths.size() > 0)
                    paths.remove(paths.size() - 1);
            }
        }

    }

    public static int countPath(int[][] grid){

        if(grid == null || grid.length == 0)
            return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        dfs(grid, 0, 0, visited);
        return count;

    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}};
//        int[][] grid = new int[][]{{1,0},{0,2}};
        countPath(grid);
//        System.out.println(count);
    }
}
