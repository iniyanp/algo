package algo3;

/**
 * Created by paramin on 9/12/17.
 */
public class MyCombine {

    public static void combine(String input, String output, int index) {
        System.out.println(output);
        for(int i=index;i < input.length();i++)
            combine(input,output + String.valueOf(input.charAt(i)), i+1);
    }

    public static void main(String[] args) {
        combine("abc","",0);
    }
}
