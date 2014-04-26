package code_practice;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class LinkListAlgorithmTest {
	LinkListNode<Integer> head;
	LinkListAlgorithm target;
	
	@Before
	public void setUp()
	{
		target = new LinkListAlgorithm();
		//head = target.makeLinkList(Arrays.asList(new Integer[]{1,2,3,4,5}));
		
		
	}

	@Test
	public void testMergeSortedLinkList() 
	{
		LinkListNode<Integer> a= target.makeLinkList(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,3,5,7})));
		LinkListNode<Integer> b= target.makeLinkList(new ArrayList<Integer>(Arrays.asList(new Integer[]{0,2,3,4,6})));
		LinkListNode<Integer> c= target.mergeSortedLinkList(a, b);
		while(c!=null)
		{
			System.out.print(c.data);
			c=c.next;
		}
	}

}