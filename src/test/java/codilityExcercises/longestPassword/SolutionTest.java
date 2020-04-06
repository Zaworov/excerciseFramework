package codilityExcercises.longestPassword;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//it has to contain only alphanumerical characters (a−z, A−Z, 0−9);
//        there should be an even number of letters;
//        there should be an odd number of digits.

public class SolutionTest {

    Solution solution = new Solution();
    @Test
    public void sampleInput1() throws Exception {
        //given
        final String testString = "test 5 a0A pass007 ?xy1";

        //when
        int result = solution.solution(testString);

        //then
        assertEquals(7, result);
    }
}
