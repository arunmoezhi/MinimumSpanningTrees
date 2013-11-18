import java.util.PriorityQueue;

public class PrimMST1 
{
	private int wMST;
	//private HashSet<Edge> mstEdges;
	private PriorityQueue<Edge> pq;
	private boolean[] marked;

	public PrimMST1(EdgeWeightedGraph G)
	{
		//mstEdges = new HashSet<Edge>();
		pq = new PriorityQueue<Edge>();
		marked = new boolean[G.getV()+1];
		primMST1(G,1);
	}

	private void primMST1(EdgeWeightedGraph G, int s)
	{
		marked[s] = true;
		for(Edge e : G.getAdj(s))
		{
			pq.add(e);
		}
		while(!pq.isEmpty())
		{
			Edge e = pq.remove(); //smallest edge crossing the cut
			int u = e.thisEnd();
			int v = e.otherEnd(u);
			if(marked[u] && marked[v])
			{
				continue;
			}
			wMST += e.getW();
			if(!marked[v]) // can add v to marked
			{
				marked[v] = true;
				for(Edge x : G.getAdj(v))
				{
					if(!marked[x.otherEnd(v)]) //if the vertex at the other end is unmarked, add the edge to pq
					{
						pq.add(x);
					}
				}
			}
			if(!marked[u]) // can add u to marked
			{
				marked[u] = true;
				for(Edge x : G.getAdj(u))
				{
					if(!marked[x.otherEnd(u)]) //if the vertex at the other end is unmarked, add the edge to pq
					{
						pq.add(x);
					}
				}
			}
		}
	}
	
	public int getWMST()
	{
		return wMST;
	}

}
