package interview.Google;

public class Test {

    public static void printAns(int n, int [] [] entryExitTimes) {
        int [] results = new int[n];

        for (int i=0; i<entryExitTimes.length; i++) {
            int entryTime = entryExitTimes[i][0];
            int exitTime = entryExitTimes[i][1];
            for (int j=entryTime; j<=exitTime; j++) {
                results[j]++;
            }
        }
        for (int i=0; i<n; i++) {
            System.out.println(results[i]);
        }
    }

    public static void printAnsAnotherWay(int n, int [][] entryExitTimes) {
        int[] results = new int[n];

        for (int i=0; i<entryExitTimes.length; i++) {
            int entryTime = entryExitTimes[i][0];
            int exitTime = entryExitTimes[i][1];

            results[entryTime]++;
            if (exitTime+1 < n) {
                results[exitTime]--;
            }
        }
        for (int i=1; i<n; i++) {
            results[i] = results[i-1] + results[i];
        }

        for (int i=0; i<n; i++) {
            System.out.println(results[i]);
        }

    }

    public static void main(String[] args) {
        int [] [] entryExitTimes = {{1,3}, {2,4}};
        printAns(5, entryExitTimes);
        System.out.println("Hi");
        printAnsAnotherWay(5, entryExitTimes);

    }


}
