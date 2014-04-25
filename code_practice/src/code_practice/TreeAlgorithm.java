package code_practice;

import java.util.*;

class TreeNode<T>
{
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	
	public TreeNode(T data) { this.data = data;}
}
class TrieNode
{
	Character letter;
	List<TrieNode> links = new ArrayList<TrieNode>();
	TrieNode(Character letter){this.letter= letter;}
}

public class TreeAlgorithm {
	public <T> void  inOrder(TreeNode<T> root)
	{
		if(root==null) return;	
		inOrder(root.left);
		System.out.print(root.data);
		inOrder(root.right);
	}
	public TreeNode<Integer> buildBinarySearchTree (int[] array)
	{
		if(array==null) return null;
		
		TreeNode<Integer> root = new TreeNode<Integer>(array[0]);
		for(int i = 1; i<array.length; i++)
		{
			TreeNode<Integer> p  = root;
			while(p!=null)
			{
				if (array[i]<p.data)
				{
					if(p.left==null)
					{
						p.left=new TreeNode<Integer>(array[i]);
						break;
					}					
					else
						p=p.left;						
				}
				else
				{
					if(p.right==null)
					{
						p.right = new TreeNode<Integer>(array[i]);
						break;
					}
					else
						p=p.right;
				}
			}
		}
		return root;	
	}
	public TreeNode<Integer> removeNodeFromBinarySearchTree(TreeNode<Integer> root, Integer a)
	{
		if(root==null || a== null ) throw new IllegalArgumentException("Null Argument.");
		TreeNode<Integer> del = root;
		TreeNode<Integer> replacement = null;
		TreeNode<Integer> parent = new TreeNode<Integer>(0);
		parent.left= root;
		while(del!=null )
		{
			if(a<del.data) 
			{
				parent = del;
				del=del.left; 
				
			}
			else if(a>del.data) 
			{
				parent = del;
				del=del.right;				
			}
			else
			{
				break;
			}
		}
		if(del==null) 
			throw new IllegalArgumentException("not found");
		
		
		if(del.left ==null && del.right==null) 
		{
			if(parent.left== del) parent.left = null;
			else parent.right =null;
		}
		else if(del.left == null)
		{
			if(parent.left == del) parent.left = del.right;
			else parent.right= del.right;
		}
		else if(del.right == null)
		{
			if(parent.left == del) parent.left = del.left;
			else parent.right = del.left;
		}
		else
		{
			TreeNode<Integer> parent2= del;
			replacement = del.right;		
			while(replacement.left!=null)
			{
				parent2 = replacement;
				replacement = replacement.left;
			}
			if(parent2.left==replacement) parent2.left= replacement.right;
			else parent2.right = replacement.right;
			
			replacement.left = del.left;
			replacement.right = del.right;
			
			
			if(parent.left==del) parent.left=replacement;
			else  parent.right = replacement;

		}
		if(del!=root)
			return root;
		else
			return replacement;
	}
	public TrieNode buildTrie(String[] words)
	{
		TrieNode root = new TrieNode(null);
		TrieNode p = null;
		for(String word : words)
		{
			p = root;
			for(char letter : word.toLowerCase().toCharArray())
			{
				int i =0;
				while(p.links.size()>0 && p.links.get(i).letter< letter && i<p.links.size())
					i++;
				if(i>=p.links.size())							
				{
					i=0;
					while(p.links.size()>0 && p.links.get(i).letter<letter)
						i++;
					p.links.add(i,new TrieNode(letter));
				}
				p=p.links.get(i);
			}
		}
		return root;
	}
}




