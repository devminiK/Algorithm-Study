/* My Solution-1 */
import java.util.Arrays;

class Solution {
   public int[] solution(int[] array, int[][] commands) {
        int nCtn = commands.length;         // 반복해야하는 갯수
        int[] resultArr = new int[nCtn];    //결과를 담을 배열

        for (int i=0; i<nCtn; i++)
        {
            int nSize = commands[i][1] - commands[i][0] +1; //1차 구해야하는 배열 길이
            int[] aTmp = new int[nSize];    //임시 값 담을 배열tmp
            int idx = 0;                    //tmp에 입력할때 증가용idx

            for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
                if (nSize == 1) {
                    aTmp[idx] = array[commands[i][0]-1];
                    idx++;
                    break;
                }
                aTmp[idx] = array[j];
                idx++;
            }
            Arrays.sort(aTmp); //정렬
            resultArr[i] = aTmp[commands[i][2]-1];
        }
        return resultArr;
    }
}

/* My Solution-2
 * After knew the function named of copyOfRange */

import java.util.Arrays;

class Solution {
   public int[] solution(int[] array, int[][] commands) {
		//최종 결과를 담을 배열
        int[] resultArr = new int[commands.length];

        for (int i=0; i<commands.length; i++) {
        	//임시 값 담을 배열
        	int[] aTmp = new int[commands[i][1] - commands[i][0] +1];

        	aTmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
        	Arrays.sort(aTmp);
        	resultArr[i] = aTmp[commands[i][2]-1];
        }
        return resultArr;
    }
}

