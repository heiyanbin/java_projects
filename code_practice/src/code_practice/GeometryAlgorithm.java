package code_practice;
import java.util.*;
enum Color
{
	Red,
	Green,
	Blue,
	Yellow,
	White,
	Blank ,
}
class PaintOp
{
	int start;
	int end;
	Color color;
	PaintOp(int start, int end, Color color)
	{
		this.start = start;
		this.end = end;
		this.color = color;
	}
	ColoredSegment toSegment()
	{
		return new ColoredSegment(start, end, color);
	}
}
class Segment
{
	int start; 
	int end;
	Segment(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	static class ByStartComparator implements Comparator<Segment>
	{
		@Override
		public int compare(Segment a, Segment b)
		{
			if(a==null || b==null) throw new IllegalArgumentException();
			return ((Integer)a.start).compareTo(b.start);
		}
	}
}
class ColoredSegment extends Segment
{
	Color color;
	ColoredSegment(int start, int end, Color color)
	{	
		super(start,end);
		this.color = color;
	}
	@Override
	public boolean equals(Object o)
	{
		if(o!=null && o instanceof ColoredSegment)
		{
			ColoredSegment o2 = (ColoredSegment)o;
			return color==o2.color && start == o2.start && end == o2.end;
		}
		return false;
	}
}
class Point
{
	int x;
	int y;
	Color color;
	Point(int x, Color color)
	{
		this.x = x;
		this.color = color;
	}
	Point(int x)
	{
		this(x,Color.Blank);
	}
	Point(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
}


public class GeometryAlgorithm 
{
	 ColoredSegment[] paintLine(PaintOp[] ops)
	 {
		 List<ColoredSegment> segmentList = new ArrayList<ColoredSegment>();
		 for(PaintOp op : ops)
		 {			 
			 int  i =0;
			 while(i<segmentList.size() &&  op.start>= segmentList.get(i).end)
			 {
				i++;
			 }
			 if(i<segmentList.size() && op.start>segmentList.get(i).start)
			 {
				 segmentList.get(i).end =op.start;
				 i++;
			 }
			 segmentList.add(i, op.toSegment());
			 i++;
				 
			 while(i<segmentList.size() && (op.end>=segmentList.get(i).end))
			 {
				 segmentList.remove(i);
			 }
			 if(i<segmentList.size())
				 segmentList.get(i).start = op.end;			 
		 }
		 return segmentList.toArray(new ColoredSegment[0]);
	 }
	 Point[] paintLine2(PaintOp[] ops)
	 {
		List<Point> l = new ArrayList<Point>();
		for(PaintOp op : ops)
		{
			int i = 0;
			Color prevColor = null;
			while(i<l.size() && op.start > l.get(i).x)
			{		
				prevColor = l.get(i).color;
				i++;
			}
			if(i<l.size() && op.start == l.get(i).x)
			{
				prevColor = l.get(i).color;
				l.get(i).color	= op.color;
			}
			else
			{
				l.add(i, new Point(op.start,op.color));
			}
			i++;
			while(i<l.size() && op.end > l.get(i).x)
			{
				prevColor = l.get(i).color;
				l.remove(i);
			}
			if(i<l.size() && op.end < l.get(i).x)
			{
				l.add(i, new Point(op.end,prevColor));
			}	
			else if(i>=l.size())
			{
				l.add(new Point(op.end, Color.Blank));
			}
		}
		return l.toArray(new Point[0]);
	 }
int wholeLength(Segment[] a)
	 {
		 if(a==null) throw new IllegalArgumentException();
		 Arrays.sort(a, new Segment.ByStartComparator());
		 int len =0, last = Integer.MIN_VALUE;
		 for(Segment s : a)
		 {
			 if(s.end<=last) continue;
			 len += s.end - s.start;
			 if(s.start<last)
			 {
				 len -= last - s.start;
			 }
			 last = s.end;
		 }
		 return len;
	 }
}