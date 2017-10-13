package exercise;

/**
 * Created by paramin on 9/16/17.
 */
public class Ex2 {


    Node root;

    class Node{

        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public Node insertNode(Node root, int data) {

        if(root == null){
            Node n  = new Node(data,null,null);
            return n;
        }
        else{
            if(root.data < data)
                root.right = insertNode(root.right, data);

            else
                root.left = insertNode(root.left, data);

        }
        return root;
    }

    public void insert(int data){
        root = insertNode(root,data);
    }



    public int bstDistance(int[] values, int n,
                           int node1, int node2)
    {
        // WRITE YOUR CODE HERE


        boolean first = false;
        boolean second = false;

        for(int i=0;i<values.length;i++){
            if(values[i] == node1) first = true;
            if(values[i] == node2) second = true;

        }

        if(first == false || second == false) return -1;


        for(int i=0;i<values.length;i++){
            insert(values[i]);
        }

        int x = pathLen(root,node1) - 1;
        int y = pathLen(root,node2) - 1;

        Node lca = lca(root,node1,node2);
        int lcaPathLen = pathLen(root,lca.data) - 1;
        return x + y - 2 * lcaPathLen;
    }

    public Node lca(Node root, int n1, int n2) {
        if(root == null) return null;

        if(root.data > n1 && root.data > n2) return lca(root.left, n1,n2);
        if(root.data < n1 && root.data < n2) return lca(root.right, n1,n2);

        return root;

    }


    /**
     * It is not necesary that function has to return true.
     * Function might return something.But you have to return boolean condition based on that.
     *
     * @param root
     * @param n1
     * @return
     */
    public int pathLen(Node root, int n1) {

        if(root != null){
            int len = 0;
            if((root.data == n1) || (len = pathLen(root.left, n1)) > 0 || (len = pathLen(root.right, n1)) > 0){
                return len + 1;
            }
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {

    Ex2 e = new Ex2();
        System.out.println(e.bstDistance(new int[]{5,6,3,1,2,4},6,2,4));

    }
}
