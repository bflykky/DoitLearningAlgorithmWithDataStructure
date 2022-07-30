package chap04;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Q7
일반적으로 덱(deck)이라는 양방향 대기열(deque/double ended queue)은
아래 그림 처럼 시작과 끝 지점에서 양쪽으로 데이터를 인큐하거나 디큐하는 자료구조입니다.
양방향 대기열을 구현하는 클래스 IntDeque를 만드세요. 이때 덱에 저장하는 데이터의 자료형은 int형으로 합니다.

!! 문제 자체의 설명이 빈약하여, Java가 제공하는 컬렉션 프레임워크의 ArrayDeque 클래스를 보고 아이디어를 본따 만들었음.
링 버퍼를 사용한 것과 같이 head, tail이라는 변수를 사용하여 배열의 이동을 할 필요 없게 만듦.(단, addFirst() 메소드에선 필요했음.)
 */
public class Q7 {
	public static void main(String[] args) {
//		Deque<Integer> test = new ArrayDeque<>();
		deque test = new deque(8);
//		test.addFirst(1);
//		test.addFirst(2);
//		test.addFirst(3);
//		test.addFirst(4);
//		test.addFirst(5);
		//알 수 있는 점: addFirst()는 가장 처음 인덱스([0])에 파라미터 값을 저장하고, 원래 있던 요소들은 뒤로 밀어버린다
 		test.addLast(1);
		test.addLast(2);
		test.addLast(3);
		test.addLast(4);
		test.addLast(5);

//		test.add(1);
//		test.add(2);
//		test.add(3);
//		test.add(4);
		//알 수 있는 점: add()는 addLast()와 동일하다.

		System.out.println(test);
//		System.out.println(test.pollFirst());
//		System.out.println(test.pollFirst());
//		System.out.println(test.pollFirst());
//		System.out.println(test.pollFirst());
//		System.out.println(test.pollFirst());
		//pollFirst()는 앞의 인덱스(head로 추정.)[0]부터 값을 꺼낸다.

//		System.out.println(test.poll());
//		System.out.println(test.poll());
//		System.out.println(test.poll());
//		System.out.println(test.poll());
//		System.out.println(test.poll());
		//poll()은 pollFirst()와 동일하다.

		System.out.println(test.pollLast());
		System.out.println(test.pollLast());
		System.out.println(test.pollLast());
		System.out.println(test.pollLast());
		System.out.println(test.pollLast());
		//pollLast()는 가장 뒷 인덱스에 저장되어 있는 요소(꼬리로 추정)부터 꺼내온다.
	}

}

class deque {
	private int max;
	private int num;
	private int head;
	private int tail;
	int[] que;

	public class EmptyIntDequeException extends RuntimeException {
		public EmptyIntDequeException() {
		}
	}

	// 실행할 때 예외：큐가 가득 참
	public class OverflowIntDequeException extends RuntimeException {
		public OverflowIntDequeException() {
		}
	}

	public deque(int capacity) {
		max = capacity;
		num = head = tail = 0;
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	public void addFirst(int n) {
		if (num >= max)
			throw new OverflowIntDequeException();

		for (int i = num; i > head; i--)
			que[i] = que[i - 1];
		que[head] = n;
		num++;
		tail++;

		if (tail == max)
			tail = 0;
	}

	public void addLast(int n) {
		if (num >= max)
			throw new OverflowIntDequeException();

		que[tail++] = n;
		num++;

		if (tail == max)
			tail = 0;
	}

	public int pollFirst() {
		if (num <= 0)
			throw new EmptyIntDequeException();
		int result = que[head++];
		num--;
		if (head == max)
			head = 0;

		return result;
	}

	public int pollLast() {
		if (num <= 0)
			throw new EmptyIntDequeException();

		if (--tail < 0)
			tail = max - 1;
		num--;
		return que[tail];

	}

	@Override
	public String toString() {
		String str = "[ ";
		for (int i = head; i < tail; i++)
			str += que[i] + " ";
		str += "]";
		return str;
	}
}
