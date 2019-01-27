package exercise;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Ex9 {

    public static void combine(String input, String output, int start){

        System.out.println(output);
        for(int i = start; i < input.length(); i++)
            //Start is important.
            combine(input.substring(i + 1), output + String.valueOf(input.charAt(i)), start);
    }

    public static void main(String[] args) {
        System.out.println("Iniyan");
//        combine("0123","",0);
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(10,"Iniyan");
        map.put(1,"Kumar");
        map.put(5,"Thamarai");

       Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
       Iterator<Map.Entry<Integer,String>> iterator = entrySet.iterator();
       while(iterator.hasNext()){
           Map.Entry<Integer, String> entry = iterator.next();
           System.out.println(entry.getKey() + "\t" + entry.getValue());
       }
    }
}
