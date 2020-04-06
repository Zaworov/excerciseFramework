package codilityExcercises.Distinct;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();
    @Test
    public void sampleInput1() throws Exception {
        //given
        final int[] testArray = new int[]{2,1,1,2,3,1};

        //when
        int result = solution.solution(testArray);

        //then
        assertEquals(3, result);
    }
}
