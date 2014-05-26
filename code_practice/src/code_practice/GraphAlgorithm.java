package code_practice;

import java.util.*;

class GraphNode<T>
{
	T data;
	List<GraphNode<T>> links;
	public GraphNode(T data)
	{
		this.data = data;
	}
	public void addLink(GraphNode<T> next)
	{
		if(links==null)
			links = new ArrayList<GraphNode<T>>();
		if(links.contains(next)) return;
		links.add(next);
		next.addLink(this);
	}
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof GraphNode<?>)
		{
			return ((GraphNode<?>)o).data.equals(data);
		}
		return false;
	}
}
class GraphByMatrix<T>
{
	T[] V;
	int[][] E;
	int n;
	GraphByMatrix(T[] V, int n, int[][]E)
	{
		this.V = V;
		this.n = n;
		this.E = E;
	}
	GraphByMatrix(int[][] E)
	{
		this.E=E;
	}
}
class GraphByList<T>
{
	static class Edge
	{
		int weight;
		int v;
		Edge next;
		Edge(int weight, int v)
		{
			this.weight = weight;
			this.v = v;
		}
	}
	static class Vertex<T>
	{
		T data;
		Edge edgeHead;
		Vertex(T data)
		{
			this.data = data;
		}
	}
	Vertex<T>[] V;	
}
public class GraphAlgorithm<T>
{
	int minLen = Integer.MAX_VALUE;
	List<GraphNode<T>> curPath= new ArrayList<GraphNode<T>>();
	boolean found = false;
	void findShortestPath(GraphNode<T> start, GraphNode<T> end, List<GraphNode<T>> minPath)
	{
		if(start==null || end == null || curPath == null)
			return;
		if(curPath.contains(start)) 
			return;		
		curPath.add(start);
		if(start==end)
		{
			if(curPath.size()<minLen)
			{
				minPath.clear();
				minPath.addAll(curPath);
				minLen = curPath.size();	
				found = true;
			}
		}
		else if(start.links!=null)
		{
			for(GraphNode<T> link : start.links)
			{
				findShortestPath(link, end, minPath);
				if(found)
				{
					found = false;
					break;
				}
			}
		}
		curPath.remove(start);
	}
	
	HashSet visited = new HashSet();
	void DFS(GraphNode<T> start)
	{
		if(start==null || visited.contains(start)) return;

		System.out.println(start.data);
		visited.add(start);
		if(start.links!=null)
		{
			for(GraphNode<T> link : start.links)
			{
				DFS(link);
			}
		}
	}
	
	Queue<GraphNode<T>>  queue = new LinkedList<GraphNode<T>>();
	void BFS(GraphNode<T> start)
	{
		if(start==null) return;
		queue.add(start);
		
		while(queue.size()>0)
		{
			GraphNode<T> node = queue.remove();
			if(visited.contains(node)) 
				continue;
			System.out.println(node.data);
			visited.add(node);
			if(start.links!=null)
			{
				for(GraphNode<T> link : node.links)
				{
				//	if(!visited.contains(link)) 
						queue.add(link);
				}
			}
		}			
	}
	
	int[] dijkstra(int source, GraphByMatrix g)
	{
		int n = g.E.length;
		int[] dist = new int[n];
		List<Integer> S = new ArrayList<Integer>();
		List<Integer> U = new ArrayList<Integer>();
		for(int i=0; i<n;i++)
		{
			U.add(i);
			if(i==source)
				dist[i] =0;
			else
				dist[i] = g.E[source][i];
		}
		S.add(source);
		U.remove((Integer)source);
		while(S.size()<n)
		{
			int minLen = Integer.MAX_VALUE;
			int w = -1;
			for(int v : U)
			{			
				if(dist[v]<minLen)
				{
					minLen = dist[v];
					w = v;
				}
			}
			S.add(w);
			U.remove((Integer)w);
			for(int v: U)
			{
				dist[v] = Math.min(dist[v], dist[w]+g.E[w][v]);
			}
		}
		return dist;
	}
}