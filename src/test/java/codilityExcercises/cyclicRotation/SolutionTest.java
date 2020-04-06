package codilityExcercises.cyclicRotation;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void sampleInput1() throws Exception {
        //given
        final int[] testArray = new int[]{3, 8, 9, 7, 6};
        final int rotations = 3;

        //when
        int[] result = solution.solution(testArray, rotations);

        //then
        final int[] expectedArray = new int[]{9, 7, 6, 3, 8};
        assertArrayEquals(expectedArray, result);
    }
}