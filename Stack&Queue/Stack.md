# 02. 스택 (Stack)
![stack-1](./img/stack-1.png)
## 특징
블록을 아래에서 부터 위로 쌓아 올리는 구조를 가지고 있다.
가장 마지막에 삽입한 데이터를 가장 먼저 사용하게 된다.
스택은 추상자료형(Abstract Data Type)으로 수학적 모델을 가졌으며 구현 방법을 따로 명시하고 있지 않다는 점에서 자료구조와 차이를 보인다.
이러한 특징은 다양한 방법으로 구현될 수 있음을 의미한다.

> 한 쪽 끝에서만 자료를 넣고 뺄 수 있는 **LIFO(Last In First Out)형식의 자료 구조**

## 사용방법
**java 라이브러리 스택(Stack) 관련 메서드**
- push(E item)
        item 하나를 스택의 가장 윗 부분(top)에 **추가**
        Vector의 addElement(item)과 동일
- pop()
        스택의 top에 있는 item을 **제거** 하고 해당 item을 반환
- peek()
		스택의 가장 위에 있는 항목(top)을 **반환** 한다. 이때 top의 변화는 없음
        Stack의 top에 있는 item을 삭제하지않고 해당 item을 반환
- empty()
        스택이 비어있으면 true 반환, 그렇지않으면 false반환
- clear()
        스택에 저장된 모든 데이터를 삭제하고 스택을 초기화
- size()
        스택의 크기 출력
- contains(E item)
        item이 스택에 존재하는지 하면 true반환, 그렇지 않으면 false반환
- search(Object o)
        해당 Object의 위치를 반환

- 예외처리 : EmptyStackException, 스택안에 값이 없을 경우 발생한다. st.isEmpty()를 이용해 예외처리를 한다.



```java
import java.util.Stack;
/*...*/
//Stack<E> st=new Stack<E>();
Stack<Integer> st=new Stack<Integer>();
/*...*/
```

## 시간복잡도
Insertion O(1)
Deletion O(1)
Search O(n)

> 삭제나 삽입시 맨 위에 데이터를 삽입하거나 삭제하기 때문에 시간복잡도는 늘 O(1) 의 시간복잡도를 가진다.
> 하지만 특정 데이터를 찾을 때는 특정 데이터를 찾을 때까지 수행을 해야하므로 O(n) 의 시간 복잡도를 가진다.

## 장점
- 데이터의 삽입과 삭제가 빠르다. (맨 위 원소 접근 O(1))

  ## 단점
- 탐색을 하려면 원소를 하나하나 꺼내서 옮겨가면서 해야함.
- 맨 위의 원소만 접근 가능하다.
## 배열의 사용
재귀 알고리즘을 사용하는 경우 스택이 유용하다.

- 재귀 알고리즘
        - 재귀적으로 함수를 호출해야 하는 경우에 임시 데이터를 스택에 넣어준다.
        - 재귀함수를 빠져 나와 퇴각 검색(backtrack)을 할 때는 스택에 넣어 두었던 임시 데이터를 빼 줘야 한다.
        - 스택은 이런 일련의 행위를 직관적으로 가능하게 해 준다. 또한 스택은 재귀 알고리즘을 반복적 형태(iterative)를 통해서 구현할 수 있게 해준다.
- 웹 브라우저 방문기록 (뒤로가기)
- 실행 취소 (undo)
- 역순 문자열 만들기
- 수식의 괄호 검사 (연산자 우선순위 표현을 위한 괄호 검사)
        Ex) 올바른 괄호 문자열(VPS, Valid Parenthesis String) 판단하기
- 후위 표기법 계산

## 예

```java
import java.util.Stack;

public class ArrayStack2 {
    public static void main(String[] args) {
    	Stack<Integer> stack = new Stack<>(); //int형 스택 선언
    	
    	stack.push(1);
    	stack.push(2);
    	stack.push(3);
    	stack.pop();
    	for(int el : stack) {
    		System.out.print("["+el+"]");
    	}
    	System.out.println();
    }   
}
```
