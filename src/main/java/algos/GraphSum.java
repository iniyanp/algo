package algos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paramasivami on 4/9/16.
 */
public class GraphSum {

    public class Node{
        private int data;
        private List<Node> neighbours;
        private boolean visited;

        Node(){
            this.neighbours = new ArrayList<>();
            this.visited = false;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }

    public int calculateSum(Node root){

        int sum = 0;
        if(!root.isVisited()) {
            sum += root.getData();
            root.visited = true;
        }else{
            return 0;
        }

        for(int i=0; i< root.neighbours.size(); i++){
            sum += calculateSum(root.neighbours.get(i));
        }

        return sum;
    }

    public static void main(String[] args) {
        GraphSum g = new GraphSum();

        GraphSum.Node n = new GraphSum().new Node();
        n.setData(1);

        GraphSum.Node n1 = new GraphSum().new Node();
        n1.setData(2);

        GraphSum.Node n2 = new GraphSum().new Node();
        n2.setData(3);

        n.neighbours.add(n1);
        n.neighbours.add(n2);

        n1.neighbours.add(n);
        n1.neighbours.add(n2);

        n2.neighbours.add(n);
        n2.neighbours.add(n1);

        int sum = 0;
        System.out.println(g.calculateSum(n));

    }

}
