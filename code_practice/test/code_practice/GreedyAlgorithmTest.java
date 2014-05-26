package code_practice;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreedyAlgorithmTest {

	GreedyAlgorithm target = new GreedyAlgorithm();
	//@Test
	public void testKnapsack() {
		fail("Not yet implemented");
	}

	@Test
	public void testMinWorkTime() {
		WorkItem[] works = new WorkItem[]
		{
			new WorkItem(3,6),
			new WorkItem(5,2),
			new WorkItem(8,1),
			new WorkItem(7,4),
			new WorkItem(10,9),
		};
		assertEquals(34,target.minWorkTime(works));
	}
	
	@Test
	public void testDispatchWork() {
		assertEquals(4, target.dispatchWork(new int[]{1,4,2}, 5));
		assertEquals(5, target.dispatchWork(new int[]{1,4,2}, 2));
		assertEquals(12, target.dispatchWork(new int[]{4,2,7,10}, 2));
		assertEquals(19, target.dispatchWork(new int[]{4,2,7,5,10}, 2));
		assertEquals(12, target.dispatchWork(new int[]{4,2,7,5,10}, 3));
		
		
	}

}
