package algo4;


import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        System.out.println("Iniyan");
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(2,3);
        map.put(1,2);
        map.put(10,2);
        map.put(4,2);
        int key = ((TreeMap<Integer, Integer>) map).lastKey();

        System.out.println(key);
    }
}
