package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iniyan.paramasivam on 10/20/18.
 */
public class strabo {

    List<String> one = Arrays.asList("0","1","8");
    List<String> two = Arrays.asList("00","11","88","69","96");

    List<List<String>> finalResult = new ArrayList<>();

    public List<String> calcEvenNo(int n) {
        int newN = n - 2;
        List<String> first = findNo(2);
        List<String> second = findNo(newN);
        List<String> result = new ArrayList<>();
        for(String s: second) {
            for (String f : first) {
                String newStr = f.substring(0,1) + s + f.substring(1);
                System.out.println(newStr);
                result.add(newStr);
            }
        }
        return result;
    }

    public List<String> findNo(int n) {
        if(n==1) return one;
        if(n==2) return two;

        //TODO: cache the results.
        //Remove the no s starting with zero from the final result.

        List<String> result = new ArrayList<>();

        if(n%2 == 1){
            //If n is odd no.
            int newN = n - 1;
            List<String> first = findNo(1);
            List<String> second = findNo(newN);

            for(String s: second){
                for(String f:first){
                    int len = s.length();
                    String newStr = s.substring(0,len/2) + f + s.substring(len/2,len);
//                    System.out.println(newStr);
                    result.add(newStr);
                }
            }
        }
        else{
            result = calcEvenNo(n);
        }
        finalResult.add(result);
        return result;

    }

    public static void main(String[] args) {

        strabo s = new strabo();
        List<String> result = s.findNo(5);
        for(String s1:result){
            System.out.println(s1);
        }
    }

}
