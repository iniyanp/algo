package exercise;

import java.util.ArrayList;

public class NumCourses {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            //0,1,2,3,4
            //1,2,3,4,5
            //If we need to take the course mentioned int the value,
            //we need to finish the course present in index.
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = false; //This is very important.
        return true;
    }

    public int findSqrt(int n) {
        int right = Integer.MAX_VALUE;
        int left = 0; //This is important.
        int mid = 0;
        while(true){

            mid = (right + left) / 2;

            if(mid == n/mid) break;

            if(mid < n/mid) {
                left = mid;
                if( (mid + 1) > n / (mid + 1) )
                    break;
            }
            else
                right = mid;
        }
        return mid;
    }



    public static void main(String[] args) {
        NumCourses n = new NumCourses();
        int[][] prereq = new int[][]{{5,4},{4,3},{3,2},{2,1},{1,0}};
//        System.out.println(n.canFinish(6,prereq));
        System.out.println(n.findSqrt(35));
    }
}
