package atenaExcercises.ex3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {


    Solution solution = new Solution();
    @Test
    public void sampleInput1() throws Exception {
        //given
        final int[] testArray = new int[]{2, 8, 4, 3, 2};
        final int X = 7;
        final int Y = 11;
        final int Z = 3;

        //when
        int result = solution.solution(testArray, X, Y, Z);

        //then
        assertEquals(8, result);
    }

    @Test
    public void sampleInput2() throws Exception {
        //given
        final int[] testArray = new int[]{2, 8, 4, 3, 2};
        final int X = 1;
        final int Y = 1;
        final int Z = 1;

        //when
        int result = solution.solution(testArray, X, Y, Z);

        //then
        assertEquals(-1, result);
    }
}