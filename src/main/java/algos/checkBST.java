package algos;

/**
 * Created by paramasivami on 4/3/16.
 */
public class checkBST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private boolean result = true;
    private int prevValue = Integer.MIN_VALUE;

    public void InOrder(TreeNode root) {
        if (root == null) return;

        isValidBST(root.left);

        System.out.println("prev value " + prevValue);
        System.out.println("root value " + root.val);
        if (prevValue < root.val) {
            prevValue = root.val;
        } else {
            result = false;
            return;
        }

        isValidBST(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (root.val == Integer.MIN_VALUE) {
            InOrder(root.left);
            InOrder(root.right);
        } else {
            InOrder(root);
        }


        return result;

    }

    public static void main(String[] args) {
        checkBST checkBST = new checkBST();
        TreeNode root = checkBST.new TreeNode(2147483647);
        root.left = null;
        root.right = checkBST.new TreeNode(-2147483648);
        System.out.println(checkBST.isValidBST(root));

    }
}

