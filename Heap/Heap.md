# 04. 힙(Heap)

## 힙이란?  
삽입/삭제는 트리 구조이기 때문에 O(logN)이므로 매우 빠르다.   
보통 우선순위 큐가 힙으로 많이 구현되는데, 배열과 리스트보다 효율적이다.   

- 완전 이진 트리의 일종으로 우선순위 큐를 위하여 만들어진 자료구조
- 여러 개의 값들 중에서 최댓값이나 최솟값을 빠르게 찾아내도록 만들어진 자료구조
- 힙은 일종의 반정렬 상태(느슨한 정렬 상태)를 유지
- 큰 값이 상위 레벨에 있고 작은 값이 하위 레벨에 있다는 정도
- 간단히 말하면 부모 노드의 키 값이 자식 노드의 키 값보다 항상 큰(작은) 이진 트리를 말한다.
- 힙 트리에서는 중복된 값을 허용한다. (이진 탐색 트리에서는 중복된 값을 허용하지 않는다.)

## 힙의 종류
- **최대 힙(max heap)**   
	- 부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진 트리   
	- key(부모 노드) >= key(자식 노드)   
- **최소 힙(min heap)**   
	- 부모 노드의 키 값이 자식 노드의 키 값보다 작거나 같은 완전 이진 트리    
	- key(부모 노드) <= key(자식 노드)    

## 특징
- 구현의 용이함을 위해 시작 인덱스(root)는 1부터 시작한다.
- 각 노드와 대응되는 배열의 인덱스는 '불변'한다.
	1. 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스x2
	2. 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스x2 + 1
	3. 부모 노드 인덱스 = (자식 노드 인덱스-1) /2

## 사용방법   
```java
// 최소 힙
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.add(n);
minHeap.poll(n);
//최대 힙
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
maxHeap.add(n);
maxHeap.poll(n);
```

## 시간복잡도
힙 트리의 전체 높이가 거의 log₂n(완전 이진 트리이므로)이므로    
하나의 요소를 힙에 삽입/삭제할 때 힙을 재정비하는 시간이 log₂n만큼 소요   
**Insert** O(NlogN)   
**Delete** O(NlogN)   
**Search** O(1)   

## 장점
- 최악의 경우에도 O(NlogN) 으로 유지가 된다.   
- 힙의 특징상 부분 정렬을 할 때 효과가 좋다.   
- 힙 정렬이 가장 유용한 경우는 전체 자료를 정렬하는 것이 아니라 **가장 큰 값 몇개만 필요할 때** 이다.   

## 단점
- 일반적인 O(NlogN) 정렬 알고리즘에 비해 성능은 약간 떨어진다.   
- 한 번 최대힙을 만들면서 불안정 정렬 상태에서 최댓값만 갖고 정렬을 하기 때문에 안정정렬이 아니다.   

## 예
```java
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapExample {
	public static void main(String[] args) throws IOException{
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	    System.out.println("----MIN HEAP----");
	    runHeapTest(minHeap);
	    System.out.println();
	    
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	    System.out.println("----MAX HEAP----");
	    runHeapTest(maxHeap);
	}
	
	private static void runHeapTest(PriorityQueue<Integer> heap) {
		heap.add(1);
		heap.add(8);
		heap.add(5);
		heap.add(2);
		heap.add(3);
		heap.add(9);
		heap.add(10);
		
		while(!heap.isEmpty()) {
	    	System.out.print(heap.poll()+" ");
	    }
	}

}
```