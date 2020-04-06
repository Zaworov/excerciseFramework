package codilityExcercises.permMissingElement;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution solution = new Solution();
    @Test
    public void sampleInput1() throws Exception {
        //given
        final int[] testArray = new int[]{2,3,1,5};

        //when
        int result = solution.solution(testArray);

        //then
        assertEquals(4, result);
    }

    @Test
    public void sampleInput2() throws Exception {
        //given
        final int[] testArray = new int[]{};

        //when
        int result = solution.solution(testArray);

        //then
        assertEquals(4, result);
    }

    @Test
    public void sampleInput3() throws Exception {
        //given
        final int[] testArray = new int[]{2,3,1,5};

        //when
        int result = solution.solution(testArray);

        //then
        assertEquals(4, result);
    }
}
