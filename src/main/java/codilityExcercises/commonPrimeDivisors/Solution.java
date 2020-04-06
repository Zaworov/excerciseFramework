package codilityExcercises.commonPrimeDivisors;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int[] A, int[] B) {
        int count = 0;
        for (int valueOne : A) {
            List<Integer> primeDivisorsOne = getPrimeDivisors(valueOne);
            for (int valueTwo : B) {
                List<Integer> primeDivisorsTwo = getPrimeDivisors(valueTwo);
                if (primeDivisorsOne.equals(primeDivisorsTwo)) count++;
            }
        }
        return count;
    }

    private List<Integer> getPrimeDivisors(int value) {
        List<Integer> primeDividers = new ArrayList<>();
        for (int divisor = 2; divisor <= value; divisor++) {
            if (isPrime(divisor)) {
                if (value % divisor == 0) {
                    primeDividers.add(divisor);
                }
            }
        }
        return primeDividers;
    }

    private boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
