package codilityExcercises.brackets;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int solution(String S) {
        String resultString = S;
        LinkedList<String> pairsOfBrackets = new LinkedList<>(Arrays.asList("\\(\\)", "\\{\\}", "\\[\\]"));
        while (resultString.contains("()") || resultString.contains("{}") || resultString.contains("[]")) {
            for (String bracketsPair : pairsOfBrackets) {
                resultString = resultString.replaceFirst(bracketsPair, "");
                if (resultString.isEmpty()) return 1;
            }
        }
        return 0;
    }
}
