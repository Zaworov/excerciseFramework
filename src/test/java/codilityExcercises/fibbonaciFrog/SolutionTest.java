package codilityExcercises.fibbonaciFrog;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {


    @Test
    public void sampleInput1() throws Exception {

        Solution solution = new Solution();
        //given
        final int[] testArray = new int[]{0,0,0,1,1,0,1,0,0,0,0};

        //when
        int result = solution.solution(testArray);

        //then
        assertEquals(3, result);
    }
}
