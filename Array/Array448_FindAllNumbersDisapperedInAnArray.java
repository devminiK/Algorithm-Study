/*
  Given an array nums of n integers where nums[i] is in the range [1, n], 
  return an array of all the integers in the range [1, n] that do not appear in nums.
  Constraints:
    - n == nums.length
    - 1 <= n <= 105
    - 1 <= nums[i] <= n
*/

class Solution {
  public static List<Integer> findDisappearedNumbers(int[] nums) {
		/*
		 * 1) TreeSet을 이용한 중복제거 및 정렬시도->시간 제한문제
		 * 2) 직접 정렬 및 중복 제거-> 시간 제한문제
     * 3) 값 존재 여부 따지기 -> 성공
		 * */
		
    List<Integer> res = new ArrayList<Integer>();	//결과값 
		if(nums == null || nums.length == 0) {
      return res;
		}
		
		boolean[] tmp = new boolean[nums.length];
		for(int i=0;i<nums.length; i++) {
			tmp[nums[i]-1] = true;
		}

		for (int i=0; i<nums.length; i++) {
			if(!tmp[i]) {
				res.add(i+1);
			}
			
		}
		return res;	
	}
}
