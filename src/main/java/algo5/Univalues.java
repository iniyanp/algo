package algo5;

public class Univalues {

    static int result = 0;

    static class Node {
        int data;
        int sum;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }

    public static int findUniValues(Node root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            root.sum = 1;
            result = result + 1;
            return 1;
        }
        int leftSum = findUniValues(root.left);
        int rightSum = findUniValues(root.right);

        if (root.left == null) {
            if (root.data == root.right.data && rightSum == 1) {
                result = result + 1;
                root.sum = 1;
            }
        } else if (root.right == null) {
            if (root.data == root.left.data && leftSum == 1) {
                result = result + 1;
                root.sum = 1;
            }
        } else {
            if (root.data == root.left.data && root.data == root.right.data && leftSum == 1 && rightSum == 1) {
                result = result + 1;
                root.sum = 1;
            }
        }
        return root.sum;
    }

    public static void main(String[] args) {

        Node n1 = new Node(5);
        Node n2 = new Node(1);
        Node n3 = new Node(5);
        Node n4 = new Node(5);
        Node n5 = new Node(5);
        Node n6 = new Node(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;

        findUniValues(n1);
        System.out.println(result);

    }
}
