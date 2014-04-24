package com.hyb.crack_interview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Chapter2Test {

	Chapter2 target = new Chapter2();

	//2.1 remove duplicate nodes from linked list
	@Test
	public void testRemoveDuplicateNodes() {
		LinkListNode head = new LinkListNode(1,new LinkListNode(2,new LinkListNode(3,new LinkListNode(4,new LinkListNode(2,new LinkListNode(3))))));	
		target.removeDuplicateNodes(head);
		assertEquals(head, new LinkListNode(1,new LinkListNode(2,new LinkListNode(3,new LinkListNode(4))))  );
		
		target.removeDuplicateNodes(null);
		
		head = new LinkListNode(1,new LinkListNode(1));
		target.removeDuplicateNodes(head);
		assertEquals(head, new LinkListNode(1));
		
	}
	
	//2.2 Implement an algorithm to find the nth to last element of a singly linked list.
	@Test
	public void testFindLastNth()
	{
		LinkListNode head = new LinkListNode(1,new LinkListNode(2,new LinkListNode(3,new LinkListNode(4))));
		assertEquals(3,target.findLastNth(head, 2).data);
	}

}
