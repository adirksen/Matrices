/*
 * Here is a starting point for your Matrix tester. You will have to fill in the rest of "main" with
 * more code to sufficiently test your Matrix class. We will be using our own MatrixTester for grading. 
 */
package assignment01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the Matrix class
 * 
 * @author Miriah Meyer & Anthony Dirksen
 * @version January 11, 2018
 */
public class MatrixJUnitTester {

	Matrix threeByTwo, threeByTwoCopy, twoByThree, fourByOne, oneByFour, oneByOne, twoByTwoResult, oneByFourAndOneByOneMultiplicationResult;
	/*Initialize some matrices we can play with for every test!*/
	
	@Before
	public void setup() {
		threeByTwo = new Matrix(new int[][]
                {{1, 2, 3},
				 {2, 5, 6}});

        threeByTwoCopy = new Matrix(new int[][]
                {{1, 2, 3}, {2, 5, 6}});

		twoByThree = new Matrix(new int[][]
                {{4, 5},
				 {3, 2},
				 {1, 1}});
		// this is the known correct result of multiplying M1 by M2
		twoByTwoResult = new Matrix(new int[][]
                                    {{13, 12}, {29, 26}});

		fourByOne = new Matrix(new int[][]{{1,2,3,4}});

		oneByFour = new Matrix(new int[][]{{1},
				                           {2},
				                           {3},
				                           {4}});

		oneByFourAndOneByOneMultiplicationResult = new Matrix(new int[][]{{30, 60, 90, 120}});

		oneByOne = new Matrix(new int[][] {{30}});
	}

	/** Tests for the 'times()' method */
	@Test
	public void timesWithBalancedDimensions1 () {
		Matrix matrixProduct = threeByTwo.times(twoByThree);
		Assert.assertTrue(twoByTwoResult.equals(matrixProduct));
	}

	@Test
	public void timesWithBalancedDimensions2 () {
		Matrix matrixProduct = fourByOne.times(oneByFour);
		Assert.assertTrue(oneByOne.equals(matrixProduct));
	}
	
	@Test
	public void timesWithUnbalancedDimensions1(){
		Matrix matrixProduct =fourByOne.times(twoByThree);
		Assert.assertEquals(null, matrixProduct);
	}

	@Test
	public void timesWithUnbalancedDimensions2() {
		Matrix matrixProduct = oneByFour.times(threeByTwo);
		Assert.assertEquals(null, matrixProduct);
	}

	@Test
	public void oneByFourAndOneByOneMultiplication () {
		Matrix matrixProduct = oneByOne.times(fourByOne);
		Assert.assertEquals(oneByFourAndOneByOneMultiplicationResult, matrixProduct);
	}

	@Test
	public void oneByOneMultiplication (){
		Matrix matrixProduct = oneByOne.times(oneByOne);
		Assert.assertEquals("900\n", matrixProduct.toString());
	}

	/** Tests for the 'ToString()' method */
	@Test
	public void twoByTwoToString() {
		String resultString = "13 12\n29 26\n";
		Assert.assertEquals(resultString, twoByTwoResult.toString());
	}

	@Test
    public void threeByTwoToString() {
	    String resultString = "1 2 3\n2 5 6\n";
	    Assert.assertEquals(resultString, threeByTwo.toString());
    }

    @Test
    public void twoByThreeToString() {
	    String resultString = "4 5\n3 2\n1 1\n";
	    Assert.assertEquals(resultString, twoByThree.toString());
    }

    @Test
	public void oneByFourToString() {
		String resultString = "1\n2\n3\n4\n";
		Assert.assertEquals(resultString,oneByFour.toString());
	}

    /** Tests for the 'Equals()' method */
    @Test
    public void threeByTwoEqualsTrue() {
        Assert.assertTrue(threeByTwo.equals(threeByTwoCopy));
    }

    @Test
	public void oneByFourEqualsTrue() {
    	Assert.assertTrue(oneByFour.equals(oneByFour));
	}

	@Test
	public void threeByTwoEqualsFalse() {
    	Assert.assertFalse(threeByTwo.equals(oneByFour));
	}

	@Test
	public void fourByOneEqualsFalse() {
    	Assert.assertFalse(oneByFour.equals(fourByOne));
	}

	/**Tests for the 'plus()' method */

	@Test
	public void plusTestFromAssignmentPage() {
		Matrix threeByTwoLeft = new Matrix(new int[][] {{1,2,3}, {4,5,6}});

		Matrix threeByTwoRight = new Matrix(new int[][] {{7,8,9}, {10,11,12}});

		Matrix resultMatrix = threeByTwoLeft.plus(threeByTwoRight);

		Matrix resultCheckMatrix = new Matrix(new int[][] {{8,10,12}, {14,16,18}});

		Assert.assertTrue(resultMatrix.equals(resultCheckMatrix));
	}

	@Test
	public void plusNullTestThreeByTwoAndTwoByThree () {
		Assert.assertEquals(null, threeByTwo.plus(twoByThree));
	}

	@Test
	public void plusTestThreeByTwo () {
		Matrix resultMatrix = new Matrix(new int[][] {{4,6,8}, {3,5,7}});

		Matrix threeByTwoLeft = new Matrix(new int[][] {{3,5,7}, {2,4,6}});
		Matrix threeByTwoRight = new Matrix(new int[][] {{1,1,1}, {1,1,1}});

		Assert.assertEquals(resultMatrix, threeByTwoLeft.plus(threeByTwoRight));
	}

	@Test
	public void plusTestOneByOne (){
		Matrix matrixResult = oneByOne.plus(oneByOne);
		Assert.assertEquals("60\n", matrixResult.toString());
	}
}
