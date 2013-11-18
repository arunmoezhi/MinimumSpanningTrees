import java.util.ArrayList;
import java.util.Scanner;


public class EdgeWeightedGraph 
{
	private final int V;
	private final int E;
	private ArrayList<Edge>[] adj;

	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(Scanner in)
	{
		this.V = in.nextInt();
		this.E = in.nextInt();
		int u,v,w;
		adj = (ArrayList<Edge>[]) new ArrayList[V+1];
		for(int i=1;i<=V;i++)
		{
			adj[i] = new ArrayList<Edge>();
		}
		for(int i=0;i<E;i++)
		{
			u=in.nextInt();
			v=in.nextInt();
			w=in.nextInt();
			Edge e = new Edge(u,v,w);
			addEdge(e);
		}

	}

	public void addEdge(Edge e)
	{
		int u = e.thisEnd();
		int v = e.otherEnd(u);
		adj[u].add(e);
		adj[v].add(e);
	}

	public int getV()
	{
		return V;
	}

	public int getE()
	{
		return E;
	}

	public Iterable<Edge> getAdj(int v)
	{
		return adj[v];
	}

	public void printGraph()
	{
		for(int i=1;i<=V;i++)
		{
			for(Edge e : getAdj(i))
			{
				int u = e.thisEnd();
				int v = e.otherEnd(u);
				int w = e.getW();
				System.out.print("(" + u + "," + v + "," + w + ")");
				//System.out.print(e + "\t");
			}
			System.out.println();
		}
	}
}
