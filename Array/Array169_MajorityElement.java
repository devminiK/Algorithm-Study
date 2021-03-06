/*
  Given an array nums of size n, return the majority element.
  The majority element is the element that appears more than ⌊n / 2⌋ times. 
  You may assume that the majority element always exists in the array.
*/

import java.util.*;

class Solution {
	public static int majorityElement(int[] nums) {
    		int result = 0;
    	
		Arrays.sort(nums);
		for(int i=0 ;i<nums.length; i++) {
			if(nums.length/2 == i) {
				result = nums[i];
			}
		}
		return  result;
    	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.substring(8);
		str = str.substring(0,str.length()-1);
		
		int[] splitNum = Stream.of(str.split(",")).mapToInt(Integer::parseInt).toArray();
		System.out.println(majorityElement(splitNum));
	}
}
