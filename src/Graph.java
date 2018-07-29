import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class Graph {

	private LinkedList<Integer> newGraph[];
	
	Graph(int v)
	{
		newGraph = new LinkedList[v];
		for(int i =0; i<v;i++)
		{
			newGraph[i]=new LinkedList();
		}
	}
	
	void addEdge(int v ,int w)
	{
		newGraph[v].add(w);
	}
	
	int minEdges(int v , int root , int edgefrom , int edgeto)
	{
LinkedList<Integer>q = new LinkedList<Integer>();
		boolean visited[] = new boolean[v];
		int dist[]= new int[v];
		q.add(root);
		visited[root]=true;
		
		while(!q.isEmpty())
		{
			int popped = q.poll();
			Iterator<Integer> i = newGraph[popped].listIterator();

			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n]=true;
					dist[n]=dist[popped]+1;
					q.add(n);

				}
				
			}
			
			
		}
		return dist[edgeto];
		 
	}
	 
	
	void displayGraph()
	 {
		 int i=0;

		 for(i=0;i<newGraph.length;i++)
		 {
	         Iterator<Integer> j = newGraph[i].listIterator();
	         System.out.print(i);
	         while(j.hasNext())
	         {
	        	 System.out.print("->"+j.next());
	         }

	         System.out.println();
		 }
	 }
	 
	public static void main(String args[])
	{
		
		Graph g = new Graph(5);
		g.addEdge(0,  1);
		g.addEdge(0, 4);
		g.addEdge(1, 0);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 1);
		g.addEdge(3, 4);
		g.addEdge(3, 2);
		g.addEdge(4, 0);
		g.addEdge(4, 3);
		
		g.displayGraph();
		System.out.println("Minimum number of edges are : "+ g.minEdges(5, 1 , 1 , 2));
	}

}
