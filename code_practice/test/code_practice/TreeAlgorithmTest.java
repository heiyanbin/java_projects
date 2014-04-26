package code_practice;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TreeAlgorithmTest {

	TreeAlgorithm target;
	int array[];
	TreeNode<Integer> root;
	@Before
	public void setUp() throws Exception {
		target = new TreeAlgorithm();
		array = new int[]{3,2,1,4,5,6,3};
		root = target.buildBinarySearchTree(array);
	}

	@Test
	public void testBuildBinarySearchTree() 
	{
		target.inOrder(root);
	}

	@Test
	public void testRemoveNodeFromBinarySearchTree() 
	{
		TreeNode<Integer> newRoot = target.removeNodeFromBinarySearchTree(root, 4);
		target.inOrder(newRoot);

	}
	
	@Test
	public void testAddSiblingLink()
	{
		target.addSiblingLink(root);
		TreeNode<Integer> head= root, p;
		while(head!=null)
		{
			p=head;
			head=null;
			while(p!=null)
			{
				System.out.print(p.data+ " ");
				if(head==null)
				{
					if(p.left!=null) head= p.left;
					else if(p.right!=null) head=p.right;
				}
				p=p.sibling;
			}	
			System.out.println();
		}
	}
	@Test
	public void testPrintByLevel()
	{
		target.printByLevel(root);
	}

}
