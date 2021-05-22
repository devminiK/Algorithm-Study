= 06. 해시(Hash)

## 특징
- key값은 중복이 불가능, value는 null값을 포함한 value로 중복이 가능하다.     
  (데이터가 중복된 키와 값을 저장하면, 기존의 값은 없어지고 마지막에 저장된 값이 남게됨)   
- 멀티쓰레드에서 동시에 HashMap을 건드려 Key-value값을 사용하면 문제가 될 수 있다.      
  멀티쓰레드에서는 HashMap이라는 것을 사용한다.   
- HashTable, HashMap, LinkedHashMap, SortedMap, TreeMap 등 존재     

## 장점
- 많은 양의 데이터를 검색하는데 뛰어난 성능을 가지고있다.   

## 단점
- 저장이 느리다.   

## 예
```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapExample {
	public static void main(String[] args) {
		HashMap<String,String> map1 = new HashMap<String,String>();	//HashMap생성
		HashMap<Integer,String> map2 = new HashMap<>();				//new에서 타입 파라미터 생략가능
		HashMap<String,String> map3 = new HashMap<>(map1);			//map1의 모든 값을 가진 HashMap생성
		HashMap<String,String> map4 = new HashMap<>(10);			//초기 용량(capacity)지정
		HashMap<String,String> map5 = new HashMap<>(10, 0.7f);		//capacity,load factor지정
		HashMap<String,String> map6 = new HashMap<String,String>(){{//초기값 지정
		    put("a","b");
		}};
		
		map2.put(1,"Apple");	//값 추가
		map2.put(2, "Banana");
		map2.put(3, "Lemon");
		map2.remove(2); 		//해당 key값 제거
//		map2.clear(); 			//모든 값 제거
		
		System.out.println(map2);
		//[1] entrySet을 이용한 요소 확인
		for (Entry<Integer, String> entry : map2.entrySet()) {
		    System.out.println("[Key:" + entry.getKey() + " | Value:" + entry.getValue()+"]");
		}
		System.out.println();
		
		//[2] keySet을 이용한 요소 확인
		for(Integer i : map2.keySet()) {
			System.out.println("[key:"+i+" | value:"+map2.get(i)+"]");
		}
		System.out.println();
		
		//[3] entrySet().iterator()을 이용한 요소 확인
		Iterator<Entry<Integer, String>> entries = map2.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry<Integer, String> entry = entries.next();
		    System.out.println("[Key:" + entry.getKey() + " | Value:" +  entry.getValue()+"]");
		}
		System.out.println();
		
		//[4] keySet().iterator()을 이용한 요소 확인
		Iterator<Integer> keys = map2.keySet().iterator();
		while (keys.hasNext()) {
		    int key = keys.next();
		    System.out.println("[Key:" + key + " | value:" +  map2.get(key)+"]");
		}
	}
}
```