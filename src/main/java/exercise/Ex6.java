package exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by iniyan.paramasivam on 10/13/18.
 */
public class Ex6 {

    public static List<String> subStringsKDist(String inputStr, int num)
    {

        Set<String> set = new HashSet<>();
        String temp = "";
        int startPos = 0;
        for(int i=startPos;i<inputStr.length();i++){

            char c = inputStr.charAt(i);
            if(temp.indexOf(c) >= 0){
                temp = "";
                startPos++;
                i=startPos-1;
                continue;

            }
            temp = temp + c;
            if(num == temp.length()) {
                set.add(temp);
                temp = "";
                startPos++;
                i=startPos-1;
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        System.out.println(subStringsKDist("abcd",3));

    }
}
