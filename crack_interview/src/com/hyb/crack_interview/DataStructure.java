package com.hyb.crack_interview;

class LinkListNode
{
	int data;
	LinkListNode next;
	public LinkListNode(int data){this.data = data;}
	public LinkListNode(int data, LinkListNode next){this.data = data; this.next = next;}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof LinkListNode)
		{
			LinkListNode another = (LinkListNode)o;
			return data == another.data && (next==null && (another.next==null) || (next!=null && next.equals(another.next)));
		}
		return false;
	}
}



