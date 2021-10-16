package com.greatLearning.dsaAssignment.Skyscrapper;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SkyScrapperSolution {

	static Queue<Integer> queue;
	Deque<Integer> dq;
	List<Integer> forRemainingElements = new ArrayList<>();
	boolean status = false;
	static int availableFloorSize;

	public SkyScrapperSolution() {
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

	private void constructionOrder() throws Exception {
		int day = 1;

		while (!queue.isEmpty()) {
			int max = findMaxQueueElement(queue);

			int poll = queue.poll();
			if (poll < max) {

				forRemainingElements.add(poll);

				System.out.println("Day " + day + " : " + " - ");

			}

			else if (poll == max) {

				if (day == availableFloorSize) {

					System.out.print("Day " + day + " : " + poll + " ");
					Collections.sort(forRemainingElements, Collections.reverseOrder());
					for (int k = 0; k < forRemainingElements.size(); k++) {
						System.out.print(forRemainingElements.get(k) + " ");

					}
				} else {
					queue.remove(max);
					System.out.print("Day " + day + " : " + poll + " ");
					Collections.sort(forRemainingElements, Collections.reverseOrder());
					for (int j = 0; j < forRemainingElements.size(); j++) {

						if (forRemainingElements.get(j) > findMaxQueueElement(queue)) {
							System.out.print(forRemainingElements.get(j) + " ");
							forRemainingElements.remove(j);
							j--;
						}

						System.out.println();
					}

				}
			} else {
				status = true;
			}
			day++;

		}
	}

	public static Integer findMaxQueueElement(Queue<Integer> queue) { // my test would ask me to return the max value
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

	public static void main(String[] args) throws Exception {
		SkyScrapperSolution arr = new SkyScrapperSolution();

		System.out.println("Enter the total no. of floors in the building :");
		Scanner scanner = new Scanner(System.in);
		availableFloorSize = scanner.nextInt();

		for (int i = 0; i < availableFloorSize; i++) {
			System.out.println("Enter the floor size given on day : " + (i + 1));
			int floor = scanner.nextInt();
			arr.enque(floor);

		}

		System.out.println("The order of construction is as follows : \n");
		arr.constructionOrder();

	}

}