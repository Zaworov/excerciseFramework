/*
   This file is provided exclusively for the purpose of Spartez Online Assessment.
   Unauthorized distribution of this file, derived work or information about its
   content, via any medium, is strictly prohibited.
 */
package codilityExcercises.binaryGap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExOneTest {

    private ExOne exOne = new ExOne();

    @Test
    public void sampleInput1() throws Exception {
        //given
        final int testValue = 10;

        //when
        int result = exOne.solution(testValue);

        //then
        assertEquals(1, result);
    }

    @Test
    public void sampleInput2() throws Exception {
        //given
        final int testValue = 1041;

        //when
        int result = exOne.solution(testValue);

        //then
        assertEquals(5, result);
    }

//    @Test
//    public void sampleInput3() throws Exception {
//        //given
//        final int testValue = 10;
//
//        //when
//        int result = exOne.solution(testValue);
//
//        //then
//        assertEquals(1, result);
//    }

//    @Test
//    public void sampleInput2() throws Exception {
//        //given
//        final int[] array = {7,8,9};
//        final int[] subArray = {8,9,10};
//
//        //when
//        int result = findArray.findArray(array, subArray);
//
//        //then
//        assertEquals(-1, result);
//    }
//
//    @Test
//    public void sampleInput3() throws Exception {
//        //given
//        final int[] array = {4,9,3,7,8,3,7,1};
//        final int[] subArray = {3,7};
//
//        //when
//        int result = findArray.findArray(array, subArray);
//
//        //then
//        assertEquals(5, result);
}