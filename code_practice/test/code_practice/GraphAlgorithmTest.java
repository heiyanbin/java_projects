package code_practice;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class GraphAlgorithmTest {

	GraphAlgorithm<Integer> target;
	Graph<Integer> g;
	@Before
	public void setUp() throws Exception 
	{
		g = new Graph<Integer>();
		List<GraphNode<Integer>> V = g.V;
		V.add(null);
		for (int i=1;i<=6;i++)
			V.add(new GraphNode<Integer>(i));
		
		V.get(1).addLink(V.get(2));
		V.get(1).addLink(V.get(3));
		V.get(1).addLink(V.get(4));
	//	V.get(1).addLink(V.get(6));
		V.get(3).addLink(V.get(6));
		V.get(4).addLink(V.get(5));
	//	V.get(4).addLink(V.get(6));
	//	V.get(5).addLink(V.get(6));		
		target = new GraphAlgorithm<Integer>();
	}

	@Test
	public void testFindShortestPath() 
	{
		List<GraphNode<Integer>> minPath = new ArrayList<GraphNode<Integer>>();
		target.findShortestPath(g.V.get(1), g.V.get(6), minPath);
		for(GraphNode<Integer> node : minPath)
			System.out.println(node.data);
	}

	@Test
	public void testDFS()
	{
		target.DFS(g.V.get(1));
		System.out.println();
		target.DFSByIteration(g.V.get(1));
		System.out.println();
		target.DFS(g);
	}
	
	@Test
	public void testBFS()
	{
		target.BFS(g.V.get(1));
		System.out.println();
		target.BFS(g);
	}
	@Test
	public void testHasLoop()
	{
		System.out.println(target.hasLoop(g.V.get(1),null));
		System.out.println(target.hasLoop(g));
	}
	
	@Test
	public void testDijkstra()
	{
		int MAX = 10000;
		GraphByMatrix g = new GraphByMatrix(new int[][]
			{
				{0,5,3,5},
				{MAX,0,MAX,MAX},
				{MAX,1,0,4},
				{MAX,MAX,0,MAX}
			});
		int[] dist = target.dijkstra(0, g);
		assertArrayEquals(new int[]{0,4,3,5}, dist);
		for(int d : dist)
		{
			System.out.println(d);
		}
	}
}
