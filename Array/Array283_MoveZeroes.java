/*
  Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
  [Note] that you must do this in-place without making a copy of the array.
*/
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {
	public static void moveZeroes(int[] nums) {
		int arrLen = nums.length;	  // length of array
		int zeroCnt = 0;			      // count of zero
		int changeIdx = 0;			    // the index to which the value will be moved
		//moveZeroes
		for (int i=0;i<arrLen; i ++) {
			if (nums[i]!=0) {
				nums[changeIdx++] = nums[i];
			} else {
				zeroCnt++;
			}
		}
		
		int setZero = arrLen-1;	    // end of array index
		for(int j=0;j<zeroCnt;j++) {
			nums[setZero--] = 0;
		}
		
		
		// printArray
		for(int i=0; i<arrLen; i++) {
			if (i==0) {
				System.out.print("["+nums[i]+",");
			} else if (i == arrLen-1) {
				System.out.print(nums[i]+"]");
			} else {
				System.out.print(nums[i]+",");
			}
		}
        
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.substring(1);
		str = str.substring(0,str.length()-1);
		
		int[] splitNum = Stream.of(str.split(",")).mapToInt(Integer::parseInt).toArray();
		moveZeroes(splitNum);
	}
}
