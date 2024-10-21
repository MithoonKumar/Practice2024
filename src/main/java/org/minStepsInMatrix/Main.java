package org.minStepsInMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // Directions for movement (up, down, left, right)
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // BFS to find the minimum steps to reach the bottom-right corner
    public static int minSteps(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Edge case: If start or end is blocked
        if (matrix[0][0] == 1 || matrix[rows - 1][cols - 1] == 1) {
            return -1;
        }

        // Queue to hold the current position and the step count (row, col, steps)
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        // Start BFS from top-left corner
        queue.offer(new int[]{0, 0, 0});  // (row, col, steps)
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];

            // If we reach the bottom-right corner, return the number of steps
            if (row == rows - 1 && col == cols - 1) {
                return steps;
            }

            // Try to move in all 4 possible directions
            for (int[] dir : DIRECTIONS) {
                for (int jump = 1; jump < k; jump++) {
                    int newRow = row + dir[0] * jump;
                    int newCol = col + dir[1] * jump;

                    // Check if the new position is within bounds
                    if (isValid(newRow, newCol, matrix, visited)) {
                        queue.offer(new int[]{newRow, newCol, steps + 1});
                        visited[newRow][newCol] = true;  // Mark as visited
                    } else {
                        // If there's a '1' or out-of-bounds, stop further jumps in this direction
                        break;
                    }
                }
            }
        }

        // If we cannot reach the bottom-right corner, return -1
        return -1;
    }

    // Function to check if the position is within bounds and not visited, and it's a 0
    private static boolean isValid(int row, int col, int[][] matrix, boolean[][] visited) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length
                && matrix[row][col] == 0 && !visited[row][col];
    }

    public static void main(String[] args) {
        // Example test case
        int[][] matrix = {
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };
        int k = 3;

        int result = minSteps(matrix, k);
        System.out.println("Minimum steps: " + result);  // Output: Minimum steps
    }
}
