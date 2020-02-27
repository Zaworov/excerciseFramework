package atenaExcercises.ex1;

public class Solution {

    public static final String NEGATIVE_INDICATOR = "-";

    public int solution(int N) {
        String stringNumber = String.valueOf(N);
        boolean isInputNegative = stringNumber.contains(NEGATIVE_INDICATOR);
        int biggestPossibleNumber = 0;
        for (int index = 0; index <= stringNumber.toCharArray().length; index++) {
            if (isInputNegative && index == 0) {
                String positiveStringNumber = stringNumber.replace(NEGATIVE_INDICATOR, "");
                biggestPossibleNumber = Integer.parseInt(("-").concat("5").concat(positiveStringNumber));
                continue;
            }
            String numberWithInsertedDigit = insertCharAtCertainPosition(stringNumber, index);
            int resultNumber = Integer.parseInt(numberWithInsertedDigit);
            if (isInputNegative && resultNumber > biggestPossibleNumber) {
                biggestPossibleNumber = resultNumber;
            } else {
                if (resultNumber > biggestPossibleNumber) biggestPossibleNumber = resultNumber;
            }
        }
        return biggestPossibleNumber;
    }

    private String insertCharAtCertainPosition(String textNumber, int index) {
        if (index == 0) return "5".concat(textNumber);
        String prefix = textNumber.substring(0, index);
        String sufix = textNumber.substring(index, textNumber.toCharArray().length);
        return prefix.concat("5").concat(sufix);
    }
}