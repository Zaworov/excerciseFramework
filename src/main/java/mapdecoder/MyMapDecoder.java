/*
   This file is provided exclusively for the purpose of Spartez Online Assessment.
   Unauthorized distribution of this file, derived work or information about its
   content, via any medium, is strictly prohibited.
 */
package mapdecoder;

import java.util.HashMap;
import java.util.Map;

public class MyMapDecoder implements MapDecoder {
    private static final int KEY = 0;
	private static final int VALUE = 1;
	private static final String VALUES_SEPARATOR = "&";
	private static final String KEY_VALUE_SEPARATOR = "=";

	@Override
    public Map<String, String> decode(String s) {
		HashMap<String, String> resultMap = new HashMap<>();
        if (s.isEmpty()) return resultMap;
		String[] separatedValues = separateValues(s);
		if (separatedValues == null) return null;
		for (String stringValue : separatedValues) {
            String[] valuePair = stringValue.split(KEY_VALUE_SEPARATOR);
            String key = valuePair[KEY];
            String value = valuePair[VALUE];
            if (!key.isEmpty() && !value.isEmpty()) {
                resultMap.put(key, value);
            }
        }
        return resultMap;
    }

	private String[] separateValues(String s) {
		String[] separatedValues;
		try {
			separatedValues = s.split(VALUES_SEPARATOR);
		} catch (NullPointerException givenStringIsNull) {
			return null;
		} catch (IllegalArgumentException exception) {
			throw new IllegalArgumentException("Given parameter should be string.");
		}
		return separatedValues;
	}
}
