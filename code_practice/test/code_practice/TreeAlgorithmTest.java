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

	@Test
	public void testBuildTrie()
	{
		TrieNode root = target.buildTrie(new String[]{"i","am","best"});
		System.out.println();
	}
	@Test
	public void testPrintAllWords()
	{
		TrieNode root = target.buildTrie(new String[]{"inn", "int", "at", "age", "adv", "ant","inn"});
		target.printAllWords(root);
	}
	
	@Test
	public void testLCA()
	{
		TreeNode<Integer> root = target.buildBinarySearchTree(new int[]{5,3,2,4,8,6,7,9});
		TreeNode<Integer> a = target.find(root, 3);
		TreeNode<Integer> b = target.find(root, 7);
		assertEquals(root,target.LCA(root, a, b));
		a = target.find(root, 9);
		TreeNode<Integer> expected = target.find(root, 8);
		TreeNode<Integer> actual = target.LCA(root, a, b);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLCA2()
	{
		TreeNode<Integer> root = target.buildBinarySearchTree(new int[]{5,3,2,4,8,6,7,9});
		TreeNode<Integer> a = target.find(root, 3);
		TreeNode<Integer> b = target.find(root, 7);
		assertEquals(root,target.LCA2(root, a, b));
		a = target.find(root, 9);
		TreeNode<Integer> expected = target.find(root, 8);
		TreeNode<Integer> actual = target.LCA2(root, a, b);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testTranverseByStack()
	{
		target.preOrderByStack(root);
		System.out.print(" ");
		target.preOrder(root);
		System.out.println();
		
		target.inOrderByStack(root);
		System.out.print(" ");
		target.inOrder(root);
		System.out.println();
		
		target.postOrderByStack(root);
		System.out.print(" ");
		target.postOrder(root);
		System.out.println();
		
	}
	
}
