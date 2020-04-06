package codilityExcercises.absoluteDistinct;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] A) {
        Set<Integer> uniqueAbsoluteNumber = new HashSet<Integer>();
        for (int number : A) {
            uniqueAbsoluteNumber.add(Math.abs(number));
        }
        return uniqueAbsoluteNumber.size();
    }
}