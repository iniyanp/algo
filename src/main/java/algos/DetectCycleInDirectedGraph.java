package algos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by paramasivami on 4/24/16.
 */
public class DetectCycleInDirectedGraph {
    /**
     * Notion of Directed Graph. *
     */

    private boolean found = false;

    public static class Graph {
        int noOfVertices;
        List<List<Integer>> adjacenyList = new LinkedList<>();

        public Graph(int v) {
            this.noOfVertices = v;
            populateList();

        }

        private void populateList() {

            for (int i = 0; i < this.noOfVertices; i++) {
                this.adjacenyList.add(i, new LinkedList<>());
            }
        }

        public void addEdges(int v, int e) {
            adjacenyList.get(v).add(e);
        }

    }

    private  boolean detect(Graph g) {
        List<Boolean> visited = new LinkedList<>();

        for (int i = 0; i < g.noOfVertices; i++) {
            visited.add(i, false);
        }
        List<List<Integer>> adjList = g.adjacenyList;

        for (int i = 0; i < g.noOfVertices; i++) {
            Set<String> paths = new HashSet<>();
            detectUtil(i, adjList, paths);
            if(this.found){
                return true;
            }
            System.out.println("###");
        }

        return false;
    }

    private  void detectUtil(int v, List<List<Integer>> adjList, Set<String> paths){
        for(Integer neighbour : adjList.get(v)){
            String path = v + " " + neighbour;
            System.out.println(paths);
            if(paths.contains(path)) {
                //Update the class level variable.
                this.found = true;
                return;
            }
            paths.add(path);
            detectUtil(neighbour, adjList, paths);
        }
        return;
    }



    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdges(0, 1);
        g.addEdges(1, 2);
        g.addEdges(2, 3);
        g.addEdges(3, 0);
        DetectCycleInDirectedGraph d = new DetectCycleInDirectedGraph();
        System.out.println(d.detect(g));
    }
}
