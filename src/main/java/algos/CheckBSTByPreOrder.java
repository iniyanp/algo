package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by paramasivami on 4/18/16.
 */
public class CheckBSTByPreOrder {

    private static void checkBST(Stack<Integer> stack, List<Integer> nos){

        //Incomplete.

        for(int i = 0; i < nos.size(); i++){

            while(!stack.isEmpty() && (stack.peek() < nos.get(i))){
                stack.pop();
            }
            stack.push(nos.get(i));
        }

    }

    public static void main(String[] args) {

        List<Integer> nos = Arrays.asList(1,2,3,4,5,6);

    }
}
