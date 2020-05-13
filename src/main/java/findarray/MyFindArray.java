/*
   This file is provided exclusively for the purpose of Spartez Online Assessment.
   Unauthorized distribution of this file, derived work or information about its
   content, via any medium, is strictly prohibited.
 */
package findarray;

public class MyFindArray implements FindArray {

    public static final int FIRST_VALUE = 0;

    @Override
    public int findArray(int[] array, int[] subArray) {
        boolean isSubarrayFound = false;
        int latestFoundIndex = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index] == subArray[FIRST_VALUE]) {
                if (subArray.length == 1) {
                    isSubarrayFound = true;
                    if (index > latestFoundIndex) latestFoundIndex = index;
                    continue;
                }
                try {
                    isSubarrayFound = isSubarrayFound(array, subArray, index);
                } catch (IndexOutOfBoundsException notFound) {
                }
                if (isSubarrayFound) {
                    if (index > latestFoundIndex) latestFoundIndex = index;
                }
            }
        }
//		throw new UnsupportedOperationException("Please implement me!"); //TODO What to do with it?
        if (!isSubarrayFound) return -1;
        return latestFoundIndex;
    }

    private boolean isSubarrayFound(int[] array, int[] subArray, int index) {
        boolean isSubarrayFound = false;
        int tempIndex = index + 1;
        for (int subIndex = FIRST_VALUE + 1; subIndex < subArray.length; subIndex++) {
            if (array[tempIndex] == subArray[subIndex]) {
                if (subArray.length - 1 == subIndex) {
                    isSubarrayFound = true;
                }
            } else {
                isSubarrayFound = false;
                break;
            }
            tempIndex++;
        }
        return isSubarrayFound;
    }
}
