package code_practice;

import java.util.*;

class TreeNode<T>
{
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	TreeNode<T> sibling;
	
	public TreeNode(T data) { this.data = data;}
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
		TreeNode<Integer> parentOfDel = new TreeNode<Integer>(0);
		parentOfDel.left= root;
		while(del!=null )
		{
			if(a<del.data) 
			{
				parentOfDel = del;
				del=del.left; 
				
			}
			else if(a>del.data) 
			{
				parentOfDel = del;
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
			if(parentOfDel.left== del) parentOfDel.left = null;
			else parentOfDel.right =null;
		}
		else if(del.left == null)
		{
			if(parentOfDel.left == del) parentOfDel.left = del.right;
			else parentOfDel.right= del.right;
		}
		else if(del.right == null)
		{
			if(parentOfDel.left == del) parentOfDel.left = del.left;
			else parentOfDel.right = del.left;
		}
		else
		{
			TreeNode<Integer> parentOfReplacement= del;
			replacement = del.right;		
			while(replacement.left!=null)
			{
				parentOfReplacement = replacement;
				replacement = replacement.left;
			}
			if(parentOfReplacement.left==replacement) parentOfReplacement.left= replacement.right;
			else parentOfReplacement.right = replacement.right;
			
			replacement.left = del.left;
			replacement.right = del.right;
			
			
			if(parentOfDel.left==del) parentOfDel.left=replacement;
			else  parentOfDel.right = replacement;

		}
		if(del!=root)
			return root;
		else
			return replacement;
	}
	public <T> void addSiblingLink(TreeNode<T> root)
	{
		if(root==null)	return;
		TreeNode<T> head=root, p= null, prev =null;
		while(head!=null)
		{
			prev=null;
			p=head;
			head=null;
			while(p!=null)
			{
				if(p.left!=null)
				{
					if(prev!=null) 
					{
						prev.sibling=p.left;
						prev= prev.sibling;
					}
					else
					{
						prev=p.left;
						head= prev;
					}
				}
				if(p.right !=null)
				{
					if(prev!=null) 
					{
						prev.sibling = p.right;
						prev= prev.sibling;
					}
					else 
					{
						prev = p.right;
						head=prev;
					}
				}
				p=p.sibling;
			}
		}
	}
	public <T> void printByLevel(TreeNode<T> root)
	{
		if(root==null) return;
		List<TreeNode<T>> list = new ArrayList<TreeNode<T>>();
		list.add(root);
		int nextCount=0,currentCount=1;
		while(list.size()>0)
		{
			TreeNode<T> item = list.remove(0);
			System.out.print(item.data +" ");
			if(item.left!=null)
			{
				list.add(item.left);
				nextCount++;
			}
			if(item.right!=null)
			{
				list.add(item.right);
				nextCount++;
			}
			currentCount--;
			if(currentCount==0)
			{
				System.out.println();
				currentCount=nextCount;
				nextCount=0;
			}
		}
	}
}




