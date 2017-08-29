package algo3;

/**
 * Created by paramin on 8/16/17.
 */
public class ReverseString {

    public static String reverseString(String s){

        if(s == null || s.equals("")) return s;
        else return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abc"));
    }
}
