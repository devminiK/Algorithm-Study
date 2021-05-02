/**
  0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
  예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

  0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 
  순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

  [제한 사항]
  - numbers의 길이는 1 이상 100,000 이하입니다.
  - numbers의 원소는 0 이상 1,000 이하입니다.
  - 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
**/

/* my Solution 1 
  : 시간 초과 및 실패 사례(요소가 0인 경우)있었음 
*/
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
	        int[] aTmpArray = new int[numbers.length];
	        int nMaxIdx = 0;
	        int nMax = 0;			  //가장앞자리 숫자가 제일 큰 
	        int nMaxComp = 0;		//가장앞자리 숫자
	        int nMaxCompNam = 0;	//가장앞자리 숫자
	        String answer = ""; 	//결과 문자열
	        
	        Arrays.sort(numbers);   // 정렬
	        for(int j=0;j<numbers.length; j++) {
	        	for (int i=0; i<numbers.length; i++) {
		        	if(numbers[i]>=1000) {
		        		nMaxComp = numbers[i]/1000;
		        		nMaxCompNam = numbers[i]%1000;
		        	} else if(numbers[i]>=100) {
		        		nMaxComp = numbers[i]/100;
		        		nMaxCompNam = numbers[i]%100;
		        	} else if(numbers[i]>=10) {
		        		nMaxComp = numbers[i]/10;
		        		nMaxCompNam = numbers[i]%10;
		        	} else {
		        		nMaxComp = numbers[i];
		        		nMaxCompNam = numbers[i];
		        	}
		        	if (i == 0) {
		        		nMax = nMaxComp; //가장 처음 저장
		        	}
		        	if (nMaxComp>nMax) {
		        		nMax = nMaxComp;
		        		nMaxIdx = i;
		        	} else if (nMaxComp == nMax) {
		        		if(numbers[i]>numbers[nMaxIdx]) {
		        			if(nMaxCompNam>0) {
		        				nMax = nMaxComp;
				        		nMaxIdx = i;
		        			}
		        		}
		        	} 
		        }
	        	answer += numbers[nMaxIdx];
	        	numbers[nMaxIdx] = 0;
	        }

	        return answer;
	    }
}

/* my Solution 2 */
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static String solution(int[] numbers) {
		 	String answer = ""; 	//결과 문자열
		 	String[] aString = new String[numbers.length];	//string 배열
		 	
		 	for(int i=0;i<numbers.length;i++) {
		 		aString[i] = String.valueOf(numbers[i]);
		 	}

		 	Arrays.sort(aString, new Comparator<String>() {
		 		@Override
		 		public int compare(String a, String b) {
		 			return (b+a).compareTo(a+b); 	// 내림차<->오름차순 정렬(o1+o2).compareTo(o1+o2)
		 		}
		 	});
		 	
		 	    // 0값이 중복일경우, 첫번째값이 0이면 0을 리턴
	        if (aString[0].equals("0")) {
	        	return "0";
	        }
	        
	        for(String s: aString) {
	        	answer += s;
	        }
	        return answer;
	 }
}
