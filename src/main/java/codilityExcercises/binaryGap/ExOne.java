package codilityExcercises.binaryGap;

public class ExOne {
    public int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        int distance = 0;
        int longestDistance = 0;
        boolean counting = false;
        for (char digit : binaryString.toCharArray()){
            if (counting && digit == '1') {
                if (distance > longestDistance) longestDistance = distance;
                distance = 0;
            }
            if (digit == '1') {
                counting = true;
            }
            if (counting && digit == '0') {
                distance++;
            }
        }
        return longestDistance;
    }
}
