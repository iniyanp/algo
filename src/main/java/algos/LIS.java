package algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paramasivami on 4/9/16.
 */
public class LIS {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(4);

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i< list.size(); i++){
            List<Integer> tempList = new ArrayList<>();

            for(int j=i+1; j < list.size(); j++){

//                if(map.containsKey(list.get(j))) {
//                    tempList = map.get(list.get(j));
//                    break;
//                }

                if(list.get(i) < list.get(j)){
                    tempList.add(list.get(j));
                }
            }
            map.put(list.get(i), tempList);
        }

    }
}
