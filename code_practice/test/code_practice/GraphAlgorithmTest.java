package code_practice;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class GraphAlgorithmTest {

	GraphAlgorithm<Integer> target;
	List<GraphNode<Integer>> g;
	@Before
	public void setUp() throws Exception 
	{
		g = new ArrayList<GraphNode<Integer>>();
		g.add(null);
		for (int i=1;i<=6;i++)
			g.add(new GraphNode<Integer>(i));
		
		g.get(1).addLink(g.get(2));
		g.get(1).addLink(g.get(3));
		g.get(1).addLink(g.get(4));
		g.get(3).addLink(g.get(6));
		g.get(4).addLink(g.get(5));
		g.get(5).addLink(g.get(6));		
		
		target = new GraphAlgorithm<Integer>();
	}

	@Test
	public void testFindShortestPath() 
	{
		List<GraphNode<Integer>> minPath = new ArrayList<GraphNode<Integer>>();
		target.findShortestPath(g.get(1), g.get(6), minPath);
		for(GraphNode<Integer> node : minPath)
			System.out.println(node.data);
	}

	@Test
	public void testDFS()
	{
		target.DFS(g.get(1));
	}
	
	@Test
	public void testBFS()
	{
		target.BFS(g.get(1));
	}
	
	@Test
	public void test()
	{
		List<Integer> list = new ArrayList<Integer>(); 
		for(int i= 0;i<3;i++)
			list.add(0,i);
		
		list.add(4,4);
		
		System.out.println();
	}
}
