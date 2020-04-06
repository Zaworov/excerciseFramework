package codilityExcercises.longestPassword;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public int solution(String S) {
    String[] words = S.split(" ");
    int maxPasswordLength = -1;
    for (String word : words){
        if (!isValidPassword(word)) {
            continue;
        }
        if (word.length() > maxPasswordLength) maxPasswordLength = word.length();
    }
        return maxPasswordLength;
    }

    private boolean isValidPassword(String word) {
        if (!word.matches("[a-zA-Z0-9]+")) return false;
        int numberOfLetters = count(word, "[a-zA-Z]");
        int numberOfDigits = count(word, "\\d");
        if (numberOfLetters % 2 != 0) return false;
        if (numberOfDigits % 2 == 0) return false;
        return true;
    }

    private int count(String word, String stringPattern) {
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(word);
        int counter = 0;
        while (matcher.find()){
            counter++;
        }
        return counter;
    }
}