package exercise;

/**
 * Created by iniyan.paramasivam on 10/3/18.
 */
public class TreeOrder {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void preOrder(Node node, int level){
        if(node == null) return;
        System.out.println(node.data + "\t" + level);
        preOrder(node.left,level+1);
        preOrder(node.right,level+1);
    }

    public static void main(String[] args) {
        TreeOrder.Node two = new TreeOrder.Node(2,null,null);
        TreeOrder.Node three = new TreeOrder.Node(3,null,null);
        TreeOrder.Node one = new TreeOrder.Node(1,null,null);
        TreeOrder.Node four = new TreeOrder.Node(4,null,null);
        TreeOrder.Node five = new TreeOrder.Node(5,null,null);
        TreeOrder.Node six = new TreeOrder.Node(6,null,null);

        one.left = two;
        one.right = three;
        three.right = four;
        four.right = five;
        five.right = six;
        preOrder(one,0);

    }


}
