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
        int firstFoundIndex = 0;
        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index] + " + " + subArray[FIRST_VALUE]);
            if (array[index] == subArray[FIRST_VALUE]) {
                if (subArray.length == 1) {
                    isSubarrayFound = true;
                    break;
                }
                for (int subIndex = 1; subIndex < subArray.length; subIndex++) {
                    int tempIndex = index + 1;
                    System.out.println("INSIDE: " + array[tempIndex] + " + " + subArray[subIndex]);
                    if (array[tempIndex] == subArray[subIndex]) {
                        System.out.println("HERE1");
                        isSubarrayFound = true;
                    } else {
                        System.out.println("HERE2");
                        isSubarrayFound = false;
                        break;
                    }
                    System.out.println("END OF LOOP");
                }
                if (isSubarrayFound) {
                    firstFoundIndex = index;
                    break;
                }
            }
        }
//		throw new UnsupportedOperationException("Please implement me!");
        if (!isSubarrayFound) return -1;
		return firstFoundIndex;
    }
}
