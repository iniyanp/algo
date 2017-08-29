package algos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paramasivami on 4/23/16.
 */
public class PermutationUsingList {


    public static void permute(List<Integer> elements, List<Integer> temp){

        if(elements.size() == 0){
            System.out.println(temp);
            //temp.remove(temp.size() - 1);
            return;
        }

        for(int i=0;i<elements.size();i++){

            int element = elements.remove(i);
            temp.add(element);

            permute(elements, temp);

            //Do the exact opposite of what you did before recursion.
            //If you remove the element in ith position, add the same element in ith position itself.
            elements.add(i,element);
            temp.remove(temp.size() - 1);
        }

    }


    public static void combine(List<Integer> input, List<Integer> output, int index){
//        System.out.println(input.size());
        for(int i=index;i<input.size();i++){

            output.add(input.get(i));
            System.out.println(output);
            combine(input, output, index+1);
            output.remove(output.size() - 1);
        }

    }

    public static void main(String[] args) {

        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        //System.out.println(elements);
        permute(elements,new ArrayList<>());
//        combine(elements, new ArrayList<>(),0);
    }
}
