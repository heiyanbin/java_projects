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
}