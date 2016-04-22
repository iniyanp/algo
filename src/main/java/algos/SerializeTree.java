package algos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by paramasivami on 4/10/16.
 */
public class SerializeTree {

    //Tree Node.
    public static class Node{
        private int data;
        //Set of children.
        private List<Node> children;

        public Node(){
            this.children = new ArrayList<>();
        }
        public Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public void addChildrenNode(Node child){
            this.children.add(child);
        }
    }

    public static StringBuffer traversal(StringBuffer s, Node root){

        if(root.getChildren().size() == 0) {
            s.append(String.valueOf(root.data)).append(",");
            s.append("#").append(",");
        }
        else{
            s.append(String.valueOf(root.data)).append(",");
            root.children.forEach(
                    child -> traversal(s, child)
            );
            //To mark the no of children is over.
            s.append("#").append(",");
        }


        return s;
    }

    public static Node constructTreeIter(Queue queue){
        Stack<Node> stack = new Stack<>();
        Node node = new Node();
        while (!queue.isEmpty()){
            String s = (String)queue.remove();
            if(!s.equals("#")){
                stack.push(new Node(Integer.parseInt(s)));
            }else{
                node = stack.pop();
                if(stack.isEmpty()) break;
                stack.peek().addChildrenNode(node);
            }
        }
        return node;
    }

    public static void main(String[] args) {


        //construct tree.
        Node s1 = new Node(1);
        Node s2 = new Node(2);
        Node s3 = new Node(3);

        Node s5 = new Node(5);
        Node s4 = new Node(4);

        Node s8 = new Node(8);
        Node s9 = new Node(9);

        s2.setChildren(Arrays.asList(s5,s4));
        s1.setChildren(Arrays.asList(s2,s8,s9));

        StringBuffer result = traversal(new StringBuffer(),s1);
        Queue<String> queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(result.toString().split(",")));

        //Serialize it.
        queue.forEach(System.out::print);

        System.out.println();

        Node resultNode = constructTreeIter(queue);
        System.out.println(traversal(new StringBuffer(),resultNode));


    }

}
