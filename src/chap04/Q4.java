package chap04;

public class Q4 {
	private int max;
	private int num;
	private int[] que;

	public Q4(int capacity) {
		max = capacity;
		num = 0;
		try { que = new int[max]; }
		catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
		}
	}

	// 실행할 때 예외：큐가 가득 참
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
		}
	}

	public int enque(int x) throws OverflowIntQueueException {
		if (num >= max)
			throw new OverflowIntQueueException();

		return que[num++] =x;
	}

	public int deque() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();

		int x = que[0];

		for (int i = 0; i < num - 1; i++) {
			que[i] = que[i+1];
		}
		num--;
		return x;
	}

	public int peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		return que[0];
	}

	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			if (que[i] == x)
				return i;
		}
		return -1;
	}

	public void clear() {
		num = 0;
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return num;
	}

	public boolean isEmpty() {
		return num <= 0;
	}

	public boolean isFull() {
		return num >= max;
	}

	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.println(que[i] + " ");
			System.out.println();
		}
	}

}
