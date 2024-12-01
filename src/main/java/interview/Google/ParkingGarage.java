package interview.Google;

import java.util.ArrayList;
import java.util.List;

public class ParkingGarage {

    public static int[] calculateCarsInGarage(int N, List<int[]> tickets) {
        int[] result = new int[N+1]; // Result array of size N+1

        for (int[] ticket : tickets) {
            int entry = ticket[0];
            int exit = ticket[1];

            // Increment the count for the entry point
            result[entry]++;
            // Decrement the count after the exit point
            if (exit < N) {
                result[exit+1]--;
            }
        }

        // Convert the array into a prefix sum to compute the number of cars at each segment
        for (int i = 1; i < N+1; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5; // Number of segments
        List<int[]> tickets = new ArrayList<>();
        tickets.add(new int[]{1, 3});
        tickets.add(new int[]{2, 4});

        int[] result = calculateCarsInGarage(N, tickets);

        // Print the result
        for (int i=0; i<N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
