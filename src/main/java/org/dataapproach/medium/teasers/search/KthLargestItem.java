package org.dataapproach.medium.teasers.search;

import java.util.Scanner;


/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * For example, given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * Java Solution 1
 * 
 * public int findKthLargest(int[] nums, int k) { Arrays.sort(nums); return
 * nums[nums.length-k]; } 
 * 
 * Time is O(nlog(n))
 * 
 * Java Solution 2
 * 
 * This problem can also be solve by using the quickselect approach, which is
 * similar to quicksort.
 * 
 * Average case time is O(n), worst case time is O(n^2).
 * 
 * @author sarath
 *
 */
public class KthLargestItem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input comma separated integers:");
		String x = in.next();

		String[] intStrs = x.split(",");

		int arrayLength = intStrs.length;

		int[] ints = new int[arrayLength];

		for (int i = 0; i < arrayLength; i++) {
			ints[i] = Integer.valueOf(intStrs[i]);
		}

		System.out.println("Input K value:");
		
		int k = in.nextInt();
		
		System.out.println("Kth largest # :"
				+ KthLargestItem.findKthLargest(ints, k ));

	}

	public static int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}

		return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
	}

	private static int getKth(int k, int[] nums, int start, int end) {

		int pivot = nums[end];

		int left = start;
		int right = end;

		while (true) {

			while (nums[left] < pivot && left < right) {
				left++;
			}

			while (nums[right] >= pivot && right > left) {
				right--;
			}

			if (left == right) {
				break;
			}

			swap(nums, left, right);
		}

		swap(nums, left, end);

		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}

	private static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
}
