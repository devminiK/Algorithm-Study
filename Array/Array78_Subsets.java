	/*
	 * Given an integer array nums of unique elements, return all possible subsets
	 * (the power set). The solution set must not contain duplicate subsets. Return
	 * the solution in any order. 1 <= nums.length <= 10 -10 <= nums[i] <= 10 All
	 * the numbers of nums are unique.
	 */
import java.util.ArrayList;
import java.util.List;

class Solution {
	public static List<List<Integer>> subsets(int[] nums) {
		// 결과
		List<List<Integer>> res = new ArrayList<>();
		// 빈 배열 추가
		res.add(new ArrayList<>());

		for (int i : nums) {
			List<List<Integer>> temp = new ArrayList<>();
			
			for (List<Integer> list : res) {
				List<Integer> newlist = new ArrayList<>();
				newlist.addAll(list);
				newlist.add(i);
				temp.add(newlist);
			}
			res.addAll(temp);
		}
		return res;
	}

}
