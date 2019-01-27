package exercise;

/**
 * Created by iniyan.paramasivam on 10/3/18.
 */
public class ReverseInteger {

    public static int reverseInteger(int a) {
        int sum = 0, prev_sum=0;
        int multiply = 10;
        while(a > 0){
            int rem = a%10;
            a = a/10;
            sum = (sum * multiply ) + rem; //overflow occur . check whether this causes overflow or not.?
            if( (sum - rem)/multiply != prev_sum ) return  0;
            //reversing the above operation should give us previuos sum
            prev_sum = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Iniyan");
        // 2,147,483,647
        System.out.println(reverseInteger(1234567892));
    }
}
