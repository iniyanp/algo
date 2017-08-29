package algo3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by paramin on 8/26/17.
 */
public class MeetingPoint {

    public int minTotalDistance(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        ArrayList<Integer> cols = new ArrayList<Integer>();
        ArrayList<Integer> rows = new ArrayList<Integer>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    cols.add(j);
                    rows.add(i);
                }
            }
        }
        int sum=0;
        for(Integer i: rows){
            sum += Math.abs(i - rows.get(rows.size()/2));
        }
        Collections.sort(cols);
        for(Integer i: cols){
            sum+= Math.abs(i-cols.get(cols.size()/2));
        }
        return sum;
    }

    public static void main(String[] args) {
        MeetingPoint m = new MeetingPoint();
        int[][] grid = new int[3][5];

        grid[0][0] = 1;
        grid[0][1] = 0;
        grid[0][2] = 0;
        grid[0][3] = 0;
        grid[0][4] = 1;

        grid[1][0] = 0;
        grid[1][1] = 0;
        grid[1][2] = 0;
        grid[1][3] = 0;
        grid[1][4] = 0;

        grid[2][0] = 0;
        grid[2][1] = 0;
        grid[2][2] = 1;
        grid[2][3] = 0;
        grid[2][4] = 0;


        System.out.println(m.minTotalDistance(grid));
    }
}
