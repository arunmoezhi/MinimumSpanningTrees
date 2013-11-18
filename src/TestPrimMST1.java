import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TestPrimMST1 
{
	public static void main(String[] args)
	{
		long start,end;
		Scanner scanner;
		try 
		{
			start = System.currentTimeMillis();
			scanner = new Scanner(new File("input.txt"));
			EdgeWeightedGraph G = new EdgeWeightedGraph(scanner);
			//G.printGraph();
			PrimMST1 primMST1 = new PrimMST1(G);
			System.out.println(primMST1.getWMST());
			end = System.currentTimeMillis();
			System.out.println("Time Taken: " + (end-start) + "ms");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
