package codilityExcercises.doubleSlice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {


    @Test
    public void sampleInput1() throws Exception {

        Solution solution = new Solution();
        //given
        final int[] testArray = new int[]{3,2,6,-1,4,5,-1,2};

        //when
        int result = solution.solution(testArray);

        //then
        assertEquals(17, result);
    }
}
