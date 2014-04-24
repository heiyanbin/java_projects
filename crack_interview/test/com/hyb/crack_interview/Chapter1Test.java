package com.hyb.crack_interview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Chapter1Test {

	Chapter1 target = new Chapter1();
	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	//1.1
	public void testIsaAllUnique() {
		assertTrue( target.isAllUnique("abcdefg"));
		assertFalse(target.isAllUnique("abcdefb"));
	}
	
	@Test
	//1.2
	public void testReverse()
	{
		char[] s = "abcde1".toCharArray();
		target.reverse(s);
		assertEquals(new String(s),"1edcba");
	}
	
	@Test
	//1.3
	public void testRemoveDuplicateChar() 
	{
		char [] s = "abcdbeee".toCharArray();
		target.removeDuplicateChar(s);
		assertTrue(new String(s).startsWith("abcde"));
	}

	@Test
	//1.4
	public void testIsAnagram() 
	{
		assertTrue(target.isAnagram("abbbc","babcb"));
		assertFalse(target.isAnagram("abbbc","bbaca"));
		
	}

	@Test
	//1.5 Write a method to replace all spaces in a string with ‘%20’.
	public void testReplaceWhiteSpace() 
	{
		char[] s = " a b cdef g \0\0\0\0\0\0\0\0\0\0\0\0".toCharArray();
		target.replaceWhiteSpace(s, 12);
		String actual = new String(s).trim();
		assertEquals("%20a%20b%20cdef%20g%20", actual);
	}
	
	@Test
	//1.6
	public void testRotateMatrix() 
	{
		int[][]matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][] expected = new int[][]{{3,6,9},{2,5,8},{1,4,7}};
		target.rotateMatrix(matrix,3);
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				assertEquals(expected[i][j],matrix[i][j]);
	}
	
	@Test
	//1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
	public void testSetRowAndColumnZero()
	{
		int a[][] = {{1,0,3},{4,5,0},{7,8,9}};
		int expected[][] = {{0,0,0},{0,0,0},{7,0,0}};
		target.setRowAndColumnZero(a);
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				assertEquals(expected[i][j],a[i][j]);
	}
	
	@Test
	//1.8 Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
	public void testIsRotation()
	{
		String a = "abcdefg";
		String b = "defgabc";
		assertTrue(target.isRotation(a, b));
	}
}
