package algo4;

import java.util.HashMap;
import java.util.Map;

public class MinuimumWindowSubstring {

    public String findSubString(String s, String t){
        if(s == null || t == null) return "";
        if(s.equals("") || t.equals("")) return "";



        Map<Character, Integer> tmap = new HashMap<>();
        for(char c:s.toCharArray())
            tmap.put(c, 0);
        for(char c:t.toCharArray()){
            if(s.indexOf(c) == -1){
                return "";
            }
            tmap.put(c, tmap.get(c) + 1);

        }


        int start = 0;
        int i = 0;
        int target = t.length();
        int len = Integer.MAX_VALUE;
        String ans = "";

        while(true){
            char c = s.charAt(i);
            tmap.put(c, tmap.get(c) - 1);
            if(tmap.get(c) >= 0)
                target--;

            //Move the start pointer.
            while(target == 0){

                char c1 = s.charAt(start);
                tmap.put(c1, tmap.get(c1) + 1);
                //Removing the wanted character.
                //Check this condition inside.
                //Outside you might not reach that condition. Before itself,
                //we should have iterated all the characters.

                if(tmap.get(c1) > 0)
                    target++;

                //Update the result only when target > 0.
                if(target > 0){
                        if( (i - start) < len){
                            len = i - start;
                            ans = s.substring(start, start+len+1);
                        }
                }
                start++;
            }
            i++;
            if(i >= s.length()) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinuimumWindowSubstring m = new MinuimumWindowSubstring();
        String ans = m.findSubString("ADOBECODEBANC","ABC");
//        String ans = m.findSubString("a","b");
        System.out.println(ans);
    }
}
