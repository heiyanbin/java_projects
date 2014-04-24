package com.hyb.crack_interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Chapter1 {

	//1.1
	public boolean isAllUnique(String s)
	{
		if(s==null) throw new IllegalArgumentException();
		boolean[] map = new boolean[256];
		for(int i=0;i<s.length();i++)
		{
			if(map[s.charAt(i)]) 
				return false;
			map[s.charAt(i)]=true;
		}
		return true;
	}
	//1.2
	public void reverse(char[] s)
	{
		if(s==null||s.length<2)
			return;
		
		int i=0,j=s.length-1;
		while(i<j)
		{
			char c = s[i];
			s[i] = s[j];
			s[j] = c;
			i++;j--;
		}
		
	}
	//1.3
	public void removeDuplicateChar(char[] s)
	{
		if(s==null || s.length<1)
			return;
		
		Map map = new HashMap();
		int i=0;
		for(char c : s) //rewrite the char array
		{
			if(!map.containsKey(c))
			{	
				s[i]=c;
				i++;
				map.put(c, null);
			}
		}
	}
	
	//1.4
	public boolean isAnagram(String a, String b)
	{
		if(a==null && b==null) return true;
		if(a==null && b!=null) return false;
		if(a!=null && b==null) return false;
		if(a.length()!=b.length()) return false;
		Map<Character,Integer> map1 = new HashMap<Character,Integer>();
		Map<Character,Integer> map2 = new HashMap<Character,Integer>();
		for(int i=0;i<a.length();i++)
		{
			char c = a.charAt(i);
			if(map1.containsKey(c))
				map1.put(c, map1.get(c)+1);
			else
				map1.put(c, 1);
		}
		for(int j=0;j<b.length();j++)
		{
			char c = b.charAt(j);
			if(map2.containsKey(c))
				map2.put(c, map2.get(c)+1);
			else
				map2.put(c, 1);
		}
		for(Entry<Character, Integer> e : map1.entrySet())
		{
			if(e.getValue()!=map2.get(e.getKey()))
				return false;
		}
		return true;
	}
	
	//1.5 Write a method to replace all spaces in a string with ‘%20’.
	public void replaceWhiteSpace(char[] s, int length)
	{
		if(s==null||s.length<1)return;
		int count = 0;
		for(char c : s) 
			if(c==' ')count++;
		
		int newLen = length + 2*count;
		int j = newLen -1;
		for(int i=length-1; i>=0; i--)
		{
			if(s[i]!=' ') 
			{	
				s[j]=s[i];
				j--;
			}
			else
			{
				s[j]='0';
				s[j-1]='2';
				s[j-2]='%';
				j=j-3;
			}
		}	
	}
	
	//1.6 Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
	void rotateMatrix(int a[][], int n)
	{
		int layer = 0;
		while( layer <n/2)
		{
			int k=layer;
			while(k<n-layer-1)
			{
				int tmp = a[layer][k];
				a[layer][k]=a[k][n-layer-1];
				a[k][n-layer-1]= a[n-layer-1][n-k-1];
				a[n-layer-1][n-k-1]=a[n-k-1][layer];
				a[n-k-1][layer]=tmp;
				k++;
			}
			layer ++;
		}
	}
	
	//1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
	void setRowAndColumnZero(int a[][])
	{
		if(a==null||a[0]==null) return;
		int rows[] = new int[a.length];
		int cols[] = new int[a[0].length];
		for(int i=0;i<rows.length;i++)
			for(int j=0;j<cols.length;j++)
			{
				if(a[i][j]==0)
				{	
					rows[i]=1;
					cols[j]=1;
				}				
			}
		for(int i=0;i<rows.length;i++)
			for(int j =0;j<cols.length;j++)
			{
				if(rows[i]==1 || cols[j]==1)
					a[i][j] = 0;
			}				
	}
	
	//1.8 Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
	boolean isRotation(String a, String b)
	{
		if(a==null || b ==null) throw new IllegalArgumentException();
		if(a.length()!=b.length()) return false;
		return (a+a).contains(b);
		
	}
}
