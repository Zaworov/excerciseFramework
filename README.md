# Decode a Map 

Implement the `mapdecoder.MyMapDecoder.decode(String)` method that decodes a `String` to a corresponding `Map`.
The `String` is composed of zero or more key-value pairs. A key is separated from its value with an 'equals' character (`=`). Pairs are separated with an 'ampersand' character (`&`). 
Example: `key=value&key=value&....`

Empty keys and values are allowed, but the equals sign must be present (e.g. `"=value"`, `"key="`).

If the key or value is empty, empty `String` should be returned.

If the given `String` is empty, an empty `Map` should be returned.

If the given `String` is null, `null` should be returned.

If the given `String` has an invalid format, an `IllegalArgumentException` should be thrown.

Sample Input: `one=1&two=2`
should return a Map containing `{"one": "1", "two": "2"}`

# Find Array 

Implement the `findarray.MyFindArray.findArray(int[] array, int[] subArray)` method that given two arrays as parameters will find the starting index where the second parameter occurs as a sub-array in the array given as the first parameter.

If given sub-array (second parameter) occurs more than once then the method should return the starting index of **the last occurrence**.

Your implementations should return `-1` if the sub-array cannot be found.

For extra points: implement it in an efficient way for large input arrays.

Sample Input:
```
[4,9,3,7,8] and [3,7] should return 2.
[1,3,5] and [1] should return 0.
[7,8,9] and [8,9,10] should return -1.
[4,9,3,7,8,3,7,1] and [3,7] should return 5.
```