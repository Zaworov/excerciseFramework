package atenaExcercises.ex1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();
    @Test
    public void sampleInput1() throws Exception {

        //given
        final int testInput = 268;

        //when
        int result = solution.solution(testInput);

        //then
        assertEquals(5268, result);
    }

    @Test
    public void sampleInput2() throws Exception {

        //given
        final int testInput = 670;

        //when
        int result = solution.solution(testInput);

        //then
        assertEquals(6750, result);
    }

    @Test
    public void sampleInput3() throws Exception {

        //given
        final int testInput = 0;

        //when
        int result = solution.solution(testInput);

        //then
        assertEquals(50, result);
    }

    @Test
    public void sampleInput4() throws Exception {

        //given
        final int testInput = -999;

        //when
        int result = solution.solution(testInput);

        //then
        assertEquals(-5999, result);
    }
}