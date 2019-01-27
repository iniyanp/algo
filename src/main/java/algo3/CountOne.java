package algo3;

/**
 * Created by paramin on 10/6/17.
 */
public class CountOne {


    public static void main(String[] args) {

        int n = 7;
        int count = 0;

        while(n != 0){
            if((n & 1) == 1)
                count++;
            n >>= 1;
        }

        System.out.println(count);
    }
}
