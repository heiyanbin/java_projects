package com.hyb.crack_interview;

public class Chapter2 {
	
	//2.1 Write code to remove duplicates from an unsorted linked list.
	void removeDuplicateNodes(LinkListNode head)
	{
		while(head!=null)
		{
			LinkListNode prev = head;
			LinkListNode p = head.next;
			while(p!=null)
			{
				if(p.data==head.data)
					prev.next = p.next;	
				else
					prev = p;
				p=p.next;
			}
			head=head.next;	
		}		
	}
	
	//2.2 Implement an algorithm to find the nth to last element of a singly linked list.
	LinkListNode findLastNth(LinkListNode head, int n)
	{
		if(head==null || n<1)throw new IllegalArgumentException();
		LinkListNode p = head, q = head;
		int moves = 0;
		while(q!=null && moves<n)
		{
			q=q.next;
			moves++;
		}
		if(q==null) throw new IllegalArgumentException();
		while(q!=null)
		{
			p=p.next;
			q=q.next;
		}
		return p;
	}
	
	
}


