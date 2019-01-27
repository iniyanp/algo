package exercise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iniyan.paramasivam on 10/6/18.
 */
public class Combination {
    public static ArrayList<String> resultList = new ArrayList<>();

    public static void combine(ArrayList<String> list){
        if(list.size() > 0){
            String element = list.remove(0);
            combine(list);
            int size = resultList.size();
            for(int i=0;i<size;i++)
                resultList.add(element + resultList.get(i));
        }
    }

    /**
     * Because divide by 2 returns Overflow in some cases.
     * @param no
     * @return
     */
    public static  int countOne(int no) {
        int count = 0;
        for(int i=0;i<32;i++){
            int shiftedResult = (no >> i);
            if( ( shiftedResult & 1) != 0) count++;
        }
        return count;
    }

    public static void printCombinations(String input, String output){
        System.out.println(output);
        for(int i=0;i<input.length();i++)
            printCombinations(input.substring(i+1), output + String.valueOf(input.charAt(i)));
    }

    public static void main(String[] args) {
//        ArrayList<String> a = new ArrayList<>();
//        a.add("1");
//        a.add("2");
//        a.add("3");
//        resultList.add("");
//        combine(a);
//        System.out.println(resultList);
//        System.out.println(countOne(1023));
        printCombinations("abcd", "");
    }
}
