package code_practice;

import java.nio.charset.Charset;
import java.util.*;


public class Main 
{

	volatile Object o;
	public static void main(String[] args) 
	{
		
		Solution s = new Solution();
		String a = s.simplifyPath("/home/");
        System.out.println(a);
        
	}
	Integer[] removeDup(Integer [] A)
	{
		if(A==null) throw new IllegalArgumentException("input array should not be null");
		Set<Integer> s= new HashSet<Integer>();
		int i=0;
		for(int j=0;j<A.length;j++)
		{
			if(!s.contains(A[j]))
			{
				A[i]=A[j];
				s.add(A[j]);
				i++;
			}		
		}
		return Arrays.copyOf(A, i);
	}
	
}
	
class Solution {

    
	public String simplifyPath(String path) {
        if(path==null || path.isEmpty() ) return path;
        String[] parts = path.trim().split("/+");
        List<String> s = new ArrayList<String>();
        for(String part : parts)
        {
        	if(!part.equals(".") && !part.equals(".."))
        		s.add(part);
        	else if(part.equals("..") && !s.isEmpty())
        		s.remove(s.size()-1);
        }
        if(s.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.size();i++)
        {
        	if(sb.length()==0 || sb.charAt(sb.length()-1)!='/') sb.append("/");
        	sb.append(s.get(i));
        }
       return sb.toString();
    }
	/*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public String rotateString(String A, int offset) {
        // wirte your code here
        char[] s = A.toCharArray();
        reverse(s,0,s.length-offset-1);
        reverse(s,s.length-offset, s.length-1);
        reverse(s,0,s.length-1);
        return new String(s);
        
    }
    private void reverse(char[] s, int l, int r)
    {
        for(;l<r; l++,r--)
        {
            char c = s[l];
            s[l]=s[r];
            s[r]=c;
        }
    }
    
};

