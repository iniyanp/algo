package algo4;

import java.util.*;

public class FactorCombination {

    List<List<Integer>> result = new LinkedList<>();

    public void combine(int target, int sum, List<Integer> innerResult) {

        if(target == sum) {
            List<Integer> temp = new LinkedList<>(innerResult);
            result.add(temp);
            return;
        } else if(sum > target)
            return;

        for(int i=2;i<=(target/2);i++){
            innerResult.add(i);
            combine(target,sum * i, innerResult);
            //Once the function returns remove what you did.
            if(innerResult.size() > 0)
                innerResult.remove(innerResult.size()-1);
        }

    }

    public static void main(String[] args) {

        FactorCombination f = new FactorCombination();
        f.combine(12,1, new LinkedList<>());
        System.out.println(f.result);


        Map<Integer,Integer> map  = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
