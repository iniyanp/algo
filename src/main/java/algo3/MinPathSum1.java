package algo3;

/**
 * Created by paramin on 11/8/17.
 */
public class MinPathSum1 {



        private int getDist(int[][] dist, int x, int y){
            if(x < 0 || y < 0){
                return Integer.MAX_VALUE;
            }

            return dist[x][y];
        }

        private int min(int i1, int i2){
            return i1 < i2 ? i1 : i2;
        }


        public int minPathSum(int[][] grid) {

            if(grid == null || grid.length == 0) return 0;

            int m = grid.length;
            int n = grid[0].length;

            int[][] dist = new int[m][n];



            for(int x = 0; x < m; x++){
                for(int y = 0; y < n; y++){

                    if(x == 0 && y == 0){
                        dist[0][0] = grid[0][0];
                    }else{
                        dist[x][y] = min(getDist(dist, x-1, y), getDist(dist, x, y-1))  + grid[x][y];
                    }
                }
            }

            return dist[m-1][n-1];

        }

    public static void main(String[] args) {
        int[][] ques = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        MinPathSum1 m = new MinPathSum1();
        System.out.println(m.minPathSum(ques));
    }

    }
