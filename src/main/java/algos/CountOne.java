package algos;

/**
 * Created by paramasivami on 3/22/16.
 */
public class CountOne {


        // you need to treat n as an unsigned value
        public static int hammingWeight(int n) {
            if(n == 0) return 0;
            int count = 1;
            while(n/2 != 0){
                if(n%2 == 1) count++;
                n = n/2;
            }
            return count;
        }

    public static void main(String[] args) {
        System.out.println(hammingWeight(429496729));
    }
}
