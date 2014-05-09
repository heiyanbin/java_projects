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

class TrieNode
{
	Character letter;
	boolean isWord;
	int wordCount;
	List<TrieNode> subfixes= new LinkedList<TrieNode>();
	TrieNode(Character letter) {this.letter = letter;}
	TrieNode addOrFindChild(char c)
	{
		TrieNode p;
		if(subfixes.isEmpty())
		{
			p = new TrieNode(c);
			subfixes.add(p);
			return p;
		}
		else
		{
			int i = 0;
			while(i<subfixes.size() || subfixes.get(i).letter<c)
				i++;
			if(i>=subfixes.size())
			{
				p = new TrieNode(c);
				subfixes.add(p);
				return p;
			}
			if(subfixes.get(i).letter== c)
			{
				return subfixes.get(i);
			}
			else
			{
				p = new TrieNode(c);
				subfixes.add(i,p);
				return p;
			}
		}
	}
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
	public TrieNode buildTrie(String[] words)
	{
		TrieNode root  = new TrieNode(null);	
		if (words==null) return root;
		for(String word : words	)
		{
			if(word==null || word=="") continue;
			TrieNode p = root;
			for(char c : word.toLowerCase().toCharArray())
			{
				TrieNode q = null;
				if(p.subfixes.isEmpty())
				{
					q= new TrieNode(c);
					p.subfixes.add(q);
				}
				else
				{
					int i= 0;
					while(i<p.subfixes.size() && p.subfixes.get(i).letter<c)
						i++;
					if(i>=p.subfixes.size())
					{
						q= new TrieNode(c);
						p.subfixes.add(q);
					}
					if(c<p.subfixes.get(i).letter)
					{
						q= new TrieNode(c);
						p.subfixes.add(i,q);
					}
					else
					{
						q=p.subfixes.get(i);
					}
				}
				p=q;
			}	
			p.wordCount++;
		}
		return root;
	}
	List<TrieNode> path = new LinkedList<TrieNode>();
	public void printAllWords(TrieNode root)
	{
		if(root==null)
			return;
		path.add(root);
		if(root.wordCount>0)
		{
			for(TrieNode t : path)
				if(t.letter!=null)
					System.out.print(t.letter);
			System.out.println(" "+ root.wordCount);	
		}
		for(TrieNode child : root.subfixes)
		{
			printAllWords(child);
		}
		path.remove(root);
		
	}
	
	public <T> TreeNode<T> LCA(TreeNode<T> root, TreeNode<T> a, TreeNode<T> b)
	{
		if(root==null||a==null||b==null) return null;
		if(root==a||root==b) return root;
		if(isPartOf(root.left, a) && isPartOf(root.right,b) || isPartOf(root.right, a) && isPartOf(root.left, b)) 
			return root;
		if(isPartOf(root.left, a) && isPartOf(root.left,b)) return LCA(root.left, a, b);
		if(isPartOf(root.right,a) && isPartOf(root.right,b)) return LCA(root.right, a, b);
		return null;
	}
	
	public <T> TreeNode<T> LCA2(TreeNode<T> root, TreeNode<T> a, TreeNode<T> b)
	{
		if(root==null||a==null||b==null) return null;
		if(root==a||root==b) return root;
		Integer num = 0;
		has(root.left,a,b,num);
		if(num==1)
		{
			//if()
		}
		return null;
	}
	public <T> boolean isPartOf(TreeNode<T> root, TreeNode<T> a)
	{
		if(root==null) return false;
		if(a==null) return true;
		if(root==a) return true;
		return isPartOf(root.left, a)||isPartOf(root.right,a);
	}
	public <T> void has (TreeNode<T> root, TreeNode<T> a, TreeNode<T> b, Integer num)
	{
		if(a==null||b==null||a==b) throw new IllegalArgumentException();
		if(root == null) return;
		if(root==a||root==b) num++;
		has(root.left, a, b, num);
		has(root.right, a, b, num);
	}
	public <T> TreeNode<T> find(TreeNode<T> root, T value)
	{
		if(root==null||value==null) return null;
		if(root.data.equals(value)) return root;
		TreeNode<T> t = find(root.left, value);
		if(t!=null) return t;
		return find(root.right, value);
		
	}

}




