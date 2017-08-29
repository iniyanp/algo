package algos;

/**
 * Created by paramasivami on 4/24/16.
 */
public class MaxSubSetSum {

//Continuous max subset .

    public static void main(String[] args) {

        int arr[] = new int[]{8,4,-3,1,2};
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for(int i=1;i<arr.length;i++){
            currMax = Math.max(arr[i], currMax+arr[i]);
            System.out.print(currMax + " ");
            maxSoFar = Math.max(maxSoFar, currMax);
            System.out.println(maxSoFar);
        }

        System.out.println(maxSoFar);
    }
}
