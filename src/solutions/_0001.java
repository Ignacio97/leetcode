package solutions;

import static java.lang.System.out;

import java.util.HashMap;

/** 
 *	>>Two Sum<<
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 */

public class _0001 {

	static class Solution {

		// first chance
		public static int[] bruteForce(int[] nums, int target) {

			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] + nums[j] == target) {
						return new int[] { i, j };
					}
				}
			}
			throw new RuntimeException("solution not found!!");

		}

		// second chance
		public static int[] headFirst(int[] nums, int target) {
			// needed num is the key then value the index.
			HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

			for (int i = 0; i < nums.length; i++) {

				if (cache.containsKey(nums[i]))
					return new int[] { cache.get(nums[i]), i };

				cache.put((target - nums[i]), i);
			}

			throw new RuntimeException("solution not found!!");

		}

		// given answer
		public int[] twoSum(int[] nums, int target) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++) {
				int complement = target - nums[i];
				if (map.containsKey(complement)) {
					return new int[] { map.get(complement), i };
				}
				map.put(nums[i], i);
			}
			throw new IllegalArgumentException("No two sum solution");
		}

	}

	//Main method
	public static void main(String[] args) {
		int[] array = { 0, 7, 11, 2 };
		int target = 9;
		int[] results = Solution.headFirst(array, target);

		out.println("Index 0: " + results[0]);
		out.println("Index 1: " + results[1]);

	}

}

//17-dec-2019 22:27
