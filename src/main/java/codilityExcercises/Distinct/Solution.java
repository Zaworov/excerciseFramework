package codilityExcercises.Distinct;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] A) {
        Set<Integer> distinctValues = new HashSet<>();
        for (int value : A) {
            distinctValues.add(value);
        }
        return distinctValues.size();
    }
}