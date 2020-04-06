package codilityExcercises.commonPrimeDivisors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void sampleInput1() throws Exception {
        //given
        final int[] testArray = new int[]{15, 10, 3};
        final int[] testArray2 = new int[]{75, 30, 5};

        //when
        int result = solution.solution(testArray, testArray2);

        //then
        assertEquals(1, result);
    }

    @Test
    public void sampleInput2() throws Exception {
        //given
        final int[] testArray = new int[]{2, 1, 2};
        final int[] testArray2 = new int[]{1, 2, 2};

        //when
        int result = solution.solution(testArray, testArray2);

        //then
        assertEquals(1, result);
    }
}