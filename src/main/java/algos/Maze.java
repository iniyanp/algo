package algos;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by paramasivami on 4/17/16.
 * It would print all paths from start to end.
 */
public class Maze {


    private static void solve(int[][] matrix, int x, int y, List<String> resultPath){



        if(x >= matrix.length || y >= matrix.length || matrix[x][y] != 1) return;

        if(matrix[x][y] == 1)
            resultPath.add(x + "" + y);

        if(x == matrix.length - 1 && y == matrix.length - 1 && matrix[x][y] == 1){
            resultPath.forEach(
                    path -> System.out.print(path + " ")
            );
            System.out.println();
        }else{
            //Considered below and bottom paths only.
            solve(matrix, x, y+1, resultPath);
            solve(matrix, x+1, y, resultPath);
        }
        resultPath.remove(resultPath.size() - 1);
    }

    public static void main(String[] args) {
        int[][] matrix =  new int[3][3];

        matrix[0] = new int[]{1,0,0};
        matrix[1] = new int[]{1,1,0};
        matrix[2] = new int[]{1,1,1};
        solve(matrix, 0,0, new LinkedList<>());

    }
}
