package algos;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by paramasivami on 4/14/16.
 *
 * Should be the same logic as TOW
 */
public class MaxPathInBT {

    public class Node{

        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
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
    }

    public void traversal(Node root,List<Integer> innerResult,List<List<Integer>> result){

        if(root != null){
            if(root.getLeft() == null && root.getRight() == null){
                innerResult.add(root.getData());
                //Do deep copy.
                List<Integer> newList = new LinkedList<>();
                newList.addAll(innerResult);
                result.add(newList);
                if(innerResult.size() > 0) innerResult.remove(innerResult.size() - 1);
                return;
            }
            innerResult.add(root.getData());
            traversal(root.getLeft(), innerResult, result);
            traversal(root.getRight(), innerResult, result);
            if(innerResult.size() > 0) innerResult.remove(innerResult.size() - 1);
        }

    }

    public static void main(String[] args) {
        MaxPathInBT.Node root = new MaxPathInBT().new Node(10);
        MaxPathInBT.Node left = new MaxPathInBT().new Node(12);
        MaxPathInBT.Node right = new MaxPathInBT().new Node(18);

        MaxPathInBT.Node five = new MaxPathInBT().new Node(5);
        MaxPathInBT.Node six = new MaxPathInBT().new Node(6);

        MaxPathInBT.Node twenty = new MaxPathInBT().new Node(20);
        MaxPathInBT.Node twentytwo = new MaxPathInBT().new Node(22);
        MaxPathInBT.Node twentyfour = new MaxPathInBT().new Node(24);
        MaxPathInBT.Node twentyfive = new MaxPathInBT().new Node(25);
        MaxPathInBT.Node twentysix = new MaxPathInBT().new Node(26);
        twentyfour.setLeft(twentyfive);
        twentyfour.setRight(twentysix);

        twenty.setLeft(twentytwo);
        twenty.setRight(twentyfour);
        right.setRight(twenty);

        left.setLeft(five);
        left.setRight(six);
        root.setLeft(left);
        root.setRight(right);

        MaxPathInBT m = new MaxPathInBT();
        List<List<Integer>> result = new LinkedList<>();
        m.traversal(root, new LinkedList<>(), result);
        System.out.println(result.size());
        result.forEach(
                item -> {
                    item.forEach(
                            innerItem -> System.out.print(innerItem + " ")
                    );
                    System.out.println();
                }
        );
    }


}
