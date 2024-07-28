package algos7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxTree {
    static String path;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    class Node {
        int data;
        Node left;
        Node right;
        Node (int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    //2013 comment.
    //you can use the same method to print path as well. In that case, method should return a class,
    //which should have sum and the path.

    class Result {
        int sum;
        String path;
        Result(int sum, String path) {
            this.sum = sum;
            this.path = path;
        }

        @Override
        public String toString() {
            return sum + " " + path;
        }
    }
    public static Result MaxTreeM(Node root) {
        if(root.left == null && root.right == null) return new MaxTree().new Result(root.data, "" + root.data);
        Result left = MaxTreeM(root.left);
        Result right = MaxTreeM(root.right);
        int max =  Math.max(left.sum, right.sum);
        Result finalResult = null;
        if(max == left.sum) finalResult = new MaxTree().new Result(root.data + max, root.data + " ->" + left.path);
        else finalResult = new MaxTree().new Result(root.data + max, root.data + " -> " + right.path);

        return finalResult;
    }

    public static void verticalOrder(Node root, int pos) {
        if(root == null) return;
        if(map.containsKey(pos)) {
            map.get(pos).add(root.data);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(pos, list);
        }
        verticalOrder(root.left, pos - 1);
        verticalOrder(root.right, pos + 1);
    }

    public static void main(String[] args) {
        System.out.println("Iniyan");

        MaxTree tree = new MaxTree();
        MaxTree.Node seven = new MaxTree().new Node(7, null, null);
        MaxTree.Node two = new MaxTree().new Node(2, null, null);
        MaxTree.Node one = new MaxTree().new Node(1, null, null);
        MaxTree.Node three = new MaxTree().new Node(13, null, null);

        MaxTree.Node eight = new MaxTree().new Node(8, seven, two);
        MaxTree.Node nine = new MaxTree().new Node(9, one, three);
        MaxTree.Node ten = new MaxTree().new Node(10, eight, nine);

        verticalOrder(ten, 0);
        System.out.println(map);

        Result max = MaxTreeM(ten);
        System.out.println(max.sum);
        System.out.println(max.path);



    }
}
