package org.example;


import java.util.ArrayList;

class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[][] arr = {{1,4},{2,4},{3,1},{3,2}};
        boolean ans = solution2.canFinish(5, arr);

        System.out.println(ans);
    }

    private boolean detectCycle(int node, boolean [] visited, ArrayList<ArrayList<Integer>> adjMatrix) {
        visited[node] = true;
        boolean ans = true;
        for (int i=0; i<adjMatrix.get(node).size(); i++) {
            if (visited[adjMatrix.get(node).get(i)]) {
                return false;
            } else {
                ans = ans && detectCycle(adjMatrix.get(node).get(i), visited, adjMatrix);
            }
        }
        return ans;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            adjMatrix.add(new ArrayList<>());
        }
        for (int i=0; i<prerequisites.length; i++) {
            adjMatrix.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i=0; i<numCourses; i++) {

            boolean[] visited = new boolean[numCourses];
            for (int j=0; j<visited.length; j++) {
                visited[j] = false;
            }


            boolean ans = detectCycle(i, visited, adjMatrix);
            if (!ans) {
                return false;
            }

        }

        return true;

    }
}



