package codilityExcercises.minAverageTwoSlice;

public class Solution {
    public int solution(int[] A) {
        int[] smallestAverageWithIndex = new int[]{0, 0};
        if (A.length == 0) return 0;
        for (int index = 0; index < A.length; index++){
            int index2 = index + 1;
            int firstValue = A[index];
            do {
                int secondValue;
                try {
                    secondValue = A[index2];
                } catch (ArrayIndexOutOfBoundsException endOfArray){
                    continue;
                }
                int average = (firstValue + secondValue) / 2;
                System.out.println(firstValue + " - " + secondValue);
                System.out.println("AV: " + average);
                if (index == 0 && index2 == 1) {
                    smallestAverageWithIndex[0] = average;
                }
                if (average < smallestAverageWithIndex[0]){
                    System.out.println("SAVED: " + average + " AT INDEX " + index);
                    smallestAverageWithIndex[0] = average;
                    smallestAverageWithIndex[1] = index;
                }

            } while (index2++ < A.length);
            System.out.println();
        }
        return smallestAverageWithIndex[1];
    }
}