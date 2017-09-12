package algo3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paramin on 9/3/17.
 */
public class GenerateParantheses {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){

        System.out.println(open + "\t" + close);
        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    public static void main(String[] args) {
        generateParenthesis(3).forEach(x -> System.out.println(x));
    }

}
