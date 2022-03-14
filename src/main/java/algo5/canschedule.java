class Solution {
    
    
    public Map<Integer, List<Integer>> constructGraph(int numCourses, int[][] prerequisites) {
     
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i=0;i<prerequisites.length;i++) {
            int firstNode = prerequisites[i][0];
            int secondNode = prerequisites[i][1];
            if(graph.containsKey(firstNode)) {
                List<Integer> list = graph.get(firstNode);
                list.add(secondNode);
            } else {
                List<Integer> list= new LinkedList<>();
                list.add(secondNode);
                graph.put(firstNode, list);
            }
            
        }
        
        return graph;
    }
    
    public boolean dfsUtil(int node, boolean[] visited, boolean[] stack, Map<Integer, List<Integer>> graph, int numCourses) {
        
        
        if(stack[node] == true)
            return true;
        
        if(visited[node] == true)
            return false;
        
        visited[node] = true;
        
        stack[node] = true;
        
        System.out.println("stack[" + node + "] is " + stack[node]);
        
        List<Integer> children = graph.get(node);
        
        if(children != null) {
            for(int i=0;i<children.size();i++) {
                
            if(dfsUtil(children.get(i), visited, stack, graph, numCourses)) {
                System.out.println("i is" + i);
                return true;
            }
            
            }
            //reset stack
            stack[node] = false;
            
        }
        stack[node] = false;
        return false;
    }
    
    public boolean dfs(int numCourses, Map<Integer, List<Integer>> graph) {
        
        boolean visited[] = new boolean[numCourses];
        Iterator<Integer> keys = graph.keySet().iterator();
        
        while(keys.hasNext()) {
            Integer a = keys.next();
            System.out.println("keys to visit  " + a);
            boolean stack[] = new boolean[numCourses];
            boolean result = dfsUtil(a, visited, stack, graph, numCourses);
            System.out.println("result is " + result);
            if(result)
                return true;
        }
        return false;
        
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> graph = constructGraph(numCourses, prerequisites);
        System.out.println(graph);
        boolean result = dfs(numCourses, graph);
        System.out.println("Is cycle exists?" + result);
        
        return !result;
        
    }
}
