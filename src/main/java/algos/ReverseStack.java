package algos;

import java.util.Stack;

/**
 * Created by paramasivami on 4/24/16. => Loved it.
 */
public class ReverseStack {

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()) return;
        int temp = s.pop(); //storage using function call variable without using any external memory
        reverseStack(s);
        pushAtBottom(s, temp);
    }

    private static void pushAtBottom(Stack<Integer> s, int temp) {
        if(s.isEmpty()) {
            s.push(temp);
            return;
        }
        int temp1 =  s.pop();
        pushAtBottom(s,temp);
        s.push(temp1);

    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.forEach(
                element -> System.out.println(element)
        );
        reverseStack(s);
        System.out.println("#");
        s.forEach(
                element -> System.out.println(element)
        );
    }
}
