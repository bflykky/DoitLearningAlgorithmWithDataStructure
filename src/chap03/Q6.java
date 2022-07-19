package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("요솟수: ");
		int num = s.nextInt();
		int[] x = new int[num];

		System.out.println("오름차순으로 입력하세요.");
		System.out.println("x[0]: ");
		x[0] = s.nextInt();

			for (int i = 1; i < num; i++) {
				do {
					System.out.printf("x[%d]: ", i);
					x[i] = s.nextInt();
				} while ( x[i - 1] > x[i] );
			}

		System.out.print("검색할 값: ");
		int key = s.nextInt();

		int idx = Arrays.binarySearch(x, key);

		if (idx < 0) {
			System.out.println("검색한 값이 존재하지 않습니다.");
			System.out.printf("반환된 삽입 포인트: %d", -(idx + 1));
		}

	}
}
