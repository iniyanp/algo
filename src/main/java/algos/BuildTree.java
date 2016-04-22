package algos;

import com.google.common.base.MoreObjects;

/**
 * Created by paramasivami on 3/22/16.
 */
public class BuildTree {

    /**
     * Definition for a binary tree node. */
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("val", val)
                    .add("left", left)
                    .add("right", right)
                    .toString();
        }
    }



    int count = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

            int inStart = 0;
            int inEnd = inorder.length - 1;
            return buildTreeFromOrder(inStart, inEnd, preorder, inorder);

        }

        public TreeNode buildTreeFromOrder(int inStart, int inEnd, int[] preorder, int[] inorder){

            if(inStart > inEnd) return null;
            int elem = preorder[count++];
            System.out.println(elem);
            TreeNode root = new TreeNode(elem);
//            if(inStart == inEnd) return root;
            int k = findPosInOrder(inorder, elem);

            root.left = buildTreeFromOrder(inStart, k-1, preorder, inorder);
            root.right = buildTreeFromOrder(k+1,inEnd, preorder, inorder);
            return root;

        }

        public int findPosInOrder(int[] inorder, int elem){
            int k = -1;
            for(int i=0; i < inorder.length; i++){
                if(inorder[i] == elem) k = i;
            }
            return k;
        }

    public static void main(String[] args) {
        BuildTree b = new BuildTree();
        int[] preOrder = {2,1,3};
        int[] inOrder = {1,2,3};
        System.out.println(b.buildTree(preOrder, inOrder));
    }
}
