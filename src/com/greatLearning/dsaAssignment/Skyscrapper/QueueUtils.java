package com.greatLearning.dsaAssignment.Skyscrapper;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Helper class to get methods to implement enqueue 
 * and finding maximum number
 */
public class QueueUtils {
	Queue<Integer> queue;
	Deque<Integer> dq;

	/*
	 * Passing value of queue through constructor
	 */
	public QueueUtils(Queue<Integer> queue) {
		this.queue = queue;
		queue = new LinkedList<>();
		dq = new ArrayDeque<>();
	}

	void enque(int data) {
		while (!dq.isEmpty() && dq.getLast() < data) {
			dq.removeLast();
		}
		dq.addLast(data);
		queue.add(data);
	}

	/*
	 * return current maximum within the passed Queue elements
	 */
	public Integer findMaxQueueElement(Queue<Integer> queue) {
		Integer max = queue.remove();
		queue.add(max);
		for (int i = 0; i < queue.size() - 1; i++) {
			Integer current = queue.remove();
			if (current.compareTo(max) > 0) {
				max = current;
			}
			queue.add(current);
		}
		return max;
	}

}
