package code_practice;
import static org.junit.Assert.*;
import java.util.*;

import org.junit.Assert;
import org.junit.Test;


public class GeometryAlgorithmTest {

	GeometryAlgorithm target = new GeometryAlgorithm();
	@Test
	public void testPaintLine() {
		PaintOp[] ops = new PaintOp[]
		{
				new PaintOp(0,4,Color.Red),
				new PaintOp(1,3,Color.Blue),
				new PaintOp(5,7,Color.Green),
				new PaintOp(3,6,Color.Yellow),
				new PaintOp(8,10,Color.Red),
				new PaintOp(11,13,Color.Blue),
				new PaintOp(9,12,Color.Yellow)
		};
		ColoredSegment[] s = target.paintLine(ops);
		assertEquals(new ColoredSegment(0,1, Color.Red), s[0]);
		assertEquals(new ColoredSegment(1,3, Color.Blue), s[1]);
		assertEquals(new ColoredSegment(3,6, Color.Yellow), s[2]);
		assertEquals(new ColoredSegment(6,7, Color.Green), s[3]);
		assertEquals(new ColoredSegment(8,9, Color.Red), s[4]);
		assertEquals(new ColoredSegment(9,12, Color.Yellow), s[5]);
		assertEquals(new ColoredSegment(12,13, Color.Blue), s[6]);
		
		Point[] pArray = target.paintLine2(ops);
		List<ColoredSegment> sList = new ArrayList<ColoredSegment>();
		Point prev = null;
		for(int i=0;i<pArray.length;i++)
		{
			if(prev==null)
			{
				prev = pArray[i];
			}
			else
			{
				if(prev.color != Color.Blank)
				{
					sList.add(new ColoredSegment(prev.x, pArray[i].x, prev.color));
					System.out.println(prev.x + " " + pArray[i].x + " " + prev.color);
				}			
				prev = pArray[i];
			}
			
		}
		Assert.assertArrayEquals(s, sList.toArray(new ColoredSegment[0]));
	}
	
	@Test
	public void testWhoeLength()
	{
		int len = target.wholeLength(new Segment[]{
				new Segment(1,3), 
				new Segment(2,4),
				new Segment(0,1),
				new Segment(5,8),
				new Segment(10,11),
				new Segment(7,9)
				});
		assertEquals(4 + 4 + 1,len);
	}
	
	
	
	@Test
	public void testDeleteList()
	{
		List<Integer> l = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
		for(int i=0;i<l.size();)
		{
			if(l.get(i)>=4)
				l.remove(i);
			else
				i++;
		}
		
		assertEquals(3,l.size());
		for(int i=0;i<l.size();i++)
			assertEquals(i+1,l.get(i).intValue());
	}
	
}
