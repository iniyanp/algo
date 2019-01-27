package exercise;

/**
 * Created by iniyan.paramasivam on 10/13/18.
 */
public class Ex5 {


    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
        public Node constructTree(int[] values, int n) {

            Node root = new Node(values[0]);
            for(int i=1; i<n; i++){
                Node b= new Node(values[i]);
                Node a = root;

                while(true){
                    if(b.data <= a.data){
                        if(a.left == null){

                            a.left = b;
                            break;
                        }
                        else
                            a = a.left;
                    }
                    else if(b.data > a.data){
                        if(a.right == null){

                            a.right = b;
                            break;
                        }
                        else
                            a = a.right;
                    }
                }

            }

            return root;

        }

        public Node LCA(Node root, int n1, int n2){
            if(root == null) return root;
            if(root.data == n1 || root.data == n2) return root;

            Node left = LCA(root.left, n1, n2);
            Node right = LCA(root.right, n1, n2);
            if(left != null && right != null) return root;
            if(left!= null)
                return left;
            else
                return  right;

        }

        public int findLevel(Node root, int no, int level){
            if(root == null) return -1;
            if(root.data == no) return level;
            int left = findLevel(root.left, no, level + 1);
            if(left == -1)
                return findLevel(root.right, no, level + 1);
            return left;
        }

        public int bstDistance(int[] values, int n,
                               int node1, int node2)
        {
            if(values == null || values.length == 0) return -1;
            Node root = constructTree(values,n);
            System.out.println(maxSum(root));
            Node lca = LCA(root,node1, node2);
            int first = findLevel(lca,node1,0);
            int second = findLevel(lca,node2,0);
            if(first == -1 || second == -1){
                return -1;
            }
            return first + second;
        }

        public int maxSum(Node root){
            if(root == null) return 0;
            return root.data + Math.max(maxSum(root.left),maxSum(root.right));
        }

        public static void  main(String args[]){
            Ex5 e = new Ex5();
            e.bstDistance(new int[]{5,6,3,1,2,4},6,2,4);

        }

    }

