package codilityExcercises.minAverageTwoSlice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void sampleInput1() throws Exception {
        //given
        final int[] testArray = new int[]{4, 2, 2, 5, 1, 5, 8};

        //when
        int result = solution.solution(testArray);

        //then
        assertEquals(1, result);
    }

    @Test
    public void sampleInput2() throws Exception {
        //given
        final int[] testArray = new int[]{5, 6, 3, 4, 9};

        //when
        int result = solution.solution(testArray);

        //then
        assertEquals(2, result);
    }

    @Test
    public void sampleInput3() throws Exception {
        //given
        final int[] testArray = new int[]{10, 10, -1, 2, 4, -1, 2, -1};

        //when
        int result = solution.solution(testArray);

        //then
        assertEquals(5, result);
    }
}
