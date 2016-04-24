package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by paramasivami on 4/24/16.
 */
public class DetectCycle {

    public static class Node {
        private int data;
        private List<Node> neighbours = new LinkedList<>();

        public Node(int data) {
            this.data = data;
            this.neighbours = neighbours;
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
    }

    public static String reverse(String s) {
        if (s == null) return s;
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    public static boolean detectCycle(Node root, Set<Integer> isVisited, boolean result, List<String> tempPath) {

        if (root == null) {
            result = false;
            System.out.println("In root null");
            return result;
        }

        if (isVisited.contains(root.data)) {
            System.out.println("Inside" + root.getData());
            result = true;
            return result;
        }
        //System.out.println(tempPath);
        isVisited.add(root.data);

        for (Node node : root.getNeighbours()) {
            System.out.print(root.data + " " + root.getNeighbours().size() + " " );
            String path = root.data + "" + node.data;

            System.out.println(tempPath);
            if(tempPath.size() == 0) {
                tempPath.add(path);
            }
            if (!pathExists(tempPath, path)) {
                if(!tempPath.get(0).equals(path))
                tempPath.add(path);
                result = detectCycle(node, isVisited, result, tempPath);
            }
//            else{
//                result = true;
//            }
            if (result) break;


        }
        return result;
    }

    private static boolean pathExists(List<String> tempList, String path) {

        for (String s : tempList) {
            if (s.equals(reverse(path)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.setNeighbours(Arrays.asList(node2,node5));

        node2.setNeighbours(Arrays.asList(node1,node3));

        node3.setNeighbours(Arrays.asList(node2,node4));

        node4.setNeighbours(Arrays.asList(node3,node5));

        node5.setNeighbours(Arrays.asList(node4,node1));

        System.out.println(detectCycle(node1, new HashSet<>(), false, new ArrayList<>()));
    }


}
