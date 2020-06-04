package de.hfu;

import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;
import de.hfu.Queue;

public class QueueTest {
	final int queueSize = 3;
	int[] elements = {4,8, 52};
	Queue queue;
	
	// init for all tests
	@Before
	public void init() {
		queue = new Queue(queueSize);
		for (int el : elements) {
			queue.enqueue(el);		
		}
	}
	
	@Test
	public void returnOldestInQueue() {
		assertEquals(queue.dequeue(), elements[0]);	
	}
	
	@Test
	public void overrideLastWhenFull() {
		queue.enqueue(43);
		// dequeue all but not the last in queue
		for (int i = 0; i < queueSize - 1; i++) {
			queue.dequeue();
		}
		// last in queue
		assertEquals(queue.dequeue(), 43);
	}
	
	@Test
	public void doNotOverrideLastWhenSpace() {
		queue.dequeue();  // elements[0] is taken out
		queue.enqueue(67); // insert arbitrary number
		queue.dequeue(); // elements[1] is taken out
		assertEquals(queue.dequeue(), elements[2]); // is not overridden by 67
	}
	
	@Test(expected=IllegalStateException.class, timeout=1000)
	public void dequeueWhenEmpty() {
		// dequeue once more than its length
		for (int i = 0; i < queueSize + 1; i++) {
			queue.dequeue();
		}
		
	}

}
