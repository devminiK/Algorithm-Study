/*
 * n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
   
 * 처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다. 
 * 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다. 
 * 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.
 * 
 * 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
 * 
 * 입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때, 
 * 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 * 
 * [제한사항]
 * - 입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
 * - 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
 * - 심사관은 1명 이상 100,000명 이하입니다.
 */

/* solution */
import java.util.Arrays;

class Solution {
    public static long solution(int n, int[] times) {
	        // 모든 사람이 심사를 받는데 걸리는 시간의 최솟값
	        long answer = Long.MAX_VALUE;
	        long start = 0, 
	        	 end = Long.MAX_VALUE,
	        	 mid; // 심사를 받는데 주어진 시간
	        long sum; // sum : 주어진 시간(mid)동안 심사를 받을 수 있는 사람 수 
	        
	        Arrays.sort(times);//오름차순 정렬
	        
	        // 모든 사람이 심사 받는데 걸리는 시간 이분 탐색
	        while(start <= end) {
	            mid = (start + end) / 2;
	            sum = 0;
	            
	            // 주어진 시간동안 몇명 검사 할 수 있는지 누적 합
	            for(int i=0; i<times.length; i++) {
	                sum += mid / times[i];
	                
	                if (sum >= n) break;	
	            }
	            
	            /* 비교 대상(사람 수) */
	            // 검사 다 못할 때(시간 부족)
	            if (n > sum){
	                start = mid + 1;
	            }
	            // 검사 다 했을 때 (시간이 남음)
	            else {
	                end = mid - 1;
	                answer = Math.min(answer, mid); //최소 시간 찾기
	            }
	            
	        }
	        
	        return answer;
	    }
}
