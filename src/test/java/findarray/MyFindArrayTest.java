/*
   This file is provided exclusively for the purpose of Spartez Online Assessment.
   Unauthorized distribution of this file, derived work or information about its
   content, via any medium, is strictly prohibited.
 */
package findarray;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyFindArrayTest {

	private FindArray findArray;

	@Before
	public void testSetup() throws Exception {
		findArray = new MyFindArray();
	}

	@Test
	public void findArrayFromTaskDescription() throws Exception {
		//given
		final int[] array = {4, 9, 3, 7, 8};
		final int[] subArray = {3, 7};

		//when
		int result = findArray.findArray(array, subArray);

		//then
		assertEquals(2, result);
	}

	@Test
	public void noArrayFund() throws Exception {
		//given
		final int[] array = {4, 9, 3, 7, 8};
		final int[] subArray = {7, 3};

		//when
		int result = findArray.findArray(array, subArray);

		//then
		assertEquals(-1, result);
	}


	@Test
	public void sampleInput1() throws Exception {
		//given
		final int[] array = {1,3,5};
		final int[] subArray = {1};

		//when
		int result = findArray.findArray(array, subArray);

		//then
		assertEquals(0, result);
	}

	@Test
	public void sampleInput2() throws Exception {
		//given
		final int[] array = {7,8,9};
		final int[] subArray = {8,9,10};

		//when
		int result = findArray.findArray(array, subArray);

		//then
		assertEquals(-1, result);
	}

	@Test
	public void sampleInput3() throws Exception {
		//given
		final int[] array = {4,9,3,7,8,3,7,1};
		final int[] subArray = {3,7};

		//when
		int result = findArray.findArray(array, subArray);

		//then
		assertEquals(5, result);
	}

	@Test
	public void sampleInput4() throws Exception {
		//given
		final int[] array = {4,9,3,7,8,3,7,1};
		final int[] subArray = {3};

		//when
		int result = findArray.findArray(array, subArray);

		//then
		assertEquals(5, result);
	}

	@Test
	public void sampleInput5() throws Exception {
		//given
		final int[] array = {4,9,3,7,8,3,7,9};
		final int[] subArray = {3,7,9};

		//when
		int result = findArray.findArray(array, subArray);

		//then
		assertEquals(5, result);
	}
}