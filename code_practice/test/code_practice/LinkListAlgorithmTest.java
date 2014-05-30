package code_practice;

import static org.junit.Assert.*;

import java.util.*;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class LinkListAlgorithmTest {
	LinkListNode<Integer> head;
	LinkListAlgorithm target;
	
	
	@Before
	public void setUp()
	{
		target = new LinkListAlgorithm();
		head = target.makeLinkList(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5})));
		
		
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
	
	@Test
	public void testReverse()
	{
		LinkListNode<Integer> head1 = target.makeLinkList(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5})));
		LinkListNode<Integer> head2 = target.makeLinkList(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5})));
		target.reverseIteration(head1).print();
		System.out.println();
		target.reverseRecursive(head2).print();
		assertTrue(target.reverseIteration(head1).linkListEquals(target.reverseRecursive(head2)));
	}
	
	@Test
	public void testFindKToLast()
	{
		assertNull(target.findKToLast(head, 0));
		assertEquals(4, target.findKToLast(head, 2).data.intValue());
		assertEquals((Integer)1, target.findKToLast(head, 5).data);
		assertEquals(5,target.findKToLast(head, 1).data.intValue());
		try
		{
			target.findKToLast(head, 6);
			fail("Expect IllegalArguemntException");
		}catch (IllegalArgumentException e)
		{
			
		}
	}
	
	@Test
	public void testHasLoop()
	{
		assertFalse(target.hasLoop(head));
		
		LinkListNode<Integer> p= head.next; 
		while(head!=null && head.next!=null)
			head=head.next;
		head.next= p;
		
		assertTrue(target.hasLoop(head));		
	}

	@Test
	public void testLoopStart()
	{
		assertNull(target.loopStart(head));
		assertNull(target.loopStart2(head));
		LinkListNode<Integer> loopStart = head.next; 
		LinkListNode<Integer> p = head;
		while(p!=null && p.next!=null)
			p=p.next;
		p.next= loopStart;		
		assertEquals(loopStart.data, target.loopStart2(head).data);
		assertEquals(loopStart.data, target.loopStart(head).data);
		
	}

	@Test
	public void testFindCross()
	{
		LinkListNode<Integer> head2 = target.makeLinkList(new Integer[]{6,7,8});
		assertNull(target.findCross(head, head2));
		
		LinkListNode<Integer> p= head2;
		while(p!=null && p.next!=null)
			p=p.next;
		
		p.next=head.next;
		
		assertEquals(head.next, target.findCross(head, head2));
		assertEquals(head.next, target.findCross(head, head.next));
	}

	@Test
	public void testRemoveFromMiddle()
	{
		LinkListNode<Integer >del = head.next.next.next;
		target.removeFromMiddle(del);
		head.print();
		assertTrue(head.linkListEquals(target.makeLinkList(new Integer[]{1,2,3,5})));
	}

	@Test
	public void testFindMidNode()
	{
		assertEquals(head.next.next, target.findMidNode(head));
	}

	@Test
	public void testInsertBefore()
	{
		target.insertBefore(head.next.next, new LinkListNode<Integer>(100));
		assertTrue(head.linkListEquals(target.makeLinkList(new Integer[]{1,2,100,3,4,5})));
	}
	
	@Test
	public void testRemove()
	{
		target.remove(head, 5);
		assertTrue(head.linkListEquals(target.makeLinkList(new Integer[]{1,2,3,4})));
		target.remove(head, 3);
		assertTrue(head.linkListEquals(target.makeLinkList(new Integer[]{1,2,4})));	
		assertTrue(target.remove(head, 1).linkListEquals(target.makeLinkList(new Integer[]{2,4})));
	}

	@Test
	public void testSortList()
	{
		ListNode head= new ListNode(3, new ListNode(2, new ListNode(1)));
		ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3)));
		target.fastSort(head, null);
		assertTrue(head.linkListEquals(expected));
		
		head= new ListNode(3, new ListNode(2, new ListNode(1)));
		assertTrue(target.mergeSort(head).linkListEquals(expected));
	}
}
