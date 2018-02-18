/************************************************
*	FileName :  DFSGraph.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 17, 2018
*************************************************/
// Adding element to Graph and performing DFS 
// in graph

import java.util.*;
class Graph
{
	private int numOfVertices;
	private LinkedList<Integer>[] adj;
	
	Graph(int numOfVertices)
	{
		this.numOfVertices = numOfVertices;
		adj = new LinkedList[numOfVertices];
		for(int i=0; i < numOfVertices; i++)
		{
			adj[i] = new LinkedList();
		}
	}
	
	
	void addDirectedEdge(int start, int end)
	{
		if(start < numOfVertices && end < numOfVertices)
			adj[start].add(end);
		else
			System.out.println("Vertice not available in Graph");
	}
	
	
	void DFS(int start)
	{
		System.out.println();
		boolean[] visited = new boolean[numOfVertices];
		for(int i=0; i<numOfVertices; i++)
		{
			visited[i] = false;
		}
		DFSSearch(start, visited);
	}
	
	void DFSSearch(int node, boolean[] visited)
	{
		if ( node >= numOfVertices || visited[node] == true)
			return;
		
		visited[node] = true;
		System.out.print(node + " ");
		Iterator<Integer> itr = adj[node].iterator();
		while(itr.hasNext())
		{
			int nextNode = itr.next();
			if(visited[nextNode] == false)
			{
				DFSSearch(nextNode, visited);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Graph g = new Graph(4);
		g.addDirectedEdge(0,1);
		g.addDirectedEdge(1,2);
		g.addDirectedEdge(2,3);
		g.addDirectedEdge(3,3);
		g.addDirectedEdge(0,2);
		g.addDirectedEdge(2,0);
		
		
		g.DFS(0);
		g.DFS(1);
		g.DFS(2);
		g.DFS(3);
		
	}
	
	
	
	
	
	
	
}