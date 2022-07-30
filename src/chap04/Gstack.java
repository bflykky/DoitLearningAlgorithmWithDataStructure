package chap04;

public class Gstack<E> {
	private int max;
	private int ptr;
	private E[] stk;

	public static class EmptyGStackException extends RuntimeException {
		public EmptyGStackException() {
		}
	}

	public static class OverflowGSStackException extends RuntimeException {
		public OverflowGSStackException() { }
	}

	public Gstack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = (E[])new Object[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	public E push(E x) throws OverflowGSStackException {
		if (ptr >= max)
			throw new OverflowGSStackException();

		return stk[ptr++] = x;
	}

	public E pop() throws EmptyGStackException {
		if (ptr <= 0)
			throw new EmptyGStackException();

		return stk[--ptr];
	}

	public E peek() throws EmptyGStackException {
		if (ptr <= 0)
			throw new EmptyGStackException();

		return stk[ptr - 1];
	}



}
