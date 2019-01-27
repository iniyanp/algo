package exercise;

/**
 * Created by iniyan.paramasivam on 10/24/18.
 */
public class MinPathSum2 {


    public static int findMin(int[][] arr, int m, int n, int i, int j){

        if(i == 0 && j == 0) return arr[0][0];

        if(i < 0 || j < 0) return Integer.MAX_VALUE;


        int result = arr[i][j] + Math.min(findMin(arr, m, n, i-1, j),
                findMin(arr, m, n, i, j-1));

        return result;

    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{1,2,3},{4,5,6},{6,0,9}};
        System.out.println(findMin(arr,3,3,2,2));

    }
}
