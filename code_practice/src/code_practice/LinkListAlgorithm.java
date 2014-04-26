package code_practice;

import java.util.*;

class LinkListNode<T>
{
	T data;
	LinkListNode<T> next;
	LinkListNode(T data) {this.data =data;}
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

}
