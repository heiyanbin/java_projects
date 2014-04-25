package code_practice;

class TreeNode<T>
{
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	
	public TreeNode(T data) { this.data = data;}
}

public class TreeAlgorithm {
	public TreeNode<Integer> buildBinarySearchTree (int[] array, int begin, int end)
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

}




