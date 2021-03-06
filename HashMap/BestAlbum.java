/*
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
 * 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 * 
 * [제한사항]
 * - genres[i]는 고유번호가 i인 노래의 장르입니다.
 * - plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * - genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * - 장르 종류는 100개 미만입니다.
 * - 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * - 모든 장르는 재생된 횟수가 다릅니다.
 */

/* getOrDefault, compareTo를 이용한 풀이 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static int[] solution(String[] genres, int[] plays) { 
		int[] answer = {}; 
		ArrayList<Integer> ansList = new ArrayList<>(); //최종 결과
		
		// [1] 장르별 plays 수 합산하기
		HashMap<String, Integer> hmGenres = new HashMap<>(); 
		for(int i =0; i< genres.length; i++) { 
			hmGenres.put(genres[i], hmGenres.getOrDefault(genres[i],0)+plays[i]); 
		} 
		
		// [2] 2번째 값(합산값) 으로 정렬
		List<String> keySetList = new ArrayList<>(hmGenres.keySet()); //장르가 key
		Collections.sort(keySetList, (o1, o2) -> (hmGenres.get(o2).compareTo(hmGenres.get(o1)))); 
		
		for (String key : keySetList) { 
			HashMap<Integer, Integer> hm = new HashMap<>(); 

			for(int i = 0; i<genres.length; i++) { 
				//정렬된 장르순부터 고유값 저장
				if (key.equals(genres[i])) { 
					hm.put(i, plays[i]); 
				} 
			}
			
			// 키(고유값)기준 내림차순
			List<Integer> keyLists = new ArrayList<>(hm.keySet()); 
			keyLists.sort((s1, s2)->hm.get(s2).compareTo(hm.get(s1)));
			
			int j = 0; 
			for (Integer c : keyLists) { 
				if(j>=2) break; // (조건) 2곡만 저장할 것
				ansList.add(c); j++; 
			} 
		} 
		
		answer = new int[ansList.size()]; 
		for (int i =0; i<ansList.size(); i++) { 
			answer[i] = ansList.get(i); 
		}
		 
		return answer; 
	}
}