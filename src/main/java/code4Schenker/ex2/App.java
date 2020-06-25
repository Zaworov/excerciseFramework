package code4Schenker.ex2;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO 1) Spróbować stworzyć klasę osobną dla Domeny: dwie kolekcje trzymające domene i liczbę
//TODO 2) SortedMap / Treemap

class App
{
    public String extract(String HTML_code) throws java.lang.Exception
    {
        HashMap<String, Integer> domainMap = getDomainsMap(HTML_code);
        String answer = buildAnswer(domainMap);
        return answer;
    }

    private String buildAnswer(HashMap<String, Integer> domainMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String domainName : domainMap.keySet()) {
            stringBuilder.append(domainName).append(": " ).append(domainMap.get(domainName)).append(", ");
        }
        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 2);
    }

    private HashMap<String, Integer> getDomainsMap(String html_code) {
        HashMap<String, Integer> domainMap = new HashMap<>();
        Pattern domainPattern = Pattern.compile("https?://w*\\.?([a-zA-Z\\-]+\\.[a-zA-Z]+)\\/?", Pattern.DOTALL);
        Matcher domainMatcher = domainPattern.matcher(html_code);
        while (domainMatcher.find()){
            String domainName = domainMatcher.group(1);
            if (domainMap.containsKey(domainName)) {
                int currentNumber = domainMap.get(domainName);
                domainMap.replace(domainName, ++currentNumber);
            } else {
                domainMap.put(domainName, 1);
            }
        }
        return domainMap;
    }
}