package code_practice;

import java.nio.charset.Charset;
import java.util.*;


public class Main 
{

	public static void main(String[] args) 
	{
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");
		//dict.add("b");
		List<String> l =  new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict);
		/*for(String s : l)
			System.out.println(s);*/
		if(l.isEmpty())
			System.out.println("empty.");
	}
}
	
class Solution {
    public List<String> wordBreak(String s, Set<String> dict) { 	
    	List<String> output = new ArrayList<String>();
    	
    	/*Set<Character> charSet =  new HashSet<Character>();
    	for(String word : dict)
    	{
    		for(int i=0;i<word.length();i++)
    		{
    			charSet.add(word.charAt(i));
    		}
    	}
    	for(int i=0;i<s.length();i++)
    	{
    		if(!charSet.contains(s.charAt(i)))
    			return output;
    	}*/
    	select (s, "", dict, output);
        return output;
    }
    void select(String s, String x, Set<String> dict, List<String> output)
    {
    	if(s==null||s.length() ==0 )
    	{
    		output.add(x.trim());
    		return;
    	}
    	for(int i=1;i<=s.length();i++)
    	{
    		String prefix = s.substring(0, i);
    		if(dict.contains(prefix))
    		{
    			select(s.substring(i), x+prefix+' ', dict, output);
    		}  		
    	}
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