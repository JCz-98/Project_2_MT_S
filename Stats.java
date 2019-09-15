package BST_A2;

import java.util.Arrays;

public class Stats 
{
	
	public static double getSTD_D(int[] ord)
	{
		
		//u = results[1];
		
		
		double u = Arrays.stream(ord).average().getAsDouble();
		
		System.out.println("\nMEDIA.A --> " + u);
		
		double varianza = 
				Arrays.stream(ord)
				.mapToDouble(x -> Math.pow(x -u, 2.0))
				.sum();
		
		double std_dev = Math.sqrt(varianza/(ord.length-1));
		
		return std_dev;
		
	}
	
	public static double getMedian(int[] ord) 
	{
		
		int length = ord.length;
		int idx = length/2;
		
		//if is even 
		if (length % 2 == 0) 
		{
			//System.out.printf("%d %d", array_to_analyze[idx],array_to_analyze[idx-1]);
			return (((double)ord[idx] + (double)ord[idx-1])/2);
		}
		
		//else odd
		//System.out.println("here");
		return ord[idx];
	}
	
	public static double[] getQuartiles(int[] ord)
	{
		double[] qrs = new double[3];
		
		int length = ord.length;
		int idx = length/2;
		
		qrs[1] = getMedian(ord); //Quartile 2
		
		if (length % 2 == 0) 
		{
			int[] set1 = Arrays.copyOfRange(ord, 0, idx-1);
			int[] set3 = Arrays.copyOfRange(ord, idx+1, length);
			
//			for(int i: set1)
//			{
//				System.out.print(i + " ");
//			}
//			System.out.println( " ");  //eliminar
//			for(int i: set3)
//			{
//				System.out.print(i + " ");
//			}
			
			qrs[0] = getMedian(set1); //quartile1
			qrs[2] = getMedian(set3); //quartile3
		}
		else
		{
			int[] set1 = Arrays.copyOfRange(ord, 0, idx);
			int[] set3 = Arrays.copyOfRange(ord, idx+1, length);
			
//			for(int i: set1)
//			{
//				System.out.print(i + " ");
//			}
//			System.out.println( " "); //eliminar
//			for(int i: set3)
//			{
//				System.out.print(i + " ");
//			}
			
			qrs[0] = getMedian(set1); //quartile1
			qrs[2] = getMedian(set3); //quartile3
		}
		
		
		return qrs;
		
	}

}
