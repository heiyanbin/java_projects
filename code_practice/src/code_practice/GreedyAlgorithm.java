package code_practice;
import java.util.*;

class Commodity implements Comparable<Commodity>
{
	int name;
	int value;
	int maxAmount;
	@Override 
	public int compareTo(Commodity o)
	{
		if(o==null) throw new IllegalArgumentException();
		return ((Integer)value).compareTo(o.value);
	}
}

class Ware implements Comparable<Ware>
{
	int ATime;
	int BTime;
	Ware(int a, int b)
	{
		this.ATime = a;
		this.BTime = b;
	}
	public int compareTo(Ware o)
	{
		if(o==null) throw new IllegalArgumentException();
		return ((Integer)ATime).compareTo(o.ATime);
	}
	static class MinTimeComparator implements Comparator<Ware>
	{
		@Override
		public int compare(Ware w1, Ware w2)
		{
			if(w1==null || w2 == null)
				throw new IllegalArgumentException();
			return ((Integer)Math.min(w1.ATime, w1.BTime)).compareTo(Math.min(w2.ATime, w2.BTime));
		}
	}
}
public class GreedyAlgorithm 
{
	int knapsack(Commodity[] a, int C)
	{
		if(a==null || C< 0) throw new IllegalArgumentException();
		if(a.length == 0 || C== 0 )return 0;
		Arrays.sort(a);
		reverse(a);
		int sumValue = 0;
		for(int i=0;i<a.length && C>0;i++)
		{
			int grab = a[i].maxAmount<=C ? a[i].maxAmount : C;
			sumValue += grab * a[i].value;
			C=C-grab;
			System.out.println(a[i].name + a[i].maxAmount);		
		}
		System.out.println(sumValue);
		return sumValue;
	}
	
	int minTotalProcessTime(Ware[] a)
	{
		Arrays.sort(a,new Ware.MinTimeComparator());
		for(int i=0,j=a.length-1;i<j;)
		{
			if(a[i].ATime<=a[i].BTime)
				i++;
			else
			{	
				Ware w = a[i];
				int k=i+1;
				while(k<=j)
				{
					a[k-1]=a[k];
					k++;
				}
				a[k-1]=w;
				j--;
			}			
		}
		int aLast=0, bLast=0;
		for(Ware w : a)
		{
			aLast += w.ATime;
			bLast = Math.max(aLast,bLast) + w.BTime;
		}
		return bLast;
	}
	
	int dispatchWork(int[] works, int machineCount)
	{
		if(machineCount<1) throw new IllegalArgumentException();
		if(works==null || works.length ==0) return 0;	
		
		Arrays.sort(works);
		int[] machineTime = new int[machineCount];
		int i=0;
		while(i < works.length)
		{
			int k = 0;			
			while(i+k < works.length && k <machineCount)
			{
				k++;
			}
			for(int j= 0; j<k;j++)
			{
				machineTime[j] += works[i+k-j-1];
			}
			Arrays.sort(machineTime);
			i=i+k;
		}
		return machineTime[machineCount-1];
	}
	
	void travel(int[] d, int[] p, int C, double dl, int D)
	{
		if(d==null || d.length==0 || p == null || p.length == 0 || d.length != p.length || C<=0 || dl<=0 || D<=0)
			throw new IllegalArgumentException();
		int n = d.length;
		List<Double> addGas = new ArrayList<Double>();
		List<Integer> stationList = new ArrayList<Integer>();
		int i=0;
		stationList.add(0);
		while(i<n)
		{
			int j=i+1;
			if(d[j]-d[i]>C*dl)
				throw new RuntimeException("Could not reach next station.");
			while( j<n && p[j]>p[i])
			{
				j++;
			}
			if(j<n && C*dl>=d[j])
			{
				
				addGas.add((d[j]-d[i])/dl);
				stationList.add(j);
				i=j;
			}
			else
			{
				addGas.add(C+0.0);
				stationList.add(i+1);
				i++;
			}
		}
		for(int station : stationList)
			System.out.println(station);
	}
	<T> void reverse(T[] a)
	{
		if(a==null || a.length==0) return;
		int i= 0, j=a.length-1;
		while(i<j)
		{
			T temp= a[i];
			a[i]=a[j];
			a[j]=temp;
			i++;j--;
		}
	}
}
