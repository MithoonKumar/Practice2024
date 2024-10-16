package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UberScreening {



    public static void main(String[] args) {
        int [][] arr = {{0,1}, {2,0}, {2,1}}; // NOT A CYCLE
        int [][] arr1 = {{1,0}, {0,2}, {2,1}}; // CYCLE
        System.out.println(canFinish(3, arr));
    }

    private static boolean isPossible;

    public static void dfs(int node, HashSet<Integer> hashSet, boolean [] visited, List<List<Integer>> adjList) {
        if (!isPossible) {
            return;
        }
        if (hashSet.contains(node)) {
            isPossible = false;
            return;
        }
        visited[node] = true;
        hashSet.add(node);

        for (int i=0; i<adjList.get(node).size(); i++) {

            if (!isPossible) {
                return;
            }
            int nextNode = adjList.get(node).get(i);
            if (visited[nextNode]) {
                return;
            }
            dfs(nextNode, hashSet, visited, adjList);
        }
        hashSet.remove(node);
    }



    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        isPossible = true;

        for (int i=0; i<prerequisites.length; i++) {
            int first = prerequisites[i][0];
            int second = prerequisites[i][1];
            List<Integer> currList = adjList.get(second);
            currList.add(first);
        }

        HashSet<Integer> hashSet = new HashSet<>();
        boolean[] visited = new boolean[numCourses];
        for (int i=0; i<visited.length; i++) {
            visited[i] =false;
        }
        for (int i=0; i<visited.length; i++) {
            if (!visited[i]) {
                dfs(i, hashSet, visited, adjList);
                if (!isPossible) {
                    return false;
                }
            }
        }

        return isPossible;
    }

}
