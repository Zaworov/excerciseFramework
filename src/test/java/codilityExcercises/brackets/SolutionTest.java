package codilityExcercises.brackets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {


    @Test
    public void sampleInput1() throws Exception {

        Solution solution = new Solution();
        //given
        final String testString = "{[()()]}";

        //when
        int result = solution.solution(testString);

        //then
        assertEquals(1, result);
    }

    @Test
    public void sampleInput2() throws Exception {

        Solution solution = new Solution();
        //given
        final String testString = "([)()]";

        //when
        int result = solution.solution(testString);

        //then
        assertEquals(0, result);
    }

    //TODO EMPTY STRING SCENARIO!
//    @Test
//    public void sampleInput2() throws Exception {
//
//        Solution solution = new Solution();
//        //given
//        final String testString = "([)()]";
//
//        //when
//        int result = solution.solution(testString);
//
//        //then
//        assertEquals(0, result);
//    }
}
