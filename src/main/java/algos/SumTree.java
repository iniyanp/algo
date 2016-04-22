package algos;

/**
 * Created by paramasivami on 4/18/16.
 */
public class SumTree {


    public static int sumTree(Node root){
        if(root == null) return 0;

        int left = sumTree(root.getLeft());
        int right = sumTree(root.getRight());

        int rootData = root.getData();

        //for non leaf node.
        if( !(root.getLeft() == null && root.getRight() == null))
            root.setData(left + right);

        return rootData + left + right;
    }

    public static void preOrder(Node root){

        if(root == null) return;
        System.out.println(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        second.setLeft(four);
        second.setRight(five);

        root.setLeft(second);
        root.setRight(third);

        sumTree(root);
        preOrder(root);

    }
}
