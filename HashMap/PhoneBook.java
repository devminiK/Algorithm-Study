/*
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 * 
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 
 * 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 * 
 * [제한 사항]
 * - phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * - 각 전화번호의 길이는 1 이상 20 이하입니다.
 * - 같은 전화번호가 중복해서 들어있지 않습니다.
 */

/* my solution 1: hash사용 x, 시간초과 된 풀이 */
import java.util.*;
class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        //문자열 길이로 정렬
        Arrays.sort(phone_book, Comparator.comparing(String::length));
        
        for(int i=0; i<phone_book.length; i++) {
        	for(int j=0; j<phone_book.length; j++) {
	        	if(phone_book[i].startsWith(phone_book[j]) && (!phone_book[i].equals(phone_book[j]))) {
	        		answer=false;
	        		break;
	        	}
        	}
        }
        return answer;
    }
}

/* my solution 2: hash사용 (containsKey이 사용 이유)*/
import java.util.*;
public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String,Integer> hm = new HashMap<>();
        for (String pb : phone_book) hm.put(pb, 0);
        
        for (String hk : hm.keySet()) {
        	for(int idx=0; idx<hk.length(); idx++) {
        		if (hm.containsKey(hk.substring(0, idx))) {
        			answer=false;
        			break;
        		}
        	}
        }
        return answer;
    }