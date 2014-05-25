package code_practice;
import java.util.*;

class Thing implements Comparable<Thing>
{
	int name;
	int value;
	int amount;
	@Override 
	public int compareTo(Thing o)
	{
		if(o==null) throw new IllegalArgumentException();
		return ((Integer)value).compareTo(o.value);
	}
}

class WorkItem implements Comparable<WorkItem>
{
	int ATime;
	int BTime;
	WorkItem(int a, int b)
	{
		this.ATime = a;
		this.BTime = b;
	}
	public int compareTo(WorkItem o)
	{
		if(o==null) throw new IllegalArgumentException();
		return ((Integer)ATime).compareTo(o.ATime);
	}
	static class MinTimeComparator implements Comparator<WorkItem>
	{
		@Override
		public int compare(WorkItem w1, WorkItem w2)
		{
			if(w1==null || w2 == null)
				throw new IllegalArgumentException();
			return ((Integer)Math.min(w1.ATime, w1.BTime)).compareTo(Math.min(w2.ATime, w2.BTime));
		}
	}
}
public class GreedyAlgorithm 
{
	int knapsack(Thing[] a, int C)
	{
		if(a==null || C< 0) throw new IllegalArgumentException();
		if(a.length == 0 || C== 0 )return 0;
		Arrays.sort(a);
		reverse(a);
		int sumValue = 0;
		for(int i=0;i<a.length && C>0;i++)
		{
			int grab = a[i].amount<=C ? a[i].amount : C;
			sumValue += grab * a[i].value;
			C=C-grab;
			System.out.println(a[i].name + a[i].amount);		
		}
		System.out.println(sumValue);
		return sumValue;
	}
	
	int minWorkTime(WorkItem[] a)
	{
		Arrays.sort(a,new WorkItem.MinTimeComparator());
		for(int i=0,j=a.length-1;i<j;)
		{
			if(a[i].ATime<=a[i].BTime)
				i++;
			else
			{	
				WorkItem w = a[i];
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
		for(WorkItem w : a)
		{
			aLast += w.ATime;
			bLast = Math.max(aLast,bLast) + w.BTime;
		}
		return bLast;
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
