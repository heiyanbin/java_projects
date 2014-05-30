package code_practice;

import java.util.*;


public class Main 
{

	public static void main(String[] args) 
	{
		
	/*	ListNode head= new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		head.next=node2;
		node2.next=node3;
		new Solution().sortList(head);
		System.out.println(head);*/
	}
}
	


 /*class ListNode {
      int val;
    ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
 class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        fastSort(head, null);
        return head;
        
    }
    private void fastSort(ListNode head, ListNode endExclusive)
    {
        if(head==null || head==endExclusive || head.next == endExclusive)
            return;
        ListNode mid = partition(head, endExclusive);
        fastSort(head, mid);
        if(mid!=null)
            fastSort(mid.next, null);
    }
    private ListNode partition(ListNode head, ListNode endExclusive)
    {
        if(head==null||head==endExclusive||head.next==endExclusive) 
        	return head;
        ListNode prevP =head, p=head.next, q=head.next;
        while(q!=endExclusive)
        {
            if(q.val<head.val)
            {
                int temp=p.val;
                p.val= q.val;
                q.val=temp;
                prevP=p;
                p=p.next;
            }
            q=q.next;
        }
        int temp = prevP.val;
        prevP.val = head.val;
        head.val = temp;
        return prevP;
    }
}*/