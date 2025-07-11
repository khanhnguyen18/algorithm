package brown;

import java.util.*;


public class RoadRoller {
    

    public int solution(int[] X, int[] Y, int W) {
        List<int[]> arraySortedByX = new ArrayList<>();
        for (int i = 0; i < X.length; i++) {
            arraySortedByX.add(new int[]{X[i], Y[i]});
        }
        arraySortedByX.sort(Comparator.comparingInt(a -> a[0]));
        
        int turns = 0;
        int current = 0;
        
        while (current < arraySortedByX.size()) {
            turns++;
            int x = arraySortedByX.get(current)[0];
            while (current < arraySortedByX.size() && arraySortedByX.get(current)[0] <= x + W) {
                current++;
            }
        }
        
        return turns;
    }

    public static void main(String[] args) {
        RoadRoller solution = new RoadRoller();

        // Create the test case from testWith1000Points
        int[] X = new int[1000];
        int[] Y = new int[1000];

        for (int i = 0; i < 1000; i++) {
            X[i] = i + 1;
            Y[i] = 1;
        }

        int W = 10;
        int result = solution.solution(X, Y, W);

        System.out.println("Expected: 100, Actual: " + result);

        // Debug the algorithm
        System.out.println("\nDebugging the algorithm:");
        int coverage = 0;
        int turns = 0;

        for (int i = 0; i < X.length; i += coverage) {
            turns++;
            int startX = X[i];
            int endX = startX + W;

            // Count how many points are covered in this turn
            coverage = 0;
            for (int j = i; j < X.length && X[j] <= endX; j++) {
                coverage++;
            }

            System.out.println("Turn " + turns + ": Starting at X=" + startX +
                ", covering points from index " + i + " to " + (i + coverage - 1) +
                " (X values from " + startX + " to " + X[i + coverage - 1] + ")");
        }

        System.out.println("\nTotal turns needed: " + turns);
    }
    
}