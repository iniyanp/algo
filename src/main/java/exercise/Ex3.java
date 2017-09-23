package exercise;

/**
 * Created by paramin on 9/21/17.
 */
public class Ex3 {

    public int solution(int A, int B) {
        // write your code in Java SE 8

        if(A == 0 && B == 0) return 0;
        //To tackle leading zero.
        if(A == 0 && B != 0) {
            if(B > 100000000) return -1;
            return B;
        }

        String res = "";

        String firstStr = String.valueOf(A);
        String secondStr = String.valueOf(B);

        int i=0,j=0;

        while(i < firstStr.length() && j < secondStr.length()){
            res = res + firstStr.charAt(i) + secondStr.charAt(j);
            i++;
            j++;
        }

        while(i < firstStr.length()) res += firstStr.charAt(i++);
        while(j < secondStr.length()) res += secondStr.charAt(j++);


        try{
            int intRes = Integer.valueOf(res);
            if(intRes > 100000000) return -1;
            return intRes;
        }catch (Exception e) {
            return -1;
        }

    }

    public static void main(String[] args) {
        Ex3 ex = new Ex3();

        System.out.println(ex.solution(10000000,0));
    }
}
