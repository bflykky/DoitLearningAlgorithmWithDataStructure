package chap05;

public class Q5 {
	public static void recur3(int n) {
//		재귀 메소드 이용.
		if (n > 0) {
			recur3(n - 1);
			recur3(n - 2);
			System.out.println(n);
		}
	}

	public static void nonRecur3(int n) {
//		비재귀적으로 구현.
		/* 07.29 22:24
		엉터리로 풀려있던 거임. 답만 맞음. 재귀호출로 인한 하위 메소드(r(n-1), r(n-2), print(n))가 끝난 뒤에,
		상위 메소드로 올라와서 해당 상위 메소드의 두번째 메소드(r(n-2))를 풀기 위해 n에 n-2값이 되는 값을 지정해야 하는데
		해당 과정이 없음. 그런데 답은 맞게 나옴. 이 ************************************엉터리 풀이 짜놓고 뿌듯해하고 있었네
		 */
		IntStack ps = new IntStack(n);
		IntStack step = new IntStack(n);

		int nowStep = 0;
		while (true) {
			if (n > 0) {
				ps.push(n);
				step.push(nowStep);
				if (nowStep == 0)
					n = n - 1;
				else if (nowStep == 1) {
					n = n - 2;
					nowStep = 0;
				}
				continue;
			}

			do {
				n = ps.pop();
				nowStep = step.pop() + 1;

				if (nowStep == 2) {
					System.out.println(n);
					if (ps.isEmpty())
						return;
				}

			} while (nowStep == 2);

		}

	}

	public static void main(String[] args) {

		System.out.println("input: 3");
		recur3(3);
		System.out.println("--------------------------------");
		nonRecur3(3);

		System.out.println();
		System.out.println();

		System.out.println("input: 4");
		recur3(4);
		System.out.println("--------------------------------");
		nonRecur3(4);

		System.out.println();
		System.out.println();

		System.out.println("input: 5");
		recur3(5);
		System.out.println("--------------------------------");
		nonRecur3(5);
	}
}
