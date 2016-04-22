package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by paramasivami on 4/21/16.
 */
public class KnapSack {


    public static int ks(List<Integer> val, int totalWeight, int maxWeight){

        if(totalWeight <= 0 || val.size() <= 0) return maxWeight;

            if(totalWeight < val.get(val.size() - 1)){
                int elem = val.remove(val.size() -1);
                int result = ks(val, totalWeight, maxWeight);
                //val.add(elem);
                return result;
            }else{

                int element = val.remove(val.size()-1);

                int first = ks(val, totalWeight - element, maxWeight + element);
                int second = ks(val, totalWeight, maxWeight);
                //val.add(element);
                return Math.max(first, second);
            }

    }

    public static void main(String[] args) {

        List<Integer> val = new ArrayList<>();
        val.add(1);
        //val.add(2);
        val.add(5);
        val.add(10);

        System.out.println(ks(val, 9, 0));


    }

}
