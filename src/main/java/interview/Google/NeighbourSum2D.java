package interview.Google;

import java.util.Deque;
import java.util.LinkedList;

public class NeighbourSum2D {

    public static void sumNeighbour(int [][] matrix) {
        Deque<Integer> deque = new LinkedList<>();

        int rows = matrix.length;
        if (rows == 0) {
            return;
        }
        int cols = matrix[0].length;

        for (int i=0; i<cols; i++) {
            deque.add(0);
        }

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                int top = deque.getFirst();
                int left = 0, right = 0, bottom = 0;
                if (j-1>=0) {
                    left = deque.getLast();
                }
                if (i+1<rows) {
                    bottom = matrix[i+1][j];
                }
                if (j+1<cols) {
                    right = matrix[i][j+1];
                }
                int sum = top + left + right + bottom;
                deque.removeFirst();
                deque.addLast(matrix[i][j]);
                matrix[i][j] = sum;
            }
        }
    }



    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        sumNeighbour(matrix);

        // Print the updated matrix
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
