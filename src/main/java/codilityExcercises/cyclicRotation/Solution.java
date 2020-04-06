package codilityExcercises.cyclicRotation;

public class Solution {
    public int[] solution(int[] A, int K) {
        int[] resultArray = A;
        do {
            resultArray = moveOneIndexRIght(resultArray);
        } while (--K > 0);
        return resultArray;
    }

    private int[] moveOneIndexRIght(int[] A) {
        int [] resultArray = new int[A.length];
        for (int index = 0; index < A.length; index++){
            int value = A[index];
            int increasedIndex = index + 1;
            try {
                resultArray[increasedIndex] = value;
            } catch (ArrayIndexOutOfBoundsException endOfArray) {
                resultArray[0] = value;
            }
        }
        return resultArray;
    }
}
