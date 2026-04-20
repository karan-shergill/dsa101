// https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261

// RECURSIVE
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		return maximumNonAdjacentSum(nums, nums.size() - 1);
	}

	private static int maximumNonAdjacentSum(ArrayList<Integer> nums, int currIndex) {
		if (currIndex < 0) {
			return 0;
		}

		// don't pick curr index element
		int dontPick = maximumNonAdjacentSum(nums, currIndex - 1);

		// pick curr index element
		int pick = maximumNonAdjacentSum(nums, currIndex - 2) + nums.get(currIndex);

		return Math.max(pick, dontPick);
	}
}

// TOP DOWN
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int[] cache = new int[nums.size() + 1];
		Arrays.fill(cache, -1);
		return maximumNonAdjacentSum(nums, nums.size() - 1, cache);
	}

	private static int maximumNonAdjacentSum(ArrayList<Integer> nums, int currIndex, int[] cache) {
		if (currIndex < 0) {
			return 0;
		}

		if (cache[currIndex] != -1) {
			return cache[currIndex];
		}

		// don't pick curr index element
		int dontPick = maximumNonAdjacentSum(nums, currIndex - 1, cache);

		// pick curr index element
		int pick = maximumNonAdjacentSum(nums, currIndex - 2, cache) + nums.get(currIndex);

		cache[currIndex] = Math.max(pick, dontPick);
		return cache[currIndex];
	}
}
