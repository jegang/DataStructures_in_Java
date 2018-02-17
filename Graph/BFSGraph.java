/************************************************
*	FileName :  BFSGraph.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 17, 2018
*************************************************/
// Graph is implemented using Adjacent List

import java.util.*;

class Graph
{
	int numOfVertices;
	LinkedList<Integer> adj[];
	
	
	Graph(int numOfVertices)
	{
		this.numOfVertices = numOfVertices;
		adj = new LinkedList[numOfVertices];
		for(int i=0; i<numOfVertices; i++)
		{
			adj[i] = new LinkedList();
		}
	}
	
	
	void addDirectedEdge(int start, int end)
	{
		if(start < numOfVertices)
			adj[start].add(end);
		else
			System.out.println("The vertices is not available in Graph");
	}
	
	void BFS(int start)
	{
		System.out.println();
		boolean[] visited = new boolean[numOfVertices];
		for(int i=0; i<numOfVertices; i++)
		{
			visited[i] = false;
		}
		
		visited[start] = true;
		
		LinkedList<Integer> queue = new LinkedList();
		queue.add(start);
		int s = 0;
		while(queue.size() != 0)
		{
			s = queue.poll();
			System.out.print( s + " ");
			
			Iterator<Integer> itr = adj[s].iterator();
			while(itr.hasNext())
			{
				s = itr.next();
				if(visited[s] == false)
				{
					queue.add(s);
					visited[s] = true;
				}
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
		
		g.BFS(0);
		g.BFS(1);
		g.BFS(2);
		g.BFS(3);
		
		
		
		
		
	}
}
