package algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by paramasivami on 4/24/16.
 */
public class TopologicalSort {

    /**
     * Notion of Directed Graph. *
     */
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

    private static void sort(Graph g) {
        List<Boolean> visited = new LinkedList<>();

        for (int i = 0; i < g.noOfVertices; i++) {
            visited.add(i, false);
        }
        List<List<Integer>> adjList = g.adjacenyList;

        Stack<Integer> result = new Stack<>();

        for (int i = 0; i < g.noOfVertices; i++) {
            sortUtil(i, adjList, visited, result);
        }
        //System.out.println(result.size());
        System.out.println("##");
        //Topo sort
        while (!result.isEmpty()) System.out.println(result.pop());
    }

    private static void sortUtil(int v, List<List<Integer>> adjList, List<Boolean> visited, Stack<Integer> stack) {

        if(!visited.get(v)){
            //DFS
            System.out.println(v);
            visited.set(v, true);
            for (int neighbour : adjList.get(v)) {
                sortUtil(neighbour, adjList, visited, stack);
            }
            stack.push(v);
        }
    }

    public static void main(String[] args) {
//        Graph g = new Graph(3);
//        g.addEdges(0, 1);
//        g.addEdges(0, 2);
//        g.addEdges(2, 1);
        Graph g = new Graph(6);
        g.addEdges(5, 2);
        g.addEdges(5, 0);
        g.addEdges(4, 0);
        g.addEdges(4, 1);
        g.addEdges(2, 3);
        g.addEdges(3, 1);
        sort(g);
        System.out.println(g.adjacenyList);

    }
}
