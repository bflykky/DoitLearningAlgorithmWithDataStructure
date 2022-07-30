package chap04;

//Q3 문제.
public class shareStack {
	//스택의 공간을 정확히 나누지 않고, 유연하게 사용할 수 있도록 함.
	public int capacity;
	private int maxA;
	private int maxB;
	private int ptrA;
	private int ptrB;
	public int[] shareStk;

	public static class EmptyShareStackException extends RuntimeException {
		public EmptyShareStackException() {
		}
	}

	public static class OverflowShareStackException extends RuntimeException {
		public OverflowShareStackException() { }
	}

	public shareStack(int capacity) {
		this.capacity = capacity;
		ptrA = 0;
		ptrB = this.capacity - 1;
		maxA = this.capacity;
		maxB = this.capacity;
		try {
			shareStk = new int[this.capacity];
		}
		catch (OutOfMemoryError e) {
			maxA = maxB = 0;
		}
	}

	public int pushA(int x) throws OverflowShareStackException {
		if (ptrA >= maxA)
			throw new OverflowShareStackException();
		maxB--;
		return shareStk[ptrA++] = x;
	}
	public int pushB(int x) throws OverflowShareStackException {
		if (ptrB < sizeA())
			throw new OverflowShareStackException();
		maxA--;
		return shareStk[ptrB--] = x;
	}
//	스택을 공유할 때 절반씩 나눈 경우. 근데 이건 출제자가 원하는 구현이 아닐 거 같음.
//	public int pushA(int x) throws OverflowShareStackException {
//		if (ptrA >= maxA)
//			throw new OverflowShareStackException();
//		return shareStk[ptrA++] = x;
//	}
//
//	public int pushB(int x) throws OverflowShareStackException {
//		if (ptrB < maxB)
//			throw new OverflowShareStackException();
//		return shareStk[ptrB--] = x;
//	}

	public int popA() throws EmptyShareStackException {
		if (ptrA <= 0)
			throw new EmptyShareStackException();
		maxB++; //A스택이 하나 빠짐으로써 자리가 공유할 수 있는 공간이 됨.
		return shareStk[--ptrA];
	}

	public int popB() throws EmptyShareStackException {
		if (ptrB >= capacity - 1)
			throw new EmptyShareStackException();
		maxA++; //B스택이 하나 빠짐으로써 해당 인덱스가 공유할 수 있는 공간이 됨.
		return shareStk[++ptrB];
	}

	public int peekA() throws EmptyShareStackException {
		if (ptrA <= 0)
			throw new EmptyShareStackException();
		return shareStk[ptrA - 1];
	}

	public int peekB() throws EmptyShareStackException {
		if (ptrB >= capacity -1)
			throw new EmptyShareStackException();
		return shareStk[ptrB + 1];
	}

	public int indexOfA(int x) {
		for (int i = ptrA - 1; i >= 0; i--) {
			if (shareStk[i] == x)
				return i;
		}
		return -1;
	}

	public int indexOfB(int x) {
		for (int i = ptrB + 1; i <= capacity - 1; i++) {
			if (shareStk[i] == x)
				return i;
		}
		return -1;
	}

	public void clearA() {
		ptrA = 0;
	}

	public void clearB() {
		ptrB = capacity - 1;
	}

	public int capacityA() {
		return maxA;
	}

	public int capacityB() {
		return maxB;
	}

	public int sizeA() {
		return ptrA;
	}

	public int sizeB() {
		return (capacity - 1) - ptrB;
	}

	public boolean isEmptyA() {
		return ptrA <= 0;
	}

	public boolean isEmptyB() {
		return ptrB >= capacity - 1;
	}

	/*
	A, B 스택이 배열을 공유하므로,
	한쪽 스택이 가득 차면 다른 스택도 가득 차게 된다.
	따라서, isFull() 메소드는 하나만 구현하면 된다.
	 */
	public boolean isFull() {
		return sizeA() + sizeB() == capacity;
	}

	public void dumpA() {
		if (ptrA <= 0)
			System.out.println("스택A가 비어 있습니다.");
		else {
			for (int i = 0; i < ptrA; i++)
				System.out.println(shareStk[i] + " ");
			System.out.println();
		}
	}

	public void dumpB() {
		if (ptrB >= capacity - 1)
			System.out.println("스택B가 비어 있습니다.");
		else {
			for (int i = capacity - 1; i > ptrB; i--)
				System.out.println(shareStk[i] + " ");
			System.out.println();
		}
	}

}
