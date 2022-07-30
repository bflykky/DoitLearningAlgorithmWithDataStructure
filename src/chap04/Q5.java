package chap04;

public class Q5 extends IntQueue {
	public Q5(int capacity) {
		super(capacity);
	}

	public int search(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x)
				return i + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		Q5 test = new Q5(12);
		for (int i = 0; i < 7; i++) {
			test.enque(i);
		}
		for (int i = 0; i < 7; i++) {
			test.deque();
		}
		test.enque(35);
		test.enque(56);
		test.enque(24);
		test.enque(68);
		test.enque(95);
		test.enque(73);
		test.enque(19);

		System.out.println("search(35)의 출력 결과: " + test.search(35));
		System.out.println("search(56)의 출력 결과: " + test.search(56));
		System.out.println("search(99)의 출력 결과: " + test.search(99));
		System.out.println("search(19)의 출력 결과: " + test.search(19));
	}

}
