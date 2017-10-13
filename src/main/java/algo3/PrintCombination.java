package algo3;

/**
 * Created by paramin on 9/24/17.
 */
public class PrintCombination {


    public void combination(String input, String output,int index) {

        System.out.println(output);

        for(int i=index;i<input.length();i++)
            combination(input,output + input.charAt(i),i+1);

    }
    public static void main(String[] args) {
        PrintCombination p = new PrintCombination();
        p.combination("abcd","",0);
    }
}
