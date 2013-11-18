
public class Edge implements Comparable<Edge>
{
	private final int u;
	private final int v;
	private final int w;

	public Edge(int u, int v, int w)
	{
		this.u 	= u;
		this.v 	= v;
		this.w 	= w;
	}

	public int getW()
	{
		return this.w;
	}

	public int thisEnd()
	{
		return u;
	}
	public int otherEnd(int vertex)
	{
		if(vertex == u)
		{
			return v;
		}
		else if(vertex == v)
		{
			return u;
		}
		else
		{
			throw new IllegalArgumentException("This vertex is not in the graph");
		}
	}

	public int compareTo(Edge that) 
	{
		if(this.getW() < that.getW())
		{
			return -1;
		}
		else if (this.getW() > that.getW())
		{
			return +1;
		}
		else
		{
			return 0;
		}
	}
}
