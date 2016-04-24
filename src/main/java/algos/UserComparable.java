package algos;
import java.util.*;
/**
 * Created by paramasivami on 4/22/16.
 */
public class UserComparable {

    public static class Node implements Comparable<Node>{
        private int data;
        private Node left;
        private Node right;
        Node(int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int compareTo(Node node){
            if(this.getData() > node.getData())
                return -1;
            else if(this.getData() < node.getData())
                return 1;
            else
                return 0;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(n1);
        queue.add(n3);
        queue.add(n2);
        System.out.println(queue.remove().getData());
        System.out.println(queue.remove().getData());
        System.out.println(queue.remove().getData());
        queue.forEach(
                node -> System.out.println(node.getData())
        );

    }
}
