package algo3;

/**
 * Created by paramin on 4/7/17.
 */

class Node{

    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}



public class PrintPath {

    public static void printOrder(Node root, String s){

        if(root == null) return;
        s += root.data + "->"; //Whenever the data comes just append it.
        if(root.left == null && root.right == null) System.out.println(s.substring(0,s.length()-2));
        printOrder(root.left, s);
        printOrder(root.right, s);
    }

    public static void main(String[] args) {

        Node n = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        second.left = third;
        second.right = fourth;
        n.left = second;
        n.right = fifth;
        printOrder(n,"");

    }

}
