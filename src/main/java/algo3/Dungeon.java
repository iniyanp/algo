package algo3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paramin on 10/2/17.
 */
public class Dungeon {

    List<List<Integer>> result = new ArrayList<>();

    public void allPaths(int[][] matrix, int i, int j, int m, int n, List<Integer> tempList) {

        if(i > m - 1 || j > n - 1) return;

        //Before adding it, may be you can check the health. and if health < 0 , you can return it.

        int elem = matrix[i][j];
        tempList.add(elem);

        if(i == m - 1 && j == n - 1){
            List<Integer> temp1 = new ArrayList<>();
            temp1.addAll(tempList);
            result.add(temp1);
        } else{
            allPaths(matrix, i, j+1,m,n,tempList);
            allPaths(matrix, i+1, j,m,n,tempList);
        }

        if(tempList.size() > 0)
            tempList.remove(tempList.size() - 1);

    }

    public static void main(String[] args) {

        int m[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        Dungeon d = new Dungeon();
        d.allPaths(m,0,0,3,3,new ArrayList<>());
        System.out.println(d.result);

    }
}
