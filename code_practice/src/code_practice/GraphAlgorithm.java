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
class Graph<T>
{
	List<GraphNode<T>> V = new ArrayList<GraphNode<T>>();
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
		if(start==null) return;
		System.out.print(start.data+" ");
		visited.add(start);
		if(start.links!=null)
		{
			for(GraphNode<T> link : start.links)
			{
				if(!visited.contains(link))
					DFS(link);
			}
		}
	}
	void DFS(Graph<T> g)
	{
		visited.clear();
		for (GraphNode<T> v : g.V)
		{
			if(!visited.contains(v))
				DFS(v);
		}
	}
	void DFSByIteration(GraphNode<T> start)
	{
		if(start == null) return;
		visited.clear();
		Stack<GraphNode<T>> stack = new Stack<GraphNode<T>>();
		Stack<Integer> stack2 = new Stack<Integer>();
		int i=0;
		while(start!=null || !stack.isEmpty())
		{
			if(start!=null)
			{
				if(i==0)
				{
					System.out.print(start.data + " ");
					visited.add(start);
				}
				if(start.links!=null && !start.links.isEmpty() && i<start.links.size())
				{
					while(i<start.links.size() && visited.contains(start.links.get(i)))
						i++;
					if(i>=start.links.size())
					{	
						start = null;
						continue;
					}
					
					int j =i+1;
					while(j<start.links.size() && visited.contains(start.links.get(j)))
						j++;
					if(j<start.links.size())
					{	
						stack.push(start);				
						stack2.push(j);
					}	
					start = start.links.get(i);
					i=0;					
				}
				else
					start=null;
			}
			else
			{
				start = stack.pop();
				i= stack2.pop();
			}		
		}
	}
	
	void BFS(GraphNode<T> start)
	{
		if(start==null) return;
		Queue<GraphNode<T>>  queue = new LinkedList<GraphNode<T>>();
		queue.add(start);
		
		while(queue.size()>0)
		{
			GraphNode<T> node = queue.remove();
			if(visited.contains(node)) 
				continue;
			System.out.println(node.data + " ");
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
	void BFS(Graph<T> g)
	{
		visited.clear();
		for (GraphNode<T> v : g.V)
		{
			if(!visited.contains(v))
				BFS(v);
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
	
	boolean hasLoop(Graph<T> g )
	{
		for(int i=1;i<g.V.size() && visited.size()<g.V.size();i++)
		{
			visited.clear();
			if(hasLoop(g.V.get(i),null))
				return true;
		}
		return false;
	}
	boolean hasLoop(GraphNode<T> start, GraphNode<T> prev)
	{
		if(start==null) return false;
		visited.add(start);
		if(start.links!=null)
		{
			for(GraphNode<T> link : start.links)
			{
				if(link == prev)
					continue;						
				if(visited.contains(link))
					return true;
				if(hasLoop(link, start))
					return true;
				
			}
		}
		return false;
	}
}