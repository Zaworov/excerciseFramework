package codilityExcercises.permMissingElement;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return 1;
        }
        Arrays.sort(A);
        for (int index = 0; index < A.length; index++) {
            int currentValue = A[index];
            int nextValue;
            try {
                nextValue = A[index + 1];
            } catch (ArrayIndexOutOfBoundsException endOfArray){
                return 1;
            }
            if (nextValue != currentValue + 1){
                return ++currentValue;
            }
        }
        return 0;
    }
}