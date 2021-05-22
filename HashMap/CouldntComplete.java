/*
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 *  완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 * 
 * [제한사항]
 * - 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * - completion의 길이는 participant의 길이보다 1 작습니다.
 * - 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * - 참가자 중에는 동명이인이 있을 수 있습니다.
 * 
 */
 
/* my solution 1 : 해시 사용x, 배열의 길이 차이가 1인것을 이용한 풀이 */
import java.util.Arrays;
class Solution {
    public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);	

		for (int i=0; i<completion.length; i++) {
			if (!(participant[i].equals(completion[i]))) {
				answer = participant[i];
				break;
			}
		}
		if (answer == "") {
			answer = participant[participant.length-1];
		}
	     return answer;
	 }
}

/* 다른사람 풀이 */
/* 나는 iterator을 이용하여, 
 * 반복문 내에서 값이 같을 경우, remove형식으로 구현하려했는데, 
 * 아래와 같이 간단한 방법이 있었다 
 */
public static String solution(String[] participant, String[] completion) {
		String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        
		for (String pt : participant) 
        	hm.put(pt, hm.getOrDefault(pt, 0) + 1);
        for (String cp : completion) 
        	hm.put(cp, hm.get(cp) - 1);

        
		for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        
		return answer;
	}    


