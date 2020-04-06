package codilityExcercises.absoluteDistinct;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();
    @Test
    public void sampleInput1() throws Exception {
        //given
        final int[] testArray = new int[]{-5, -3, -1, 0, 3, 6};

        //when
        int result = solution.solution(testArray);

        //then
        assertEquals(5, result);
    }
}
