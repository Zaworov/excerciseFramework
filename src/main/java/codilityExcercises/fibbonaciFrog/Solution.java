package codilityExcercises.fibbonaciFrog;

import java.util.ArrayList;
import java.util.List;

//TODO Name excercises properly
//TODO To finish!

public class Solution {
    public int solution(int[] A) {
        int distanceToEnd = A.length;
        List<Integer> availableJumps = getAvailableJumps(distanceToEnd);
        return 0;
    }

    private List<Integer> getAvailableJumps(int distanceToEnd) {
        List<Integer> availableJumps = new ArrayList<>();
        for (int distance = 0; distance <= distanceToEnd; distance++){
            int fibbonacci = getFibbonaci(distance);
            if (fibbonacci > distanceToEnd) return availableJumps;
            availableJumps.add(fibbonacci);
        }
        return availableJumps;
    }

    private int getFibbonaci(int distance) {
        if (distance <= 1) return distance;
        return getFibbonaci(distance - 1) + getFibbonaci(distance - 2);
    }
}