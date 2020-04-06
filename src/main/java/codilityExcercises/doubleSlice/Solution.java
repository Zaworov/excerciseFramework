package codilityExcercises.doubleSlice;

public class Solution {
    public int solution(int[] A) {
        int sum = 0;
        for (int firstCut = 0; firstCut < A.length; firstCut++) {
            for (int secondCut = firstCut + 1; secondCut < A.length; secondCut++) {
                for (int thirdCut = secondCut + 1; thirdCut < A.length; thirdCut++) {
                    int firstCutSum = 0;
                    for (int i = firstCut + 1; i < secondCut; i++) {
                        firstCutSum = firstCutSum + A[i];
                    }
                    int secondCumSum = 0;
                    for (int i = secondCut + 1; i < thirdCut; i++) {
                        secondCumSum = secondCumSum + A[i];
                    }
                    int twoCutsSum = firstCutSum + secondCumSum;
                    if (twoCutsSum > sum) sum = twoCutsSum;
                }
            }
        }
        return sum;
    }
}