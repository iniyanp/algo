class Solution {
    
    public Map<Integer, List<Integer>> constructGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graphMap = new HashMap<>();
            for(int i=0;i<prerequisites.length;i++) {
            
                if(graphMap.containsKey(prerequisites[i][0])) {
                    List<Integer> values = graphMap.get(prerequisites[i][0]);
                    values.add(prerequisites[i][1]);
                } else {
                    List<Integer> values = new ArrayList<>();
                    values.add(prerequisites[i][1]);
                    graphMap.put(prerequisites[i][0], values);
                }
            }
        return graphMap;
    }
    
    
    public Stack<Integer> findOrderHelper(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graphMap = constructGraph(numCourses, prerequisites);
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<Integer>();
        for(Integer key : graphMap.keySet()) {
            if(!visited.contains(key)) {
                dfs(graphMap, key, visited, stack);    
            }
            
        }
        return stack;
    }
    
    public void dfs(Map<Integer, List<Integer>> graphMap, int key, Set<Integer> visited, Stack stack) {

        //visit all the children of the key and finally push that key in stack
        List<Integer> children = graphMap.get(key);
        visited.add(key);
        if(children != null) {
         for(int i=0;i<children.size();i++) {
            if(visited.contains(children.get(i))) continue;
            else {
                visited.add(children.get(i));
                dfs(graphMap, children.get(i), visited, stack);
            }
                
        }   
        }
        stack.push(key);
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Map<Integer, List<Integer>> graphMap = constructGraph(numCourses, prerequisites);
        Stack<Integer> stack = findOrderHelper(numCourses, prerequisites);
        
        int[] result = new int[numCourses];
        int i = numCourses - 1;
        while(!stack.isEmpty()) {
            result[i] = stack.pop();
            System.out.println(result[i]);
            i--;
        }
        return result;
    }
}
