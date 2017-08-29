package algo3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by paramin on 8/28/17.
 */
public class IterateMap {

    public static void iterateMap(Map<String, Integer> map) {
        Iterator it = map.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<String,Integer> entrySet = (Map.Entry)it.next();
            System.out.println(entrySet.getKey() + " " + entrySet.getValue());

        }
    }

    public static void main(String[] args) {
        Map m = new HashMap<String,Integer>();
        m.put("1",1);
        m.put("2",2);
        m.put("3",3);
        iterateMap(m);
    }
}
