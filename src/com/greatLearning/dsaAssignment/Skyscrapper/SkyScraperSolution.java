package com.greatLearning.dsaAssignment.Skyscrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SkyScraperSolution {

	static QueueUtils queueUtils;
	static Queue<Integer> queue = new LinkedList<>();
	static List<Integer> forRemainingElements = new ArrayList<>();
	static int availableFloorSize;

	private static void assembleOrder() {
		int day = 1;
		while (!queue.isEmpty()) {
			int max = queueUtils.findMaxQueueElement(queue);
			int poll = queue.poll();
			/*
			 * if current floor size is smaller than remaining elements
			 */
			if (poll < max) {
				/*
				 * adding elements in separate array list to display them at the end
				 */
				forRemainingElements.add(poll);
				System.out.println("Day " + day + " : " + " ");
			}
			/*
			 * if current floor size is maximum from remaining elements
			 */
			else if (poll == max) {
				/*
				 * if we have reached to last day where we need to display all remaining
				 * elements in decreasing order
				 */
				if (day == availableFloorSize) {
					System.out.print("Day " + day + " : " + poll + " ");
					Collections.sort(forRemainingElements, Collections.reverseOrder());
					for (int k = 0; k < forRemainingElements.size(); k++) {
						System.out.print(forRemainingElements.get(k) + " ");
					}
				} else {
					/*
					 * if we find greater size in between as compared to previous elements
					 */
					queue.remove(max);
					System.out.print("Day " + day + " : " + poll + " ");
					Collections.sort(forRemainingElements, Collections.reverseOrder());
					for (int j = 0; j < forRemainingElements.size(); j++) {
						if (forRemainingElements.get(j) > queueUtils.findMaxQueueElement(queue)) {
							System.out.print(forRemainingElements.get(j) + " ");
							forRemainingElements.remove(j);
							j--;
						}
					}
				}
				System.out.println();
			}
			day++;
		}
	}

	public static void main(String[] args) {
		queueUtils = new QueueUtils(queue);
		System.out.println("Enter the total no. of floors in the building :");
		Scanner scanner = new Scanner(System.in);
		availableFloorSize = scanner.nextInt();
		if (availableFloorSize > 0) {
			/*
			 * Inserting values having distinct size of floor
			 */
			for (int i = 0; i < availableFloorSize; i++) {
				System.out.println("Enter the floor size given on day : " + (i + 1));
				int floorSize = scanner.nextInt();
				if (floorSize > 0) {
					queueUtils.enque(floorSize);
				} else {
					System.out.println("Please enter some valid values!!!");
					System.exit(1);
				}
			}
			/*
			 * Displaying floor size according to way they will get assembled
			 */
			System.out.println("\nFloor sizes in descending order, which can be assembled : \n");
			assembleOrder();
		} else {
			System.out.println("Please enter some valid values!!!");
		}

	}

}