package code_practice;

import java.util.*;

class LinkListNode<T>
{
	T data;
	LinkListNode<T> next;
	LinkListNode(){}
	LinkListNode(T data) {this.data =data;}
	
	public boolean linkListEquals(Object o)
	{
		if(o==null || !(o instanceof LinkListNode)) return false;
		LinkListNode<T> o2 = (LinkListNode<T>)o;
		if(!data.equals(o2.data)) return false;
		if(next==null && o2.next != null) return false;
		if(next ==null && o2.next== null) return true;
		return next.linkListEquals(o2.next);
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
	public <T> LinkListNode<T> makeLinkList(T[] data)
	{
		if(data==null||data.length==0) return null;
		LinkListNode<T> head = new LinkListNode<T>(data[0]);
		LinkListNode<T> p=head;
		for(int i=1;i<data.length;i++)
		{
			p.next= new LinkListNode<T>(data[i]);
			p=p.next;
		}
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
	public <T> LinkListNode<T> reverseIteration(LinkListNode<T> head)
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
	
	public <T> LinkListNode<T> findKToLast (LinkListNode<T> head, int k)
	{
		if(head==null&&k<1) return null; 
		LinkListNode<T> p=head, q=head;
		while(q!=null && k>0)
		{
			q=q.next;
			k--;
		}
		if(q==null && k>0) throw new IllegalArgumentException("link list length less than k");
		while(q!=null)
		{
			q=q.next;
			p=p.next;
		}
		return p;
	}

	public <T> boolean hasLoop(LinkListNode<T> head)
	{
		if(head==null || head.next==null) return false;
		if(head.next==head) return true;
		LinkListNode<T> p=head, q= head.next;
		while(q!=null&&q.next!=null)
		{
			p=p.next;
			q=q.next;
			if(p==q) return true;
			q=q.next;
			if(p==q) return true;
		}
		return false;
	}
	public <T> LinkListNode<T> loopStart2(LinkListNode<T> head)
	{
		if(head==null || head.next==null) return null;
		Set<LinkListNode<T>> set = new HashSet<LinkListNode<T>>();
		while(head!=null)
		{
			if(set.contains(head)) 
				return head;
			set.add(head);
			head=head.next;
		}
		return null;
	}
	public <T> LinkListNode<T> loopStart(LinkListNode<T> head)
	{
		if(head==null || head.next ==null) return null;
		if(head.next==head) return head;
		LinkListNode<T> p=head, q=head.next;
		while(q!=null&&q.next!=null)
		{
			p=q.next;
			q=q.next;
			if(p==q) break;
			q=q.next;
			if(p==q) break;
		}
		if(q==null || q.next==null) return null;
		
		LinkListNode<T> head2= p.next;
		p.next = null;
		
		p=head;
		int len1=0;
		while(p!=null) 
		{
			p=p.next;
			len1++;
		}
		int len2=0;
		p= head2;
		while(p!=null)
		{
			p=p.next;
			len2++;
		}
		p=head;
		q=head2;
		if(len1>len2)
		{
			int d= len1-len2;
			while(d>0) 
			{
				p=p.next;
				d--;
			}
		}
		else
		{
			int d = len2 -len1;
			while(d>0)
			{
				q=q.next;
				d--;
			}
		}
		while(p!=null&&q!=null&&p!=q)
		{
			p = p.next;	
			q = q.next;
		}
		return p;
	}

	public <T> LinkListNode<T> findCross(LinkListNode<T> head1, LinkListNode<T> head2)
	{
		if(head1==null || head2==null) return null;
		if(head1==head2) return head1;
		int len1=0, len2=0;
		LinkListNode<T> p = head1, q = head2;
		while(p!=null&&p.next!=null)
		{
			p=p.next;
			len1++;
		}
		while(q!=null&&q.next!=null)
		{
			q=q.next;
			len2++;
		}
		if(p!=q) return null;
		int d=0;
		p=head1;
		q=head2;
		if(len1>=len2)
		{
			d=len1-len2;
			while(d>0)
			{
				p=p.next;
				d--;
			}
		}
		else
		{
			d=len2-len1;
			while(d>0)
			{
				q=q.next;
				d--;
			}
		}
		while(p!=null&&q!=null && p!=q)
		{
			p=p.next;
			q=q.next;
		}
		return p;
	}

	public <T>  void removeFromMiddle(LinkListNode<T> del)
	{
		if(del==null || del.next==null) return;
		del.data = del.next.data;
		del.next = del.next.next;
	}
	
	public <T> LinkListNode<T> findMidNode(LinkListNode<T> head)
	{
		if(head==null) return null;
		if(head.next==null) return head;
		LinkListNode<T> p = head, q =head;
		while(q!=null&&q.next!=null)
		{
			p=p.next;
			q=q.next.next;
		}
		return p;
	}

	public <T> void insertBefore(LinkListNode<T> node, LinkListNode<T> insert)
	{	
		insert.next= node.next;
		node.next = insert;
		T temp = node.data;
		node.data = insert.data;
		insert.data= temp;	
	}

	public <T> LinkListNode<T> find (LinkListNode<T> head, T data)
	{
		while(head!=null&& head.data!=data)
			head=head.next;
		return head;
	}
	public <T> LinkListNode<T> remove(LinkListNode<T> head, T del)
	{		
		if(head==null) return null;
		if(head.data == del) return head.next;
		while(head.next!=null && head.next.data!=del)
			head=head.next;
		if(head!=null && head.next!=null)
		{
			head.next= head.next.next;
		}
		return head;
	}
}
