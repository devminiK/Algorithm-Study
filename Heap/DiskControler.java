/*
* 하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 
* 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 
* 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
* - A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms)
* - B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms)
* - C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms)
* 이 때 각 작업의 요청부터 종료까지 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.
* 
* 하지만 A → C → B 순서대로 처리하면
* 
* - A: 3ms 시점에 작업 완료(요청에서 종료까지 : 3ms)
* - C: 2ms부터 대기하다가, 3ms 시점에 작업을 시작해서 9ms 시점에 작업 완료(요청에서 종료까지 : 7ms)
* - B: 1ms부터 대기하다가, 9ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 17ms)
* 이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.
* 
* 각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 
* 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. 
* (단, 소수점 이하의 수는 버립니다)
* 
* [제한 사항]
* jobs의 길이는 1 이상 500 이하입니다.
* jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
* 각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
* 각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
* 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
*/

/* my solution 1 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static int solution(int[][] jobs) {
		 int answer = 0; 	// 최단 소요 평균시간
		 int endPoint = 0; 	// 수행되고난 종료 시점
		 int jobsIdx = 0; 	// jobs 배열의 인덱스
		 int count = 0; 	// 수행된 요청 갯수
		 
		 // `요청시간` 순으로 오름차순 정렬
		 Arrays.sort(jobs, new Comparator<int[]>() {
			 @Override
			 public int compare(int[] o1, int[] o2) {
				 if (o1[0] == o2[0]) {
					 return o1[0] - o2[0];
				 } else {
					 return o1[0] - o2[0];
				 }
			 }
			
		 });
		 
		 // `실행 시간` 오름차순로 정렬
		 PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					 return o1[1] - o2[1];
				 } else {
					 return o1[1] - o2[1];
				 }
			}
				 
		});
		 
		// 요청이 모두 수행될 때까지 반복
		while (count < jobs.length) {
			
			// 하나의 작업이 완료되는 시점(endPoint)까지 들어온 모든 요청을 큐에 넣음
			while ((jobsIdx < jobs.length) && (jobs[jobsIdx][0] <= endPoint)) {
				queue.add(jobs[jobsIdx++]);
				
			}
			
			// 큐가 비어있다면 종료 시점(endPoint) 이후에 다시 요청이 들어온다는 의미
			// (end를 요청의 가장 처음으로 맞춰줌)
			if (queue.isEmpty()) {
				endPoint = jobs[jobsIdx][0];
				
			} 
			// 작업이 끝나기 전(endPoint 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
			else {
				int[] temp = queue.poll();
				
				// (종료시점 - 요청시점) + 수행시간
				answer += (endPoint - temp[0]) + temp[1];
				// 종료 시점
				endPoint += temp[1];					
				
				// 실행 횟수
				count++;
			}
		}
		return (int) Math.floor(answer/count);
    }
}