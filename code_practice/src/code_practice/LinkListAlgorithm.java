package code_practice;

import java.util.*;

class LinkListNode<T>
{
	T data;
	LinkListNode<T> next;
	LinkListNode(T data) {this.data =data;}
	@Override
	public boolean equals(Object o)
	{
		if(o==null || !(o instanceof LinkListNode)) return false;
		LinkListNode<T> o2 = (LinkListNode<T>)o;
		if(!data.equals(o2.data)) return false;
		if(next==null && o2.next != null) return false;
		if(next ==null && o2.next== null) return true;
		return next.equals(o2.next);
	}
	
	void print()
	{
		LinkListNode<T> head = this;
		while(head!=null)
		{
			System.out.print(head.data);
			head=head.next;
		}
	}
}
public class LinkListAlgorithm {
	<T> LinkListNode<T> makeLinkList(List<T> data)
	{
		if(data==null || data.isEmpty()) return null;
		LinkListNode<T> head = new LinkListNode<T>(data.get(0));
		data.remove(0);
		head.next=makeLinkList(data);
		return head;
	}
	LinkListNode<Integer> mergeSortedLinkList(LinkListNode<Integer> a, LinkListNode<Integer> b)
	{
		if(a==null) return b;
		if(b==null) return a;
		if(a.data<=b.data)
		{
			a.next=mergeSortedLinkList(a.next, b);
			return a;
		}
		else
			return mergeSortedLinkList(b,a);
	}
	
	public <T> LinkListNode<T> reverseRecursive(LinkListNode<T> head)
	{
		if(head==null || head.next==null) 
			return head;
		LinkListNode<T> head2 = reverseRecursive(head.next);
		head.next.next=head;
		head.next = null;
		return head2;
	}
	<T> LinkListNode<T> reverseIteration(LinkListNode<T> head)
	{
		LinkListNode<T> head2 = null;
		while(head!=null)
		{
			LinkListNode<T> next = head.next;
			head.next = head2;
			head2 = head;
			head=next;
		}
		return head2;
	}
}
