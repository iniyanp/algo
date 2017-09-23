package exercise;

import java.util.Arrays;

/**
 * Created by paramin on 9/21/17.
 */
public class Ex4 {


    public boolean solution(int[] A) {
        // write your code in Java SE 8


        if(A == null || A.length == 0) return true;

        int[] sorted = new int[A.length];
        int i=0;
        for(int a:A){
            sorted[i++] = a;
        }
        Arrays.sort(sorted); //O(nlogn) to sort the elements.

        int count = 0;
        for(int j=0;j<A.length;j++){
            if(A[j] == sorted[j]) continue;
            else{
                if(count == 2) {
                    count++;
                    break;
                }
                count++;
            }
        }
        if(count > 2) return false;

        return true;
    }


    public static void main(String[] args) {
        Ex4 ex = new Ex4();
        System.out.println(ex.solution(new int[]{1,5,3,3,7}));

    }
}
